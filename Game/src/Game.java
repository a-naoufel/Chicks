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

    public int gridSizeX() {
        return 50;
    }

    public int gridSizeY() {
        return 24;
    }

    public Entry getEntry() {
        return entry;
    }
    public Cell getCell(int i,int j){
        return grid[i][j];
    }
    public void setCell(int i,int j,Cell cell){
        grid[i][j] = cell;
    }
    public boolean outOfBoundsX(int x){
        return x < 0 || x >= gridSizeX();
    }
    public boolean outOfBoundsY(int y){
        return y < 0 || y >= gridSizeY();

    }

    public Game() {
        grid = new Cell[gridSizeX()+2][gridSizeY()+2];
        poussins = new ArrayList<>();
        obsovers = new ArrayList<>();
        entry = new Entry(2, 15);

    }

    public void run() {
        initialGame();
        do {
            updateGame();
            try {
                Thread.sleep(200); // adjust for game speed
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        } while (!Poussin.endGame());
        View view = (View) obsovers.get(0);
        System.out.println("La Fin");
        view.frame.setVisible(false);
    }

    public void drawGrid(Graphics g, View view) {
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
            poussin.Move();
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
        // grid[entry.getX()][20] = lavaSquare;
        grid[45][20] = new Exit();
    }

    public void initialGame() {
        // laoding the game grid form a saved.data
        try {
            File f = new File("leval1.data");
            FileInputStream fin = new FileInputStream(f);
            ObjectInputStream oos = new ObjectInputStream(fin);
            grid = (Cell[][]) oos.readObject();
            oos.close();

        } catch (Exception e) {
            defaultGame();
        } finally {
            new AddPoussins(this).start();
        }

    }
    public void addPoussin(Poussin poussin){
        poussins.add(poussin);
        Poussin.add();
    }
    public void removePoussin(Poussin poussin){
        poussins.remove(poussin);
    }
}
