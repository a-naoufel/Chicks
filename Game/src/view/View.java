package view;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JComponent;
import javax.swing.JFrame;

import game.Game;
import terrain.blockes.Cell;

public class View extends JComponent implements IObsover {
    public JFrame frame;
    private Game game;
    private int ofSet = 35;
    private Graphics g ;

    public View(Game game) {
        this.game = game;
        frame = new JFrame("Penguins");
        frame.setDefaultCloseOperation(0);
        frame.setSize(1000, 515);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        frame.setContentPane(this);
        game.addObserver(this);
    }

    public Graphics getGraphics(){
        return g;
    }

    public int getHeight() {
        return frame.getHeight() - ofSet;
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

    @Override
    protected void paintComponent(Graphics g) {
        this.g = g;
        super.paintComponent(g);
        game.draw(this);

    }

    public void drawTrangle(Cell c) {
        int X = getWidth() * c.getX() / gridSizeX();
        int Y = getHeight() * (c.getY()- 1) / gridSizeY();
        int[] Xs = { X, X + 20, X + 10 };
        int[] Ys = { Y, Y, Y - 20 };
        g.fillPolygon(Xs, Ys, 3);
    }

    public void drawSquare(Cell c) {
        g.fillRect(getWidth() * c.getX() / gridSizeX(), getHeight() * c.getY() / gridSizeY(), c.getSize(), c.getSize());
    }
    public void setColor(Color c){
        g.setColor(c);
    }

    @Override
    public void update() {
        repaint();
    }

}
