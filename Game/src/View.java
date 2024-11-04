import java.awt.Graphics;

import javax.swing.JComponent;
import javax.swing.JFrame;

public class View extends JComponent implements IObsover {
    private JFrame frame;
    private Game game;

    public View(Game game) {
        this.game = game;
        frame = new JFrame("JavaGame");
        frame.setDefaultCloseOperation(0);
        frame.setSize(1000, 515);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        frame.setContentPane(this);
        game.addObserver(this);

    }

    public void drowPoussin(Graphics g, Poussin poussin) {
        g.setColor(poussin.getColor());
        g.fillOval((frame.getWidth() * poussin.getX()) / game.gridSizeX(), (frame.getHeight() - 35) * poussin.getY() / game.gridSizeY(), 20, 20);
    }

    public void drowGrid(Graphics g) {
        for (int i = 0; i < game.gridSizeX(); i++) {
            for (int j = 0; j < game.gridSizeY(); j++) {
                g.setColor(game.grid[i][j].getColor());
                g.fillRect(frame.getWidth() * i / game.gridSizeX(), +(frame.getHeight() - 35) * j / game.gridSizeY(), 20, 20);
            }
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
<<<<<<< HEAD
        for (int i = 0; i < 50; i++) {
            for (int j = 0; j < 24; j++) {
                g.setColor(game.grid[i][j].getColor());
                g.fillRect(frame.getWidth() * i / 50,  + (frame.getHeight()-35) * j / 24,20, 20);
            }
        }
        for (Poussin poussin:game.getPoussins()){
            g.setColor(poussin.getColor());
            g.fillOval((frame.getWidth()*poussin.getX())/50, (frame.getHeight()-35) * poussin.getY()/ 24 , 20, 20);
            System.out.println("Poussin "+ poussin.id +" x:" + poussin.getX() + " Y: " + poussin.getY());
            //g.fillOval((frame.getWidth()*poussin.getX())/50, (frame.getHeight()-35*poussin.getY())/24, 30, 30);
            //g.fillPolygon(poussin.getY()-2, poussin.getY()+2, poussin.getY());
=======
        drowGrid(g);
        for (Poussin poussin : game.getPoussins()) {
            drowPoussin(g, poussin);
>>>>>>> 24f2791e7d36ea06c4ecc5b2491476da5a45def2
        }
    }

    @Override
    public void update() {
        repaint();
    }

}
