package game;

import java.awt.List;
import java.util.ArrayList;
import java.util.Iterator;

import poussin.Poussin;
import view.View;

public class Poussins {
    private int exits = 0;
    private int deads = 0;
    private int inStage = 0;
    public int numTotal = 4;
    public ArrayList<Poussin> poussins;

    public Poussins() {
        poussins = new ArrayList<>();
    }

    public void incNumExit() {
        exits++;
    }

    public String displayCounter() {
        String counter = "Poussin entrer: " + inStage + "\n" + " Poussin sortie: " + exits + "\n" + " Poussin mort: "
                + deads + "\n";
        return counter;
    }

    public boolean endGame() {
        return numTotal == exits + deads;
    }

    public void add(Poussin poussin) {
        poussins.add(poussin);
        inStage++;
        // System.out.println(displayCounter());
    }

    public void kill(Poussin poussin) {
        deads++;
        System.out.println(displayCounter());
    }

    public void drawAll(View view) {
        // Iterator<Poussin> iterator = poussins.iterator();
        // while (iterator.hasNext()) {
        // iterator.next().draw(view);
        // }
        ArrayList<Poussin> copy = new ArrayList<>(poussins); // Copie de la liste
        for (Poussin poussin : copy) {
            // for (Poussin poussin : poussins) {
            poussin.draw(view);
        }
    }

    // public void updateAll() {
    // // Iterator<Poussin> iterator = poussins.iterator();
    // // while (iterator.hasNext()) {
    // // iterator.next().move();
    // // }
    // for (Poussin poussin : poussins) {
    // poussin.move();
    // }
    // }
    public void updateAll() {
        ArrayList<Poussin> copy = new ArrayList<>(poussins); // Copie de la liste
        for (Poussin poussin : copy) {
            poussin.move(); // Les modifications n'affecteront pas la boucle
        }
    }

}
