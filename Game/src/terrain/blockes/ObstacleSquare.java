package terrain.blockes;
import java.awt.Color;

import poussin.Poussin;

public class ObstacleSquare extends Cell {
    public ObstacleSquare(int i,int j){
        super(i, j);
        color = Color.BLACK;
    }
    public ObstacleSquare(){
        super();
        color = Color.BLACK;
    }
    @Override
    public void handale(Poussin p) {
    }
}
