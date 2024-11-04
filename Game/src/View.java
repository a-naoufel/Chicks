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
        drowGrid(g);
        for (Poussin poussin : game.getPoussins()) {
            drowPoussin(g, poussin);
        }
    }

    @Override
    public void update() {
        repaint();
    }

}
