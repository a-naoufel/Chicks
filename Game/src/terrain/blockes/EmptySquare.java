package terrain.blockes;
import java.awt.Color;

public class EmptySquare extends Cell {
    public EmptySquare(int x, int y) {
        super(x, y);
        color = Color.BLUE;
    }
    public EmptySquare(){
        super();
        color = Color.BLUE;
    }
}
