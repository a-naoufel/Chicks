package poussin.state;
import java.awt.Color;

import poussin.Poussin;
import terrain.blockes.EmptySquare;
import terrain.blockes.ObstacleSquare;

public class GrimpeurState extends PoussinState {

    public GrimpeurState(Poussin poussin) {
        super(poussin);
    }

    @Override
    public void move() {
        poussin.inCell();
        if (canClimb()) {
            poussin.moveup();
        } else if(poussin.canStepAHead()){
            poussin.goAHead(); 
            poussin.fall(); 
        }else{
            poussin.changeDirction();
        }

    }

    private boolean canClimb() {

        return poussin.getRelativCell(0, -1) instanceof EmptySquare 
            && poussin.getRelativCell(poussin.getDirection(), 0) instanceof ObstacleSquare;
    }

    @Override
    public void exit() {
    }

    @Override
    public Color getColor() {
        return Color.MAGENTA; 
    }
}
