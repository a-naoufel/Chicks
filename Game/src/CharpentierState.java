import java.awt.Color;

public class CharpentierState implements PoussinState {
    private int steps=5;

    @Override
    public void move(Poussin poussin) {
        if (steps > 0) {
            poussin.game.grid[poussin.getX()+ poussin.getDirection()][poussin.getY()] = new ObstacleSquare();
            poussin.game.grid[poussin.getX()][poussin.getY()].handalePoussin(poussin);
            steps--;
        } else {
            poussin.setState(new NormalState());
        }
    }

    @Override
    public Color getColor() {
        return Color.GREEN;
    }
    
}
