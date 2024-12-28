package terrain.blockes;
import java.awt.Color;
import java.io.Serializable;

import poussin.Poussin;
import view.View;

public abstract class Cell implements Serializable {
    protected Color color;
    protected int x;
    protected int y;
    private int size = 20;

    public int getSize(){
        return size;
    }

    public Cell(int x, int y) {
      setCoordinates(x, y);
    }
    public Cell(){
        setCoordinates(0, 0);
    }
    public void setCoordinates(int x,int y){
        this.x = x;
        this.y = y;
    }
    public Color getColor() {
        return color;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void handale(Poussin p){};

    public void draw(View view) {
        view.setColor(getColor());
        view.drawSquare(this);
    }
}
