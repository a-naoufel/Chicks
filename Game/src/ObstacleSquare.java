import java.awt.Color;

public class ObstacleSquare extends Cell {
    public ObstacleSquare(){
        color = Color.BLACK;
    }
    @Override
    public void handalePoussin(Poussin p) {
        p.moveup();
    }
}
