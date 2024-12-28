package terrain.blockes;
import java.awt.Color;

public class InvisibleObsticle extends ObstacleIndestructibleSimple{
    public InvisibleObsticle(int i,int j){
        super(i, j);
        color = Color.BLUE;
    }
    public InvisibleObsticle(){
        super();
        color = Color.BLUE;
    }
}
