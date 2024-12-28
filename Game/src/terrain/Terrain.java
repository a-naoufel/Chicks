package terrain;

import java.io.Serializable;

import terrain.blockes.Cell;
import terrain.blockes.Entry;
import terrain.blockes.LavaSquare;
import view.View;

public class Terrain implements Serializable {
    private Cell[][] grid;
    private Entry entry;

    public Terrain() {
        grid = new Cell[gridSizeX()][gridSizeY()];
    }

    public void draw(View view) {
        for (int i = 0; i < gridSizeX(); i++) {
            for (int j = 0; j < gridSizeY(); j++) {
                if (getCell(i, j) != null)
                    getCell(i, j).draw(view);
            }
        }
    }

    public Cell[][] getCells() {
        return grid;
    }

    public void setCell(Cell[][] grid) {
        this.grid = grid;
    }

    public int gridSizeX() {
        return 50;
    }

    public int gridSizeY() {
        return 24;
    }

    public Entry getEntry() {
        return entry;
    }

    public Cell getCell(int i, int j) {
        if (outOfBoundsX(i) || outOfBoundsY(j))
            return new LavaSquare(0, 0);
        return grid[i][j];
    }

    public void setCell(int i, int j, Cell cell) {
        cell.setCoordinates(i, j);
        if (!(outOfBoundsX(i) || outOfBoundsY(j)))
            grid[i][j] = cell;
    }

    public boolean outOfBoundsX(int x) {
        return x < 0 || x >= gridSizeX();
    }

    public boolean outOfBoundsY(int y) {
        return y < 0 || y >= gridSizeY();
    }

    public void setEntry(int i, int j) {
        entry = new Entry(i, j);
        setCell(i, j, entry);
    }

}
