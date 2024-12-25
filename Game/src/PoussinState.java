import java.awt.Color;

public abstract class PoussinState {
    Poussin poussin;

    public PoussinState(Poussin poussin) {
        this.poussin = poussin;
    }

    public void move(Poussin p) {
        p.inCell();
        p.fall();
    }

    public abstract void exit(Poussin p);

    public abstract Color getColor();

    public void destroyRelativeCell(int i, int j) {
        if (!(poussin.getRelativCell(i, j) instanceof ObstacleIndestructible))
            poussin.setRelativeCell(i, j, new EmptySquare());
    }

    public void buildRelativeCell(int i, int j) {
        if (poussin.getRelativCell(i, j) instanceof EmptySquare) {
            System.out.println(i + " " + j);
            poussin.setRelativeCell(i, j, new ObstacleSquare());
        }
    }
}
