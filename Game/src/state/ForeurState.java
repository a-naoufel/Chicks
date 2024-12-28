package state;
import java.awt.Color;

import poussin.Poussin;

public class ForeurState extends PoussinState {
    public ForeurState(Poussin poussin){
        super(poussin);
    }

    @Override
    public Color getColor() {
        return Color.DARK_GRAY;
    }

    @Override
    public void move() {
       poussin.inCell();
       poussin.fall();
       dig();
    }

    private void dig(){
        if(! poussin.canFall()){
            destroyRelativeCell(0, 1);
        }
    }

    @Override
    public void exit() {
        poussin.setState(new NormalState(poussin));
    }

}
