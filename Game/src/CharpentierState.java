import java.awt.Color;

public class CharpentierState extends PoussinState {
    private int steps = 5;

    @Override
    public void move(Poussin poussin) {
        if (!poussin.isAlive()) {
            return;
        }
        if (steps > 0) {
            if (!poussin.fall()) {
                if (poussin.fallcoun > 5) {
                    poussin.killpoussin();
                }

                else {
                    if (poussin.game.grid[poussin.getX() + poussin.getDirection()][poussin
                            .getY()] instanceof EmptySquare)
                        poussin.game.grid[poussin.getX() + poussin.getDirection()][poussin
                                .getY()] = new ObstacleSquare();
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
