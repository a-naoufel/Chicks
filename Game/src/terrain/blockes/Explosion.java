package terrain.blockes;
import java.awt.Color;

import poussin.Poussin;

public class Explosion extends EmptySquare {
    public Explosion(){
        color = Color.GRAY;
    }
    @Override
    public void handale(Poussin poussin) {
        poussin.kill();
    }
}
