package terrain.blockes;
import java.awt.Color;

import poussin.Poussin;

public class LavaSquare extends Cell implements ObstacleIndestructible {
    public LavaSquare(){
        color = Color.RED;
    }
    @Override
    public void handale(Poussin poussin) {
        poussin.kill();
    }
}
