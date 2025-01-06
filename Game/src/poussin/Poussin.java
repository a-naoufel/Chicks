package poussin;

import game.Game;
import poussin.state.NormalState;
import poussin.state.PoussinState;
import terrain.Terrain;
import terrain.blockes.Cell;
import terrain.blockes.Entry;
import terrain.blockes.ObstacleSquare;
import view.View;

public class Poussin {
    private int x;
    private int y;
    private boolean isAlive;
    private int direction;// 1: for right and -1: for left
    private PoussinState currentState;
    public int id;
    public Game game;
    public Terrain terrain;
    public int fallcoun;

    public Poussin(int id, Game game) {
        this.game = game;
        terrain = game.getTerrain();
        isAlive = true;
        this.id = id;
        fallcoun = 0;
        direction = 1;
        setEntry();
        this.currentState = new NormalState(this);

    }

    private void setEntry() {
        Entry e = game.getEntry();
        x = e.getX();
        y = e.getY();
    }

    public Cell getRelativCell(int i, int j) {
        return game.getCell(i + x, j + y);
    }

    public void setRelativeCell(int i, int j, Cell cell) {
        game.setCell(x + i, y + j, cell);
    }

    public void setState(PoussinState state) {
        if (state == null)
            return;

        state.setPoussin(this);
        currentState.exit();
        this.currentState = state;
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
        if (terrain.outOfBoundsX(x + direction))
            changeDirction();
        else if (canStepAHead() && fallcoun == 0) {
            x += direction;
        } else {
            if (fallcoun == 0)
                changeDirction();
        }
    }

    public void kill() {
        System.out.println("kill");
        if (isAlive) {
            currentState.exit();
            game.kill(this);
            isAlive = false;
            x = -1;
            y = -1;
        }
    }

    public boolean canStepAHead() {
        if (!isAlive || terrain.outOfBoundsX(x + direction) || terrain.outOfBoundsY(y - 1))
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

    public void setFallCount(int i) {
        fallcoun = i;
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

    public void takeSters() {
        if (stears()) {
            moveup();
            x += direction;
        }
    }

    public void inCell() {
        if (isAlive) {
            getRelativCell(0, 0).handale(this);
            getRelativCell(0, -1).handale(this);
        }
    }

    public void hitExit() {

        isAlive = false;
        x = -1;
        y = -1;
        System.out.println("poussin id " + id + " hit the exit");
        game.incNumExit();

    }

    public void move() {
        if (isAlive)
            currentState.move();
        game.notifyObservers(); // Update view after all moves

    }

    public void draw(View view) {
        if (isAlive)
            drawPoussin(view);

    }

    private void drawPoussin(View view) {

        view.setColor(currentState.getColor());
        view.drawBaddy(getX(), getY());

        view.drawHead(getX(), getY(), getDirection());

    }

    public class Move {

    }
}
