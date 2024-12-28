package terrain.blockes;
import java.awt.Color;
import view.View;

public class Entry extends Cell implements ObstacleIndestructible {
    public Entry(int x,int y){
        super(x, y);
    }

    public Entry(){
        super();
    }

    public void draw(View view) {
        super.draw(view);
        view.setColor(Color.GREEN);
        view.drawTrangle(this);
    }

}
