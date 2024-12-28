package state;
import java.awt.Color;

import poussin.Poussin;

public class NormalState extends PoussinState {

    public NormalState(Poussin poussin){
        super(poussin);
    }

    @Override
    public void move() {
        super.move();
    }

    @Override
    public Color getColor() {
        return Color.YELLOW;
    }

    @Override
    public void exit() {
    }

}
