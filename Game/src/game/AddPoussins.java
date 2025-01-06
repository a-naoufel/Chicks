package game;
import poussin.Poussin;

public class AddPoussins extends Thread{
    Game game;
    int delay = 2000;

    public AddPoussins(Game game){
        this.game = game;
    }

    @Override
    public void run(){
        for (int i = 0; i < game.getNumTotal(); i++) {
            game.addPoussin(new Poussin(i,game));
            game.mysleep(delay);
        }
    }
}
