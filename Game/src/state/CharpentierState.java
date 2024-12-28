package state;
import java.awt.Color;

import poussin.Poussin;

public class CharpentierState extends PoussinState {
    private int steps;
    public CharpentierState(Poussin poussin){
        super(poussin);
        steps = 5;
    }

    @Override
    public void move() {

        if (steps > 0) {

            poussin.inCell();
            poussin.fall();
            build();
            poussin.takeSters();
            poussin.goAHead();

            steps--;
        } else {
            exit();
        }
    }
    private void build(){
        if (!poussin.canFall() && poussin.fallcoun == 0) {
            buildRelativeCell(poussin.getDirection(), 0);
        }
    }

    @Override
    public Color getColor() {
        return Color.GREEN;
    }

    @Override
    public void exit() {
       poussin.setState(new NormalState(poussin));
    }

}
