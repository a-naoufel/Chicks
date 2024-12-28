package state;
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
        }
        fallSpeed = (fallSpeed + 1) % 2; 

        poussin.moveup();
        poussin.goAHead();
    }

    @Override
    public void exit() {
    }

    @Override
    public Color getColor() {
        return Color.BLUE; 
    }
}
