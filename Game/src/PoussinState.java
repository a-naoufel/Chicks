import java.awt.Color;

public abstract class PoussinState {
    Poussin poussin;

    public PoussinState(Poussin poussin) {
        this.poussin = poussin;
    }

    public void move() {
        poussin.inCell();
        poussin.fall();
        poussin.moveup();
        poussin.goAHead();
    }

    public abstract void exit();

    public abstract Color getColor();

    public void destroyRelativeCell(int i, int j) {
        if (!(poussin.getRelativCell(i, j) instanceof ObstacleIndestructible))
            poussin.setRelativeCell(i, j, new EmptySquare());
    }

    public void buildRelativeCell(int i, int j) {
        if (poussin.getRelativCell(i, j) instanceof EmptySquare)
            poussin.setRelativeCell(i, j, new ObstacleSquare());
    }

    public void ExploseRelativeCell(int i, int j) {
        if (!(poussin.getRelativCell(i, j) instanceof ObstacleIndestructible))
            poussin.setRelativeCell(i, j, new Explosion());
    }

    public void clearExplosion(int i, int j) {
        if (poussin.getRelativCell(i, j) instanceof Explosion)
            poussin.setRelativeCell(i, j, new EmptySquare());

    }
    public void Explosenext(int i,int j){
        if (!(poussin.getRelativCell(i, j) instanceof ObstacleIndestructible)) {
            ExploseRelativeCell(2*i, j*2);
    }
    }
}
