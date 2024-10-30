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
        frame.setSize(16100, 800);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        frame.setContentPane(this);
        game.addObserver(this);

    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        for (int i = 0; i < 200; i++) {
            for (int j = 0; j < 100; j++) {
                g.setColor(game.grid[i][j].getColor());
                g.fillRect(frame.getWidth() * i / 200, (frame.getHeight()) * j / 100, frame.getWidth() / 200, (frame.getHeight()) / 100);
            }
        }
        for (Poussin poussin:game.getPoussins()){
            g.setColor(poussin.getColor());
            g.fillOval(frame.getWidth()*poussin.getX()/200, frame.getHeight() * poussin.getY()/ 100, 40, 40);
            //g.fillOval((frame.getWidth()*poussin.getX())/200, (frame.getHeight()*poussin.getY()-100)/100, 30, 30);
            //g.fillPolygon(poussin.getY()-2, poussin.getY()+2, poussin.getY());
        }
    }

    @Override
    public void update() {
       repaint();
    }

}
