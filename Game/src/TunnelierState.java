import java.awt.Color;

public class TunnelierState extends PoussinState {

    public TunnelierState(Poussin poussin){
        super(poussin);
    }

    @Override
    public Color getColor() {
        return Color.DARK_GRAY;
    }

    @Override
    public void move(Poussin poussin) {
        poussin.inCell();
        poussin.fall();
        if (!poussin.canFall()) {
            destroyRelativeCell(poussin.getDirection(), 0);
            destroyRelativeCell(poussin.getDirection(), -1);
        }
        poussin.goAHead();
    }

    @Override
    public void exit(Poussin poussin) {
        poussin.setState(new NormalState(poussin));
    }

}
