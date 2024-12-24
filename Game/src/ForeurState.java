import java.awt.Color;

public class ForeurState extends PoussinState {

    @Override
    public Color getColor() {
        return Color.DARK_GRAY;
    }

    @Override
    public void move(Poussin poussin) {
        if (!poussin.isAlive()) {
            return;
        }

        if (!poussin.fall()) {
            if (poussin.fallcoun > 5) {
                poussin.killpoussin();
            } else {

                if (!(poussin.game.grid[poussin.getX()][poussin.getY() + 1] instanceof ObstacleIndestructible)) {
                    poussin.game.grid[poussin.getX()][poussin.getY() + 1] = new EmptySquare();
                    System.out.println("\n "+ (poussin.getY()+1)+ "  " +poussin.getX()+"\n");
                }
                poussin.fallcoun = 0;
            }
        } else {
            poussin.game.grid[poussin.getX()][poussin.getY()].handalePoussin(poussin);
            poussin.fallcoun++;
        }

    }

}
