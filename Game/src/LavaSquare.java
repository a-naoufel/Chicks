import java.awt.Color;

public class LavaSquare extends Cell implements ObstacleIndestructible {
    public LavaSquare(){
        color = Color.RED;
    }
    @Override
    public void handale(Poussin poussin) {
        poussin.kill();
    }
}
