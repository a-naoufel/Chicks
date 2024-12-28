package terrain;

import java.awt.Graphics;
import java.io.Serializable;

import terrain.blockes.Cell;
import terrain.blockes.Entry;
import terrain.blockes.LavaSquare;
import view.View;

public class Terrain implements Serializable{
        private Cell[][] grid;
        private Entry entry;

        public Cell[][] getCells(){
            return grid;
        }
        public void setCell(Cell[][] grid){
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
                return new LavaSquare();
            return grid[i][j];
        }
    
        public void setCell(int i, int j, Cell cell) {
            if (!(outOfBoundsX(i) || outOfBoundsY(j)))
                grid[i][j] = cell;
        }
    
        public boolean outOfBoundsX(int x) {
            return x < 0 || x >= gridSizeX();
        }
    
        public boolean outOfBoundsY(int y) {
            return y < 0 || y >= gridSizeY();
    
        }
        public Terrain() {
            grid = new Cell[gridSizeX()][gridSizeY()];
        }
        public void draw(Graphics g, View view) {
            for (int i = 0; i < gridSizeX(); i++) {
                for (int j = 0; j < gridSizeY(); j++) {
                   drawCell(i, j, g, view);
                }
            }
        }
        private void drawCell(int i,int j,Graphics g,View view){
            if (grid[i][j] != null) {
                getCell(i, j).draw(i, j, g, view);
            }
        }
        public void setEntry(int i,int j){
            entry = new Entry(i, j);
            setCell(i, j, entry);
        }
    

}
