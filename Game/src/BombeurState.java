import java.awt.Color;

public class BombeurState extends PoussinState {
        private int stups;

        public BombeurState(Poussin poussin) {
                stups = 3;
                super(poussin);
        }

        @Override
        public Color getColor() {
                return Color.RED;
        }

        @Override
        public void move(Poussin poussin) {
                
                if (!poussin.isAlive()) {
                        return;
                }
                poussin.getRelativCell(0, 0).handale(poussin);
                while (stups > 0) {
                        super.move(poussin);
                        stups--;
                }
                if (stups == 0) {
                        if (!(poussin.game.grid[poussin.getX()][poussin
                                        .getY()] instanceof ObstacleIndestructible)) {
                                poussin.game.grid[poussin.getX()][poussin
                                                .getY()] = new Explosion();
                        }
                        if (!(poussin.game.grid[poussin.getX()][poussin.getY() - 1] instanceof ObstacleIndestructible)) {
                                poussin.game.grid[poussin.getX()][poussin.getY() - 1] = new Explosion();
                        }

                        if (!(poussin.game.grid[poussin.getX() + 1][poussin
                                        .getY()] instanceof ObstacleIndestructible)) {
                                poussin.game.grid[poussin.getX() + 1][poussin
                                                .getY()] = new Explosion();
                                if (!(poussin.game.grid[poussin.getX() + 2][poussin
                                                .getY()] instanceof ObstacleIndestructible)) {
                                        poussin.game.grid[poussin.getX() + 2][poussin
                                                        .getY()] = new Explosion();
                                }
                        }
                        if (!(poussin.game.grid[poussin.getX() - 1][poussin
                                        .getY()] instanceof ObstacleIndestructible)) {
                                poussin.game.grid[poussin.getX() - 1][poussin
                                                .getY()] = new Explosion();
                                if (!(poussin.game.grid[poussin.getX() - 2][poussin
                                                .getY()] instanceof ObstacleIndestructible)) {
                                        poussin.game.grid[poussin.getX() - 2][poussin
                                                        .getY()] = new Explosion();
                                }
                        }
                        if (!(poussin.game.grid[poussin.getX()][poussin
                                        .getY() - 1] instanceof ObstacleIndestructible)) {
                                poussin.game.grid[poussin.getX()][poussin
                                                .getY() - 1] = new Explosion();
                                if (!(poussin.game.grid[poussin.getX()][poussin
                                                .getY() - 2] instanceof ObstacleIndestructible)) {
                                        poussin.game.grid[poussin.getX()][poussin
                                                        .getY() - 2] = new Explosion();
                                }
                        }
                        if (!(poussin.game.grid[poussin.getX()][poussin
                                        .getY() + 1] instanceof ObstacleIndestructible)) {
                                poussin.game.grid[poussin.getX()][poussin
                                                .getY() + 1] = new Explosion();
                                if (!(poussin.game.grid[poussin.getX()][poussin
                                                .getY() + 2] instanceof ObstacleIndestructible)) {
                                        poussin.game.grid[poussin.getX()][poussin
                                                        .getY() + 2] = new Explosion();
                                }
                        }
                        if (!(poussin.game.grid[poussin.getX() + 1][poussin
                                        .getY() + 1] instanceof ObstacleIndestructible)) {
                                poussin.game.grid[poussin.getX() + 1][poussin
                                                .getY() + 1] = new Explosion();
                        }
                        if (!(poussin.game.grid[poussin.getX() - 1][poussin
                                        .getY() - 1] instanceof ObstacleIndestructible)) {
                                poussin.game.grid[poussin.getX() - 1][poussin
                                                .getY() - 1] = new Explosion();
                        }
                        if (!(poussin.game.grid[poussin.getX() + 1][poussin
                                        .getY() - 1] instanceof ObstacleIndestructible)) {
                                poussin.game.grid[poussin.getX() + 1][poussin
                                                .getY() - 1] = new Explosion();
                        }
                        if (!(poussin.game.grid[poussin.getX() - 1][poussin
                                        .getY() + 1] instanceof ObstacleIndestructible)) {
                                poussin.game.grid[poussin.getX() - 1][poussin
                                                .getY() + 1] = new Explosion();
                        }
                        stups--;

                } else if (stups < 0) {
                        if ((poussin.game.grid[poussin.getX()][poussin
                                        .getY()] instanceof Explosion)) {
                                poussin.game.grid[poussin.getX()][poussin
                                                .getY()] = new EmptySquare();
                        }
                        if ((poussin.game.grid[poussin.getX()][poussin
                                        .getY() - 1] instanceof Explosion)) {
                                poussin.game.grid[poussin.getX()][poussin
                                                .getY() - 1] = new EmptySquare();
                        }
                        if ((poussin.game.grid[poussin.getX() + 1][poussin
                                        .getY()] instanceof Explosion)) {
                                poussin.game.grid[poussin.getX() + 1][poussin
                                                .getY()] = new EmptySquare();
                                if ((poussin.game.grid[poussin.getX() + 2][poussin
                                                .getY()] instanceof Explosion)) {
                                        poussin.game.grid[poussin.getX() + 2][poussin
                                                        .getY()] = new EmptySquare();
                                }
                        }
                        if ((poussin.game.grid[poussin.getX() - 1][poussin
                                        .getY()] instanceof Explosion)) {
                                poussin.game.grid[poussin.getX() - 1][poussin
                                                .getY()] = new EmptySquare();
                                if ((poussin.game.grid[poussin.getX() - 2][poussin
                                                .getY()] instanceof Explosion)) {
                                        poussin.game.grid[poussin.getX() - 2][poussin
                                                        .getY()] = new EmptySquare();
                                }
                        }
                        if ((poussin.game.grid[poussin.getX()][poussin
                                        .getY() - 1] instanceof Explosion)) {
                                poussin.game.grid[poussin.getX()][poussin
                                                .getY() - 1] = new EmptySquare();
                                if ((poussin.game.grid[poussin.getX()][poussin
                                                .getY() - 2] instanceof Explosion)) {
                                        poussin.game.grid[poussin.getX()][poussin
                                                        .getY() - 2] = new EmptySquare();
                                }
                        }
                        if ((poussin.game.grid[poussin.getX()][poussin
                                        .getY() + 1] instanceof Explosion)) {
                                poussin.game.grid[poussin.getX()][poussin
                                                .getY() + 1] = new EmptySquare();
                                if ((poussin.game.grid[poussin.getX()][poussin
                                                .getY() + 2] instanceof Explosion)) {
                                        poussin.game.grid[poussin.getX()][poussin
                                                        .getY() + 2] = new EmptySquare();
                                }
                        }
                        if ((poussin.game.grid[poussin.getX() + 1][poussin
                                        .getY() + 1] instanceof Explosion)) {
                                poussin.game.grid[poussin.getX() + 1][poussin
                                                .getY() + 1] = new EmptySquare();
                        }
                        if ((poussin.game.grid[poussin.getX() - 1][poussin
                                        .getY() - 1] instanceof Explosion)) {
                                poussin.game.grid[poussin.getX() - 1][poussin
                                                .getY() - 1] = new EmptySquare();
                        }
                        if ((poussin.game.grid[poussin.getX() + 1][poussin
                                        .getY() - 1] instanceof Explosion)) {
                                poussin.game.grid[poussin.getX() + 1][poussin
                                                .getY() - 1] = new EmptySquare();
                        }
                        if ((poussin.game.grid[poussin.getX() - 1][poussin
                                        .getY() + 1] instanceof Explosion)) {
                                poussin.game.grid[poussin.getX() - 1][poussin
                                                .getY() + 1] = new EmptySquare();
                        }
                }
        }

        @Override
        public void exit(Poussin poussin) {
                poussin.kill();
        }
}
