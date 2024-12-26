import java.awt.Graphics;

import javax.swing.JComponent;
import javax.swing.JFrame;

public class View extends JComponent implements IObsover {
    public JFrame frame;
    public Game game;
    private int ofSet = 35;

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
    public int getHeight(){
        return frame.getHeight() - ofSet;
    }
    public int getWidth(){
        return frame.getWidth();
    }
    
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        game.draw(g, this);
        for (Poussin poussin : game.getPoussins()) {
            poussin.draw(g, this);
        }
    }
    
    @Override
    public void update() {
        repaint();
    }
    
            
        }
        