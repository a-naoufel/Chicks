import java.awt.Graphics;

public class Poussin {
    private int x;
    private int y;
    private boolean isAlive;
    private int direction;// 1: for right and -1: for left
    private PoussinState currentState;
    public int id;
    public Game game;
    public int fallcoun = 0;
    private static int numPoussinExit = 0;
    private static int numPoussindead = 0;
    private static int numPoussin = 0;
    public static int numTotal = 4;
    private long stateChangeTime;  // moment où l'état doit changer
    private long delay = 5000; // délai avant de changer l'état, en millisecondes

    public Poussin(int id, Game game) {
        x = game.getEntry().getX();
        y = game.getEntry().getY();
        isAlive = true;
        direction = 1;
        this.game = game;
        this.id = id;
        this.currentState=new NormalState();
        this.stateChangeTime = System.currentTimeMillis() + delay; // initier l'heure de changement

    }

    public void setState(PoussinState state){
        // game.grid[getX()][getY()] = new EmptySquare();
        // game.grid[getX()][getY() - 1] = new EmptySquare();
        this.currentState = state;
    }

    public static void displayCounter() {
        System.out.println("Poussin entrer: " + numPoussin);
        System.out.println("Poussin sortie: " + numPoussinExit);
        System.out.println("Poussin mort: " + numPoussindead + "\n");
    }

    public static boolean endGame() {
        return numTotal == numPoussinExit + numPoussindead;
    }

    public static void add() {
        numPoussin++;
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

    public void takeStepX() {
        if ((x + direction) >= 0 & (x + direction) < game.gridSizeX()) {
            x += direction;
        }
    }

    public void killpoussin() {
        isAlive = false;
        numPoussindead++;
        displayCounter();
    }

    public boolean canMouveX() {
        return !((game.grid[this.x + direction][this.y] instanceof ObstacleSquare)||(game.grid[this.x + direction][this.y - 1] instanceof ObstacleSquare));
    }

    public boolean obstisticleAhad() {
        return (game.grid[this.x + direction][this.y - 1] instanceof ObstacleSquare);
    }

    public boolean fall() {
        if (y < game.gridSizeY()) {
            if (!(game.grid[x][y + 1] instanceof ObstacleSquare)) {
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
        
            System.out.println("poussin id " + this.id + " hit the exit");
            numPoussinExit++;
            displayCounter();
            isAlive = false;

        
    }

    public void Move() {
        if (System.currentTimeMillis() >= stateChangeTime) {
            setState(new BombeurState()); // changer d'état
            stateChangeTime = System.currentTimeMillis() + delay; // redémarrer le délai
        }
        currentState.move(this);

    }

    public void draw(Graphics g, View view) {
        if (isAlive) {
            int x1 = ((view.frame.getWidth() * getX()) / game.gridSizeX()) + 10;
            int x3 = ((view.frame.getWidth() * getX()) / game.gridSizeX()) + 10 + getDirection() * 12;
            int y = ((view.frame.getHeight() - 35) * getY() / game.gridSizeY()) - 8;
            int[] XPoints = { x1, x1, x3 };
            int[] Ypoints = { y - 5, y + 5, y };
            g.setColor(currentState.getColor());
            g.fillOval((view.frame.getWidth() * getX()) / game.gridSizeX(),
                    (view.frame.getHeight() - 35) * getY() / game.gridSizeY(), 20, 20);
            g.fillOval(((view.frame.getWidth() * getX()) / game.gridSizeX()) + 3,
                    ((view.frame.getHeight() - 35) * getY() / game.gridSizeY()) - 14, 15, 15);
            g.fillPolygon(XPoints, Ypoints, 3);
        }

    }
}
