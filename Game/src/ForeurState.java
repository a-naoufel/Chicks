import java.awt.Color;

public class ForeurState extends PoussinState {
    public ForeurState(Poussin poussin){
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

        if(! poussin.canFall()){
            destroyRelativeCell(0, 1);
        }

    }

    @Override
    public void exit(Poussin poussin) {
        poussin.setState(new NormalState(poussin));
    }

}
