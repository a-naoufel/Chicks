package poussin.state;

import java.awt.Color;

import poussin.Poussin;
import terrain.blockes.EmptySquare;
import terrain.blockes.Explosion;
import terrain.blockes.ObstacleIndestructible;
import terrain.blockes.ObstacleSquare;

public abstract class PoussinState {
    Poussin poussin;

    public PoussinState(Poussin poussin) {
        this.poussin = poussin;
    }

    public void move() {
        poussin.inCell();
        poussin.fall();
        if (poussin.stears())
            poussin.takeSters();
        else if (!poussin.canFall())
            poussin.goAHead();
    }

    public abstract void exit();

    public abstract Color getColor();

    public void destroyRelativeCell(int i, int j) {
        if (poussin.getRelativCell(i, j) instanceof ObstacleSquare)
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

    public void Explosenext(int i, int j) {
        if (!(poussin.getRelativCell(i, j) instanceof ObstacleIndestructible)) {
            ExploseRelativeCell(2 * i, j * 2);
        }
    }

    public void setPoussin(Poussin poussin) {
        this.poussin = poussin;
    }
}
