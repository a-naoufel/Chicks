import java.awt.Color;

public class BombeurState extends PoussinState {
    private int stups ;
    public BombeurState(){
        stups = 3;
    }
    @Override
    public Color getColor() {
        return Color.RED;
    }

    @Override
    public void move(Poussin p) {
        while (stups > 0) {
            super.move(p);
            stups--;
        }
        if (!p.isAlive()) {
            return;
        }
        if (stups == 0) {
            if (!(p.game.grid[p.getX()][p
                    .getY()] instanceof ObstacleIndestructible)) {
                p.game.grid[p.getX()][p
                        .getY()] = new Explosion();
            }
            if (!(p.game.grid[p.getX()][p.getY() - 1] instanceof ObstacleIndestructible)) {
                p.game.grid[p.getX()][p.getY() - 1] = new Explosion();
            }

            if (!(p.game.grid[p.getX() + 1][p
                    .getY()] instanceof ObstacleIndestructible)) {
                p.game.grid[p.getX() + 1][p
                        .getY()] = new Explosion();
                if (!(p.game.grid[p.getX() + 2][p
                        .getY()] instanceof ObstacleIndestructible)) {
                    p.game.grid[p.getX() + 2][p
                            .getY()] = new Explosion();
                }
            }
            if (!(p.game.grid[p.getX() - 1][p
                    .getY()] instanceof ObstacleIndestructible)) {
                p.game.grid[p.getX() - 1][p
                        .getY()] = new Explosion();
                if (!(p.game.grid[p.getX() - 2][p
                        .getY()] instanceof ObstacleIndestructible)) {
                    p.game.grid[p.getX() - 2][p
                            .getY()] = new Explosion();
                }
            }
            if (!(p.game.grid[p.getX()][p
                    .getY() - 1] instanceof ObstacleIndestructible)) {
                p.game.grid[p.getX()][p
                        .getY() - 1] = new Explosion();
                if (!(p.game.grid[p.getX()][p
                        .getY() - 2] instanceof ObstacleIndestructible)) {
                    p.game.grid[p.getX()][p
                            .getY() - 2] = new Explosion();
                }
            }
            if (!(p.game.grid[p.getX()][p
                    .getY() + 1] instanceof ObstacleIndestructible)) {
                p.game.grid[p.getX()][p
                        .getY() + 1] = new Explosion();
                if (!(p.game.grid[p.getX()][p
                        .getY() + 2] instanceof ObstacleIndestructible)) {
                    p.game.grid[p.getX()][p
                            .getY() + 2] = new Explosion();
                }
            }
            if (!(p.game.grid[p.getX() + 1][p
                    .getY() + 1] instanceof ObstacleIndestructible)) {
                p.game.grid[p.getX() + 1][p
                        .getY() + 1] = new Explosion();
            }
            if (!(p.game.grid[p.getX() - 1][p
                    .getY() - 1] instanceof ObstacleIndestructible)) {
                p.game.grid[p.getX() - 1][p
                        .getY() - 1] = new Explosion();
            }
            if (!(p.game.grid[p.getX() + 1][p
                    .getY() - 1] instanceof ObstacleIndestructible)) {
                p.game.grid[p.getX() + 1][p
                        .getY() - 1] = new Explosion();
            }
            if (!(p.game.grid[p.getX() - 1][p
                    .getY() + 1] instanceof ObstacleIndestructible)) {
                p.game.grid[p.getX() - 1][p
                        .getY() + 1] = new Explosion();
            }
            stups--;

        } else if (stups < 0) {
            if ((p.game.grid[p.getX()][p
                    .getY()] instanceof Explosion)) {
                p.game.grid[p.getX()][p
                        .getY()] = new EmptySquare();
            }
            if ((p.game.grid[p.getX()][p
                    .getY() - 1] instanceof Explosion)) {
                p.game.grid[p.getX()][p
                        .getY() - 1] = new EmptySquare();
            }
            if ((p.game.grid[p.getX() + 1][p
                    .getY()] instanceof Explosion)) {
                p.game.grid[p.getX() + 1][p
                        .getY()] = new EmptySquare();
                if ((p.game.grid[p.getX() + 2][p
                        .getY()] instanceof Explosion)) {
                    p.game.grid[p.getX() + 2][p
                            .getY()] = new EmptySquare();
                }
            }
            if ((p.game.grid[p.getX() - 1][p
                    .getY()] instanceof Explosion)) {
                p.game.grid[p.getX() - 1][p
                        .getY()] = new EmptySquare();
                if ((p.game.grid[p.getX() - 2][p
                        .getY()] instanceof Explosion)) {
                    p.game.grid[p.getX() - 2][p
                            .getY()] = new EmptySquare();
                }
            }
            if ((p.game.grid[p.getX()][p
                    .getY() - 1] instanceof Explosion)) {
                p.game.grid[p.getX()][p
                        .getY() - 1] = new EmptySquare();
                if ((p.game.grid[p.getX()][p
                        .getY() - 2] instanceof Explosion)) {
                    p.game.grid[p.getX()][p
                            .getY() - 2] = new EmptySquare();
                }
            }
            if ((p.game.grid[p.getX()][p
                    .getY() + 1] instanceof Explosion)) {
                p.game.grid[p.getX()][p
                        .getY() + 1] = new EmptySquare();
                if ((p.game.grid[p.getX()][p
                        .getY() + 2] instanceof Explosion)) {
                    p.game.grid[p.getX()][p
                            .getY() + 2] = new EmptySquare();
                }
            }
            if ((p.game.grid[p.getX() + 1][p
                    .getY() + 1] instanceof Explosion)) {
                p.game.grid[p.getX() + 1][p
                        .getY() + 1] = new EmptySquare();
            }
            if ((p.game.grid[p.getX() - 1][p
                    .getY() - 1] instanceof Explosion)) {
                p.game.grid[p.getX() - 1][p
                        .getY() - 1] = new EmptySquare();
            }
            if ((p.game.grid[p.getX() + 1][p
                    .getY() - 1] instanceof Explosion)) {
                p.game.grid[p.getX() + 1][p
                        .getY() - 1] = new EmptySquare();
            }
            if ((p.game.grid[p.getX() - 1][p
                    .getY() + 1] instanceof Explosion)) {
                p.game.grid[p.getX() - 1][p
                        .getY() + 1] = new EmptySquare();
            }
            
            p.killpoussin();
        }
    }
}
