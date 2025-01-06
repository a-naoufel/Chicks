package game;

import java.io.File;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.util.ArrayList;

import poussin.Poussin;
import terrain.Terrain;
import terrain.blockes.Cell;
import terrain.blockes.EmptySquare;
import terrain.blockes.Entry;
import terrain.blockes.Exit;
import terrain.blockes.LavaSquare;
import terrain.blockes.ObstacleSquare;
import view.IObsover;
import view.View;

public class Game implements IObsovable {
    private Terrain terrain;
    public Poussins poussins;
    private ArrayList<IObsover> obsovers;
    private String selectedLeval = "leval1.data";

    public Game() {
        terrain = new Terrain();
        poussins = new Poussins();
        obsovers = new ArrayList<>();
    }

    public void incNumExit() {
        poussins.incNumExit();
    }

    public void run() {
        initialGame();
        updateGame();
        do {
            updateGame();
            mysleep(300);
        } while (!poussins.endGame());
        end();
    }

    public Entry getEntry() {
        return terrain.getEntry();
    }

    public Cell getCell(int i, int j) {
        return terrain.getCell(i, j);
    }

    public void setCell(int i, int j, Cell cell) {
        terrain.setCell(i, j, cell);
    }

    public void end() {
        View view = (View) obsovers.get(0);
        System.out.println("La Fin");

        view.showEndPanel();
        }

    public void updateGame() {
        poussins.updateAll();
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

        for (int i = 0; i < terrain.gridSizeX(); i++) {
            for (int j = 0; j < terrain.gridSizeY(); j++) {
                setCell(i, j, new EmptySquare());
            }
        }
        for (int i = 0; i < terrain.gridSizeX(); i++) {
            for (int j = 22; j < terrain.gridSizeY(); j++) {
                setCell(i, j, new LavaSquare());
            }
        }
        for (int i = 0; i < terrain.gridSizeX(); i++) {
            for (int j = 21; j < 22; j++) {
                setCell(i, j, new ObstacleSquare());
            }
        }
        setCell(0, 19, new ObstacleSquare());
        setCell(0, 20, new ObstacleSquare());
        setCell(49, 19, new ObstacleSquare());
        setCell(25, 20, new ObstacleSquare());
        setCell(26, 19, new ObstacleSquare());
        setCell(49, 20, new ObstacleSquare());
        setCell(45, 20, new Exit());
        terrain.setEntry(2, 15);
    }

    public void initialGame() {
        // laoding the game grid form a saved.data
        try {
            loadStage(selectedLeval);
        } catch (Exception e) {
            defaultGame();
        } finally {
            new AddPoussins(this).start();
        }

    }

    private void loadStage(String leval) throws Exception {
        File f = new File(leval);
        FileInputStream fin = new FileInputStream(f);
        ObjectInputStream oos = new ObjectInputStream(fin);
        terrain = (Terrain) oos.readObject();
        oos.close();
    }

    public void addPoussin(Poussin poussin) {
        poussins.add(poussin);
    }

    public Terrain getTerrain() {
        return terrain;
    }

    public void mysleep(int delay) {
        try {
            Thread.sleep(delay);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void draw(View view) {
        terrain.draw(view);
        poussins.drawAll(view);
    }

    public int getNumTotal() {
        return poussins.numTotal;
    }

    public Poussin getPoussinClicked(int x, int y) {
        for (Poussin poussin : poussins.poussins) {
            if (poussin.getX() == x && poussin.getY() == y) {
                return poussin;
            }
            if (poussin.getX() == x && poussin.getY() == y + 1) {
                return poussin;
            }
        }
        return null;
    }

    public void kill(Poussin poussin) {
        poussins.kill(poussin);
    }
}