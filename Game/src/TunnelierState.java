import java.awt.Color;

public class TunnelierState extends PoussinState {

    public TunnelierState(Poussin poussin) {
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
        poussin.setState(new NormalState(poussin));
    }

}
