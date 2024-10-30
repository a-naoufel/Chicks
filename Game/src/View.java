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
        frame.setSize(1600, 800);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        frame.setContentPane(this);
        this.game = game;
        game.addObserver(this);

    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        for (int i = 0; i < 200; i++) {
            for (int j = 0; j < 100; j++) {
                g.setColor(game.grid[i][j].getColor());
                g.fillRect(getWidth() * i / 200, frame.getHeight() * j / 100, getWidth() / 200, (frame.getHeight()) / 100);
            }
        }
    }

    @Override
    public void update() {
       repaint();
    }

}
