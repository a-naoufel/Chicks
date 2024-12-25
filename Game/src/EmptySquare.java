import java.awt.Color;

public class EmptySquare extends Cell implements ObstacleIndestructible {
    public EmptySquare() {
        color = Color.BLUE;
    }

    @Override
    public void handale(Poussin p) {
    }
}
