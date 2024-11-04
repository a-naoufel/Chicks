import java.awt.Color;
import java.io.Serializable;

public abstract class Square implements Serializable {
    protected Color color;
    public Color getColor(){
        return color;
    }
}
