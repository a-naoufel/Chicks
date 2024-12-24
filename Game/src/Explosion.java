import java.awt.Color;

public class Explosion extends EmptySquare {
    public Explosion(){
        color = Color.GRAY;
    }
    @Override
    public void handalePoussin(Poussin p) {
        p.killpoussin();
    }
}
