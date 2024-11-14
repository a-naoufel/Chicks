import java.awt.Color;
import java.awt.Graphics;
import java.io.Serializable;

public abstract class Cell implements Serializable {
    protected Color color;

    public Color getColor() {
        return color;
    }

    public abstract void handalePoussin(Poussin p);

    public void draw(int i, int j, Graphics g, View view) {
        g.setColor(getColor());
        g.fillRect(view.frame.getWidth() * i / view.game.gridSizeX(),
                (view.frame.getHeight() - 35) * j / view.game.gridSizeY(),
                20, 20);
    }
}
