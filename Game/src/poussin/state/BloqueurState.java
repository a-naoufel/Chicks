package poussin.state;

import java.awt.Color;

import poussin.Poussin;
import terrain.blockes.EmptySquare;
import terrain.blockes.InvisibleObsticle;

public class BloqueurState extends PoussinState {

    public BloqueurState(Poussin poussin) {
        super(poussin);
        bloqueWay();
    }

    private void bloqueWay() {
        poussin.inCell();
        if (poussin.isAlive()) {
            if (poussin.canFall())
                poussin.setRelativeCell(0, -1, new EmptySquare());

            poussin.fall();
            poussin.setRelativeCell(0, 0, new InvisibleObsticle());
            poussin.setRelativeCell(0, -1, new InvisibleObsticle());
        }
    }

    @Override
    public Color getColor() {
        return Color.BLACK;
    }

    @Override
    public void move() {
        poussin.inCell();
        if (poussin.isAlive())
            bloqueWay();

    }

    @Override
    public void exit() {
        poussin.setRelativeCell(0, 0, new EmptySquare());
        poussin.setRelativeCell(0, -1, new EmptySquare());
    }
}
