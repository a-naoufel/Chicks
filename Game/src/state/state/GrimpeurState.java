package state;

import java.awt.Color;

import model.EmptySquare;
import model.ObstacleSquare;
import model.Poussin;

public class GrimpeurState extends PoussinState {

    public GrimpeurState(Poussin poussin) {
        super(poussin);
    }

    @Override
    public void move() {
        poussin.inCell();
        if (canClimb()) {
            poussin.moveup();
        } else {
            poussin.fall(); 
        }

        poussin.goAHead(); 
    }

    private boolean canClimb() {
        return poussin.isAlive() 
            && poussin.getRelativCell(0, -1) instanceof EmptySquare 
            && poussin.getRelativCell(poussin.getDirection(), 0) instanceof ObstacleSquare;
    }

    @Override
    public void exit() {
    }

    @Override
    public Color getColor() {
        return Color.GREEN; 
    }
}
