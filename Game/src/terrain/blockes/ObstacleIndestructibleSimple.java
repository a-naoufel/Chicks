package terrain.blockes;

import java.awt.Color;

public class ObstacleIndestructibleSimple extends ObstacleSquare implements ObstacleIndestructible{
    public ObstacleIndestructibleSimple(int i,int j){
        super(i, j);
        color = Color.DARK_GRAY;
    }
    public ObstacleIndestructibleSimple(){
        super();
        color = Color.DARK_GRAY;
    }
}
