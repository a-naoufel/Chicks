import java.awt.Color;

public class Exit {
    private int x;
    private int y;
    private Color color;
    
    public Exit(int x, int y){
        this.x=x;
        this.y=y;
        this.color=Color.yellow;
    }

    public int getX(){
        return x;
    }
    public int getY(){
        return y;
    }
    public Color getColor(){
        return color;
    }
    
}
