import java.awt.Color;

public class NormalState extends PoussinState {

    @Override
    public void move(Poussin poussin) {
        poussin.game.grid[poussin.getX()][poussin.getY()].handalePoussin(poussin);
        super.move(poussin);
    }

    @Override
    public Color getColor() {
        return Color.YELLOW;
    }

}
