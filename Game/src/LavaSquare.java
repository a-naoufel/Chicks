import java.awt.Color;

public class LavaSquare extends Cell {
    public LavaSquare(){
        color = Color.RED;
    }
    @Override
    public void handalePoussin(Poussin p) {
        p.killpoussin();
    }
}
