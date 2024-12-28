package terrain.blockes;
import java.awt.Color;

import poussin.Poussin;

public class Explosion extends EmptySquare {
    public Explosion(int i,int j){
        super(i, j);
        color = Color.GRAY;
    }
    public Explosion(){
        super();
        color = Color.GRAY;
    }
    @Override
    public void handale(Poussin poussin) {
        poussin.kill();
    }
}
