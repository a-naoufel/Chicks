package poussin.state;
import java.awt.Color;

import poussin.Poussin;

public class ParachutistState extends PoussinState {
    private int fallSpeed = 0;

    public ParachutistState(Poussin poussin) {
        super(poussin);
    }

    @Override
    public void move() {
        poussin.inCell();

        if (fallSpeed == 0) {
            poussin.fall();
            poussin.setFallCount(0);
        }
        fallSpeed = (fallSpeed + 1) % 2; 
        if (poussin.stears())
            poussin.takeSters();
        else if (!poussin.canFall())
            poussin.goAHead();
    }

    @Override
    public void exit() {
    }

    @Override
    public Color getColor() {
        return Color.ORANGE; 
    }
}
