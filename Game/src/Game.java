import java.io.File;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.util.ArrayList;

public class Game implements IObsovable {
    public Square[][] grid;
    public ArrayList<Poussin> poussins;
    private ArrayList<IObsover> obsovers;

<<<<<<< HEAD
    public Game() {
        grid = new Square[50][24];
        poussins = new ArrayList<>();
        obsovers = new ArrayList<>();

        //for (int i = 0; i < 10; i++) {
            poussins.add(new Poussin(1,2,1));
            poussins.add(new Poussin(1, 1,2));
        //}
        initialGame();
=======
    public int gridSizeX() {
        return 50;
>>>>>>> 24f2791e7d36ea06c4ecc5b2491476da5a45def2
    }

    public int gridSizeY() {
        return 24;
    }

    public Game() {
        grid = new Square[gridSizeX()][gridSizeY()];
        poussins = new ArrayList<>();
        obsovers = new ArrayList<>();
        AddPoussins addPoussins = new AddPoussins(this);
        try {
            File f = new File("saved.data");
            FileInputStream fin = new FileInputStream(f);
            ObjectInputStream oos = new ObjectInputStream(fin);
            grid = (Square[][]) oos.readObject();

        } catch (Exception e) {
            initialGame();
        }
        addPoussins.start();
    }

    private void initialGame() {

        Square emptySquare = new EmptySquare();
        Square lavaSquare = new LavaSquare();
        Square obstacleSquare = new ObstacleSquare();
        Square entry=new Entry();

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
<<<<<<< HEAD
        grid[0][19]=obstacleSquare;
        grid[0][20]=obstacleSquare;
        grid[49][19]=obstacleSquare;
        grid[25][20]=obstacleSquare;
        grid[49][20]=obstacleSquare;
        grid[1][2]=entry;
=======
        grid[0][19] = obstacleSquare;
        grid[0][20] = obstacleSquare;
        grid[49][19] = obstacleSquare;
        grid[25][20] = obstacleSquare;
        grid[26][19] = obstacleSquare;
        grid[49][20] = obstacleSquare;
>>>>>>> 24f2791e7d36ea06c4ecc5b2491476da5a45def2

    }

    public void updateGame() {
        for (Poussin poussin : poussins) {
            poussin.Move();
            notifyObservers(); // Update view after all moves
        }
    }

    public ArrayList<Poussin> getPoussins() {
        return poussins;
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

}
