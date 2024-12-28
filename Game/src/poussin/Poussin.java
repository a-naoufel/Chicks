package poussin;
import java.awt.Graphics;

import terrain.*;
import state.GrimpeurState;
import state.NormalState;
import state.PoussinState;
import terrain.blockes.Cell;
import terrain.blockes.ObstacleSquare;
import view.View;

public class Poussin {
    private int x;
    private int y;
    private boolean isAlive;
    private int direction;// 1: for right and -1: for left
    private PoussinState currentState;
    public int id;
    public Terrain game;
    public int fallcoun;
    private static int numPoussinExit = 0;
    private static int numPoussindead = 0;
    private static int numPoussin = 0;
    public static int numTotal = 4;
    private long stateChangeTime; // moment où l'état doit changer
    private long delay = 5000; // délai avant de changer l'état, en millisecondes

    public Poussin(int id, Terrain game) {
        x = game.getEntry().getX();
        y = game.getEntry().getY();
        isAlive = true;
        fallcoun = 0;
        direction = 1;
        this.game = game;
        this.id = id;
        this.currentState = new NormalState(this);
        this.stateChangeTime = System.currentTimeMillis() + delay; // initier l'heure de changement

    }

    public Cell getRelativCell(int i, int j) {
        return game.getCell(i + x, j + y);
    }

    public void setRelativeCell(int i, int j, Cell cell) {
        game.setCell(x + i, y + j, cell);
    }

    public void setState(PoussinState state) {
        state.setPoussin(this);
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
        displayCounter();
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

    public void goAHead() {
        if (canStepAHead() && fallcoun == 0) {
            x += direction;
        } else {
            if (fallcoun == 0)
                changeDirction();
        }
    }

    public void kill() {
        if (isAlive) {
            isAlive = false;
            currentState.exit();
            numPoussindead++;
            displayCounter();
        }
    }

    public boolean canStepAHead() {
        if (!isAlive || game.outOfBoundsX(x + direction) || game.outOfBoundsY(y - 1))
            return false;
        return !(getRelativCell(direction, -1) instanceof ObstacleSquare
                || getRelativCell(direction, 0) instanceof ObstacleSquare);
    }

    public boolean stears() {
        return !(getRelativCell(direction, -1) instanceof ObstacleSquare
                || getRelativCell(0, -1) instanceof ObstacleSquare)
                && (getRelativCell(direction, 0) instanceof ObstacleSquare)
                && !canFall();
    }

    public void fall() {
        if (isAlive)
            if (canFall()) {
                y++;
                fallcoun++;
            } else if (fallcoun > 5)
                kill();
            else
                fallcoun = 0;

    }

    public boolean canFall() {
        return isAlive && !(getRelativCell(0, 1) instanceof ObstacleSquare);
    }

    public void changeDirction() {
        direction *= -1;
    }

    public void moveup() {
        y--;
    }
    public void takeSters(){
        if (stears())
            moveup();
    }

    public void inCell() {
        if (isAlive) {
            getRelativCell(0, 0).handale(this);
            getRelativCell(0, -1).handale(this);
        }
    }

    public void hitExit() {

        System.out.println("poussin id " + id + " hit the exit");
        numPoussinExit++;
        displayCounter();
        isAlive = false;

    }

    public void move() {
        if (isAlive)
            currentState.move();
        if (System.currentTimeMillis() >= stateChangeTime) {
            setState(new GrimpeurState(this));
            stateChangeTime = System.currentTimeMillis() + delay;
        }

    }

    public void draw(Graphics g, View view) {
        if (isAlive) {
            int width = view.getWidth();
            int height = view.getHeight();

            int x1 = (width * getX() / game.gridSizeX()) + 10;
            int x3 = (width * getX() / game.gridSizeX()) + 10 + getDirection() * 12;
            int y1 = (height * getY() / game.gridSizeY()) - 8;

            int[] XPoints = { x1, x1, x3 };
            int[] Ypoints = { y1 - 5, y1 + 5, y1 };

            g.setColor(currentState.getColor());
            g.fillOval(width * getX() / game.gridSizeX(), height * getY() / game.gridSizeY(), 20, 20);
            g.fillOval(width * getX() / game.gridSizeX() + 3, height * getY() / game.gridSizeY() - 14, 15, 15);
            g.fillPolygon(XPoints, Ypoints, 3);
        }

    }
}
