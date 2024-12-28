package terrain.blockes;
import java.awt.Color;
import java.awt.Graphics;

import poussin.Poussin;
import view.View;

public class Exit extends Cell implements ObstacleIndestructible{

    public void draw(int i, int j, Graphics g, View view) {
        super.draw(i, j, g, view);
        g.setColor(Color.YELLOW);
        int X = view.getWidth() * i / view.game.gridSizeX();
        int Y = view.getHeight()  * (j - 1) / view.game.gridSizeY();
        int[] Xs = { X, X + 20, X + 10 };
        int[] Ys = { Y, Y, Y - 20 };
        g.fillPolygon(Xs, Ys, 3);

    }

    @Override
    public void handale(Poussin p) {
        p.hitExit();
    }

}
