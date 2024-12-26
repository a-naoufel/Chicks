import java.awt.Graphics;
import java.io.File;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.util.ArrayList;

public class Game implements IObsovable {
    public Cell[][] grid;
    public ArrayList<Poussin> poussins;
    private ArrayList<IObsover> obsovers;
    private Entry entry;
    private String selectedLeval = "leval1.data";
    
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
    
        public Game() {
            grid = new Cell[gridSizeX()][gridSizeY()];
            poussins = new ArrayList<>();
            obsovers = new ArrayList<>();
            entry = new Entry(2, 15);
    
        }
    
        public void run() {
            initialGame();
            do {
                updateGame();
                mysleep(200);
            } while (!Poussin.endGame());
            View view = (View) obsovers.get(0);
            System.out.println("La Fin");
            view.frame.setVisible(false);
        }
    
        public void draw(Graphics g, View view) {
            for (int i = 0; i < gridSizeX(); i++) {
                for (int j = 0; j < gridSizeY(); j++) {
                    if (grid[i][j] != null) {
                        grid[i][j].draw(i, j, g, view);
                    }
                }
            }
        }
    
        public void updateGame() {
            ArrayList<Poussin> temppoussin = new ArrayList<>();
            temppoussin.addAll(poussins);
            for (Poussin poussin : temppoussin) {
                poussin.move();
                notifyObservers(); // Update view after all moves
            }
        }
    
        public ArrayList<Poussin> getPoussins() {
            return new ArrayList<>(poussins);
        }
    
        public void addObserver(IObsover o) {
            obsovers.add(o);
        }
    
        @Override
        public void removeObserver(IObsover o) {
            obsovers.remove(o);
        }
    
        @Override
        public void notifyObservers() {
            for (IObsover o : obsovers) {
                o.update();
            }
        }
    
        public void defaultGame() {
            Cell emptySquare = new EmptySquare();
            Cell lavaSquare = new LavaSquare();
            Cell obstacleSquare = new ObstacleSquare();
    
            for (int i = 0; i < gridSizeX(); i++) {
                for (int j = 0; j < gridSizeY(); j++) {
                    grid[i][j] = emptySquare;
                }
            }
            for (int i = 0; i < gridSizeX(); i++) {
                for (int j = 22; j < gridSizeY(); j++) {
                    grid[i][j] = lavaSquare;
                }
            }
            for (int i = 0; i < gridSizeX(); i++) {
                for (int j = 21; j < 22; j++) {
                    grid[i][j] = obstacleSquare;
                }
            }
            grid[0][19] = obstacleSquare;
            grid[0][20] = obstacleSquare;
            grid[49][19] = obstacleSquare;
    
            grid[25][20] = obstacleSquare;
            grid[26][19] = obstacleSquare;
            grid[49][20] = obstacleSquare;
            grid[entry.getX()][entry.getY()] = entry;
            grid[45][20] = new Exit();
        }
    
        public void initialGame() {
            // laoding the game grid form a saved.data
            try {
                loadstage(selectedLeval);
        } catch (Exception e) {
            defaultGame();
        } finally {
            new AddPoussins(this).start();
        }

    }
    private void loadstage(String leval) throws Exception{
        File f = new File(leval);
            FileInputStream fin = new FileInputStream(f);
            ObjectInputStream oos = new ObjectInputStream(fin);
            grid = (Cell[][]) oos.readObject();
            oos.close();
    }

    public void addPoussin(Poussin poussin) {
        poussins.add(poussin);
        Poussin.add();
    }

    public void removePoussin(Poussin poussin) {
        poussins.remove(poussin);
    }

    public void mysleep(int delay) {
        try {
            Thread.sleep(delay);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}