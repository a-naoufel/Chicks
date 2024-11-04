import java.awt.Color;

public class Entry {

    private int x;
    private int y;
    private Color color;
    
    public Entry(int x, int y){
        this.x=x;
        this.y=y;
        this.color=Color.GREEN;
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
