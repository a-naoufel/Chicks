package poussin;

import java.awt.Graphics;

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
        state.setPoussin(this);
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
        if (canStepAHead() && fallcoun == 0) {
            x += direction;
        } else {
            if (fallcoun == 0)
                changeDirction();
        }
    }

    public void kill() {
        if (isAlive) {
            currentState.exit();
            isAlive = false;
            // game.addPoussin(this);
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
        game.incNumExit();
        isAlive = false;

    }

    public void move() {
        if (isAlive)
            currentState.move();
        // if (System.currentTimeMillis() >= stateChangeTime) {
        //     setState(new BombeurState(this));
        //     stateChangeTime = System.currentTimeMillis() + delay;
        // }
        game.notifyObservers(); // Update view after all moves


    }

    public void draw(View view) {
        if (isAlive) 
            drawPoussin(view);
        

    }
    
    private void drawPoussin(View view){
        Graphics g = view.getGraphics();
        int width = view.getWidth();
        int height = view.getHeight();

        int x1 = (width * getX() / terrain.gridSizeX()) + 10;
        int x3 = (width * getX() / terrain.gridSizeX()) + 10 + getDirection() * 12;
        int y1 = (height * getY() / terrain.gridSizeY()) - 8;

        int[] XPoints = { x1, x1, x3 };
        int[] Ypoints = { y1 - 5, y1 + 5, y1 };

        g.setColor(currentState.getColor());
        g.fillOval(width * getX() / terrain.gridSizeX(), height * getY() / terrain.gridSizeY(), 20, 20);
        g.fillOval(width * getX() / terrain.gridSizeX() + 3, height * getY() / terrain.gridSizeY() - 14, 15, 15);
        g.fillPolygon(XPoints, Ypoints, 3);
    }
    public class Move {
    
        
    }
}
