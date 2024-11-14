import java.awt.Color;
import java.awt.Graphics;

public class Exit extends EmptySquare {

    public void draw(int i, int j, Graphics g, View view) {
        super.draw(i, j, g, view);
        g.setColor(Color.YELLOW);
        int X = view.frame.getWidth() * i / view.game.gridSizeX();
        int Y = (view.frame.getHeight() - 35) * (j - 1) / view.game.gridSizeY();
        int[] Xs = { X, X + 20, X + 10 };
        int[] Ys = { Y, Y, Y - 20 };
        g.fillPolygon(Xs, Ys, 3);

    }

    @Override
    public void handalePoussin(Poussin p) {
        p.hitExit();
    }

}
