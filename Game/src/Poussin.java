import java.awt.Color;

public class Poussin {
    public EmptySquare emptySquare;
    private int x;
    private int y;
    private boolean isAlive;
    private int direction;// 1: for right and -1: for left
    private Color PoussColor = Color.YELLOW;
    public int id;
    public Game game;
    public int fallcoun = 0;

    public Poussin(Game game) {
        x = game.getEntry().getX();
        y = game.getEntry().getY();
        isAlive = true;
        direction = 1;
        this.game = game;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public boolean isAlive() {
        return isAlive;
    }

    public int getDirection() {
        return direction;
    }

    public Color getColor() {
        return PoussColor;
    }

    public void takeStepX() {
        if ((x + direction) >= 0 & (x + direction) < game.gridSizeX()) {
            x += direction;
        }
    }

    public boolean canMouveX() {
        return game.grid[this.x + direction][this.y] instanceof EmptySquare;
    }

    public boolean obstistical() {
        return !(game.grid[this.x + direction][this.y - 1] instanceof EmptySquare)
                | !(game.grid[this.x][this.y - 1] instanceof EmptySquare);
    }

    public boolean fall() {
        if (y < game.gridSizeY()) {
            if (game.grid[x][y + 1] instanceof EmptySquare) {
                y++;
                return true;
            }
        }
        return false;
    }

    public void takeOthreDirction() {
        direction *= -1;
    }

    public void moveup() {
        if (y > 0) {
            y--;
        }
    }

    public void Move() {
        if (!this.isAlive()) {
            return;
        }
        if (!fall()) {
            if (fallcoun > 5)
                this.isAlive = false;
            else
                fallcoun = 0;

            if (canMouveX()) {
                takeStepX();

            } else if (obstistical()) {
                takeOthreDirction();

            } else {
                takeStepX();
                moveup();
            }

        } else {
            fallcoun++;
        }

    }
}
