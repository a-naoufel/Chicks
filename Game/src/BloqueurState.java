import java.awt.Color;

public class BloqueurState extends PoussinState {

    @Override
    public Color getColor() {
        return Color.BLACK;
    }
    @Override
    public void move(Poussin p) {
        p.game.grid[p.getX()][p.getY()] = new InvisibleObsticle();
        p.game.grid[p.getX()][p.getY() - 1] = new InvisibleObsticle();
    }
    
}
