package game;

import java.util.ArrayList;

import poussin.Poussin;
import view.View;

public class Poussins {
    private int exits = 0;
    private int deads = 0;
    private int inStage = 0;
    public int numTotal = 4;
    public ArrayList<Poussin> poussins;

    public Poussins(){
        poussins = new ArrayList<>();
    }
    public void incNumExit(){
        exits ++;
    }

    public String displayCounter() {
        String counter="Poussin entrer: " + inStage +"\n Poussin sortie: " + exits+ "\n Poussin mort: " + deads + "\n";
        // System.out.println("Poussin entrer: " + inStage);
        // System.out.println("Poussin sortie: " + exits);
        // System.out.println("Poussin mort: " + deads + "\n");
        return counter;
    }

    public boolean endGame() {
        return numTotal == exits + deads;
    }

    public void add(Poussin poussin) {
        poussins.add(poussin);
        inStage++;
        System.out.println(displayCounter());
    }

    public void kill() {
        inStage--;
        System.out.println(displayCounter());
    }
    public void drawAll(View view){
        for (Poussin poussin : poussins) {
            poussin.draw(view);
        }
    }
    public void updateAll(){
        for (Poussin poussin : poussins) {
            poussin.move();
        }
    }
}
