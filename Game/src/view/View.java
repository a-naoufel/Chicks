package view;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;

import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JPanel;

import game.Game;
import poussin.Poussin;
import poussin.state.BloqueurState;
import poussin.state.BombeurState;
import poussin.state.CharpentierState;
import poussin.state.ForeurState;
import poussin.state.GrimpeurState;
import poussin.state.NormalState;
import poussin.state.PoussinState;
import terrain.blockes.Cell;

public class View extends JComponent implements IObsover {
    public JFrame frame;
    private Game game;
    private int ofSet = 35;
    private Graphics g ;
    private String selectedState="Normal";



    public View(Game game) {
        this.game = game;
        frame = new JFrame("Penguins");
        //frame.setDefaultCloseOperation(0);
        frame.setSize(1000, 515);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setFocusable(true);
        frame.add(this, java.awt.BorderLayout.CENTER);
        frame.setVisible(true);
        frame.setContentPane(this);

        

        this.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                char keyChar = e.getKeyChar();
                if (keyChar == 'b' || keyChar == 'B') {
                    selectedState = "Bombeur"; 
                    System.out.println("State changed to Bombeur");
                } else if (keyChar == 'l' || keyChar == 'L') {
                    selectedState = "Bloquer"; 
                    System.out.println("State changed to Bloqueur");
                }else if (keyChar == 'm' || keyChar == 'M') {
                    selectedState = "Charpentier"; 
                    System.out.println("State changed to Charpentier");
                }else if (keyChar == 'y' || keyChar == 'Y') {
                    selectedState = "Foureur"; 
                    System.out.println("State changed to Foureur");
                }else if (keyChar == 'g' || keyChar == 'G') {
                    selectedState = "Grimpeur"; 
                    System.out.println("State changed to Grimpeur");
                }
                else if (keyChar == 'p' || keyChar == 'P') {
                    selectedState = "Parachutist"; 
                    System.out.println("State changed to Parachutist");
                }
                
                
                
            }
        });


        this.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent e) {
                super.mouseClicked(e);
                int x = e.getX();
                int y = e.getY();
                

                int gridX = x * game.getTerrain().gridSizeX() / getWidth();
                int gridY = y * game.getTerrain().gridSizeY() / getHeight();
                System.out.println(gridX);
                System.out.println(gridY);

            Poussin clickedPoussin = game.getPoussinClicked(gridX, gridY);
            if (clickedPoussin != null) {
                PoussinState state;
                switch (selectedState) {
                    case "Bombeur":
                     state = new BombeurState(clickedPoussin);
                        break;
                    case "Bloquer":
                    state = new BloqueurState(clickedPoussin);
                        break;
                    case "Charpentier":
                    state = new CharpentierState(clickedPoussin);
                        break;
                    case "Foureur":
                    state = new ForeurState(clickedPoussin);
                        break;
                    case "Grimpeur":
                    state = new GrimpeurState(clickedPoussin);
                        break;
                    default:
                    state= new NormalState(clickedPoussin);
                        break;
                }
                clickedPoussin.setState(state);
                
            }
            }
        
    });

    
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
