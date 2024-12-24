import java.awt.Color;

public abstract class PoussinState {
    public void move(Poussin p){
        if (!p.isAlive()) {
            return;
        }
        p.game.grid[p.getX()][p.getY()].handalePoussin(p);
        if (!p.fall()) {
            if (p.fallcoun > 5) {
                p.killpoussin();
            }

            else
                p.fallcoun = 0;
            if (p.obstisticleAhad()) {
                p.takeOthreDirction();

            } else if (p.canMouveX()) {
                p.takeStepX();
            } else {
                p.takeStepX();
                if (p.canMouveX()) {
                    p.moveup();
                }else{
                    p.takeOthreDirction();
                }
            }

        } else {
            p.fallcoun++;
        }
    }

    public abstract Color getColor();
}
