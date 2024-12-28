package terrain.blockes;
import java.awt.Color;
import java.awt.Graphics;
import java.io.Serializable;

import poussin.Poussin;
import view.View;

public abstract class Cell implements Serializable {
    protected Color color;

    public Color getColor() {
        return color;
    }

    public abstract void handale(Poussin p);

    public void draw(int i, int j, Graphics g, View view) {
        g.setColor(getColor());
        g.fillRect(view.getWidth() * i / view.game.gridSizeX(),view.getHeight() * j / view.game.gridSizeY(),
                20, 20);
    }
}
