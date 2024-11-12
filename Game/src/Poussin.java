import java.awt.Color;

public class Poussin {
    public EmptySquare emptySquare;
    public Exit exit;
    private int x;
    private int y;
    private boolean isAlive;
    private boolean status; // true for INTerrian,false for OUTTerrain
    private int direction;// 1: for right and -1: for left
    private Color PoussColor = Color.YELLOW;
    public int id;
    public Game game;
    public int fallcoun = 0;
    private static int numPoussinExit = 0;
    private static int numPoussindead = 0;
    private static int numPoussin = 0;

    public Poussin(int id, Game game) {
        x = game.getEntry().getX();
        y = game.getEntry().getY();
        isAlive = true;
        direction = 1;
        this.game = game;
        this.id = id;
        this.status = true;

    }

    public static void displayCounter() {
        System.out.println("Poussin entrer: " + numPoussin);
        System.out.println("Poussin sortie: " + numPoussinExit);
        System.out.println("Poussin mort: " + numPoussindead + "\n");
    }
    public static void add(){
        numPoussin ++;
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

    public boolean getStatus() {
        return status;
    }

    public void takeStepX() {
        if ((x + direction) >= 0 & (x + direction) < game.gridSizeX()) {
            x += direction;
        }
        if (game.grid[x][y] instanceof LavaSquare)
            killpoussin();
    }

    public void killpoussin() {
        isAlive = false;
        numPoussindead++;
        displayCounter();
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

    public void hitExit() {
        if (game.grid[x + 1][y] instanceof EmptySquare
                && (this.x == game.getExit().getX() && this.y == game.getExit().getY())) {
            System.out.println("poussin id " + this.id + " hit the exit");
            numPoussinExit++;
            displayCounter();
            this.status = false;

        }
    }

    public void Move() {
        if (!this.isAlive() || !this.getStatus()) {
            return;
        }
        if (!fall()) {
            if (fallcoun > 5) {
                killpoussin();
            }

            else
                fallcoun = 0;
            if (game.grid[x][y + 1] instanceof LavaSquare)
                killpoussin();

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
        hitExit();

    }
}
