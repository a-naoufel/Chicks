package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import javax.swing.JComponent;
import javax.swing.JLabel;

import controle.StateControls;
import controle.keysBoard;
import game.Game;
import poussin.Poussin;
import terrain.blockes.Cell;

public class View extends JComponent implements IObsover {
    public MyFrame frame;
    private Game game;
    private int ofSetY = 35;
    private Graphics g;
    private Poussin selectedPoussin;
    private int ofSet = 100;
    private JLabel counterLabel;
    private int pixelSize = 31;
    private StateControls controls;

    public View(Game game,StateControls controls) {
        this.game = game;
        this.controls = controls;
        frame = new MyFrame(this);
        frame.reSize(gridSizeX(), gridSizeY());
        frame.add(this, java.awt.BorderLayout.CENTER);
        controls.setView(this);
        this.setFocusable(true);

        InstructionPanal instructionPanel = new InstructionPanal(this);
        instructionPanel.addKeyListener(new keysBoard(this));

        counterLabel = new JLabel(game.poussins.displayCounter());
        counterLabel.setFont(new Font("SansSerif", Font.BOLD, 16));
        instructionPanel.add(counterLabel);
        frame.add(instructionPanel, BorderLayout.SOUTH);
        instructionPanel.addKeyListener(new keysBoard(this));
        
        frame.setVisible(true);

        game.addObserver(this);
    }

    public Poussin getSelectedPoussin() {
        return selectedPoussin;
    }

    
    public void selectPoussin(Poussin poussin) {
        selectedPoussin = poussin;
    }
    

    public int getHeight() {
        return frame.getHeight() - ofSetY - ofSet;
    }

    public int getWidth() {
        return frame.getWidth();
    }

    public int gridSizeX() {
        return game.getTerrain().gridSizeX();
    }

    public int gridSizeY() {
        return game.getTerrain().gridSizeY();
    }

    public void setColor(Color c) {
        g.setColor(c);
    }

    @Override
    protected void paintComponent(Graphics g) {
        this.g = g;
        super.paintComponent(g);
        game.draw(this);
        frame(selectedPoussin);

    }

    public void drawTrangle(Cell c) {
        int X = getWidth() * c.getX() / gridSizeX();
        int Y = getHeight() * (c.getY() - 1) / gridSizeY();
        int[] Xs = { X, X + pixelSize, X + pixelSize / 2 };
        int[] Ys = { Y, Y, Y - pixelSize };
        g.fillPolygon(Xs, Ys, 3);
    }

    public void drawSquare(Cell c) {
        g.fillRect(getWidth() * c.getX() / gridSizeX(), getHeight() * c.getY() / gridSizeY(), pixelSize, pixelSize);
    }

    public void drawBaddy(int x, int y) {
        g.fillOval(getWidth() * x / gridSizeX(), getHeight() * y / gridSizeY(), pixelSize, pixelSize);
    }

    public void drawHead(int x, int y, int direction) {
        int headSize = pixelSize * 3 / 4;
        g.fillOval(getWidth() * x / gridSizeX() + pixelSize / 5,
                getHeight() * y / gridSizeY() - headSize + 1, headSize, headSize);
        drawPic(x, y, direction);
        drawEye(x, y, direction);

    }

    private void drawEye(int x, int y, int direction) {
        setColor(Color.BLACK);
        int headSize = pixelSize * 3 / 4;
        g.fillOval(getWidth() * x / gridSizeX() + ((3 + direction) * pixelSize / 6),
                getHeight() * y / gridSizeY() - 2 * headSize / 3, headSize / 4, headSize / 4);

    }

    private void drawPic(int x, int y, int direction) {
        int picLength = pixelSize * 3 / 4;

        int x1 = (getWidth() * x / gridSizeX()) + pixelSize / 2;
        int x3 = (getWidth() * x / gridSizeX()) + pixelSize / 2 + direction * picLength;
        int y1 = (getHeight() * y / gridSizeY()) - pixelSize + picLength;

        int[] XPoints = { x1, x1, x3 };
        int[] Ypoints = { y1 - pixelSize / 4, y1 + pixelSize / 4, y1 };
        g.fillPolygon(XPoints, Ypoints, 3);

    }

    public void frame(Poussin poussin) {
        if (selectedPoussin == null)
            return;
        if (!selectedPoussin.isAlive())
            return;

        int x1 = (getWidth() * poussin.getX() / gridSizeX());
        int x3 = x1 + pixelSize + 2;
        int y1 = (getHeight() * poussin.getY() / gridSizeY()) - pixelSize;
        int y2 = (getHeight() * poussin.getY() / gridSizeY()) + pixelSize;

        int[] XPoints = { x1, x1, x3, x3 };
        int[] Ypoints = { y1, y2, y2, y1 };
        g.drawPolygon(XPoints, Ypoints, 4);
    }

    @Override
    public void update() {
        counterLabel.setText(game.poussins.displayCounter());
        repaint();
    }

    public Poussin getPoussinClicked(int x, int y) {
        return game.getPoussinClicked(x, y);
    }

    public StateControls getControls() {
       return controls;
    }

}
