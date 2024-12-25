import java.awt.Color;

public class CharpentierState extends PoussinState {
    private int steps;
    public CharpentierState(Poussin poussin){
        super(poussin);
        steps = 5;
    }

    @Override
    public void move(Poussin poussin) {

        if (steps > 0) {

            poussin.inCell();
            poussin.fall();

            if (!poussin.canFall() && poussin.fallcoun == 0) {
                buildRelativeCell(poussin.getDirection(), 0);
            }

            poussin.moveup();
            poussin.goAHead();

            steps--;
        } else {
            exit(poussin);
        }
    }

    @Override
    public Color getColor() {
        return Color.GREEN;
    }

    @Override
    public void exit(Poussin poussin) {
       poussin.setState(new NormalState(poussin));
    }

}
