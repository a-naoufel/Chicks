package state;
import java.awt.Color;
import model.*;

public class BloqueurState extends PoussinState {

    public BloqueurState(Poussin poussin) {
        super(poussin);
        bloqueWay();
    }

    private void bloqueWay() {
        poussin.setRelativeCell(0, 0, new InvisibleObsticle());
        poussin.setRelativeCell(0, -1, new InvisibleObsticle());
    }

    @Override
    public Color getColor() {
        return Color.BLACK;
    }

    @Override
    public void move() {
    }

    @Override
    public void exit() {
        poussin.setRelativeCell(0, 0, new EmptySquare());
        poussin.setRelativeCell(0, -1, new EmptySquare());
        poussin.setState(new NormalState(poussin));
    }
}
