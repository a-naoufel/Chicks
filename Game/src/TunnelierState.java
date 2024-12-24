import java.awt.Color;

public class TunnelierState extends PoussinState {

    @Override
    public Color getColor() {
        return Color.DARK_GRAY;
    }

    @Override
    public void move(Poussin poussin) {
        if (!poussin.isAlive()) {
            return;
        }
        poussin.game.grid[poussin.getX()][poussin.getY()].handalePoussin(poussin);
        if (!poussin.fall()) {
            if (poussin.fallcoun > 5) {
                poussin.killpoussin();
            }else {
                if (!(poussin.game.grid[poussin.getX() + poussin.getDirection()][poussin
                        .getY()] instanceof ObstacleIndestructible))
                    poussin.game.grid[poussin.getX() + poussin.getDirection()][poussin
                            .getY()] = new EmptySquare();
                if (!(poussin.game.grid[poussin.getX() + poussin.getDirection()][poussin
                        .getY() - 1] instanceof ObstacleIndestructible))
                    poussin.game.grid[poussin.getX() + poussin.getDirection()][poussin
                            .getY()-1] = new EmptySquare();
                poussin.fallcoun = 0;
            }
            if (poussin.obstisticleAhad()) {
                poussin.takeOthreDirction();
    
            } else if (poussin.canMouveX()) {
                poussin.takeStepX();
            } else {
                poussin.takeStepX();
                if (poussin.canMouveX()) {
                    poussin.moveup();
                }else{
                    poussin.takeOthreDirction();
                }
            }
        } else {
            poussin.fallcoun++;
        }

    }

}
