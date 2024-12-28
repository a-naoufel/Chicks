package game;

import java.awt.Graphics;
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
    public ArrayList<Poussin> poussins;
    private ArrayList<IObsover> obsovers;
    private String selectedLeval = "leval1.data";

    public int gridSizeX() {
        return terrain.gridSizeX();
    }

    public int gridSizeY() {
        return terrain.gridSizeY();
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

    public Game() {
        terrain = new Terrain();
        poussins = new ArrayList<>();
        obsovers = new ArrayList<>();
    }

    public void run() {
        initialGame();
        do {
            updateGame();
            mysleep(200);
        } while (!Poussin.endGame());
        end();
    }

    public void end() {
        View view = (View) obsovers.get(0);
        System.out.println("La Fin");
        view.frame.setVisible(false);
    }

    public void draw(Graphics g, View view) {
        terrain.draw(g, view);
        for (Poussin poussin : poussins) {
            poussin.draw(g, view);
        }
    }

    public void updateGame() {
        for (Poussin poussin : poussins) {
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

        for (int i = 0; i < gridSizeX(); i++) {
            for (int j = 0; j < gridSizeY(); j++) {
                setCell(i, j, new EmptySquare());
            }
        }
        for (int i = 0; i < terrain.gridSizeX(); i++) {
            for (int j = 22; j < gridSizeY(); j++) {
                setCell(i, j, new LavaSquare());
            }
        }
        for (int i = 0; i < gridSizeX(); i++) {
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
        Poussin.add();
    }

    public void removePoussin(Poussin poussin) {
        poussins.remove(poussin);
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
}