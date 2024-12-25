import java.awt.Color;

public class BloqueurState extends PoussinState {

    public BloqueurState(Poussin poussin){
        super(poussin);
        poussin.setRelativeCell(0, 0, new InvisibleObsticle());
        poussin.setRelativeCell(0,-1, new InvisibleObsticle());
    }

    @Override
    public Color getColor() {
        return Color.BLACK;
    }
    @Override
    public void move(Poussin poussin) {
    }
    @Override
    public void exit(Poussin poussin) {
        poussin.setRelativeCell(0, 0, new EmptySquare());
        poussin.setRelativeCell(0,-1, new EmptySquare());
        poussin.setState(new NormalState(poussin));
    }
}
