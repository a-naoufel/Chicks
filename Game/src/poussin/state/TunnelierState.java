package poussin.state;
import java.awt.Color;

import poussin.Poussin;

public class TunnelierState extends PoussinState {

    public TunnelierState(Poussin poussin) {
        super(poussin);
    }

    @Override
    public Color getColor() {
        return Color.CYAN;
    }

    @Override
    public void move() {
        poussin.inCell();
        poussin.fall();
        makeTunnele();
        poussin.goAHead();
    }

    private void makeTunnele() {
        if (!poussin.canFall()) {
            destroyRelativeCell(poussin.getDirection(), 0);
            destroyRelativeCell(poussin.getDirection(), -1);
        }
    }

    @Override
    public void exit() {
    }

}
