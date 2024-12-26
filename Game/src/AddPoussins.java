
public class AddPoussins extends Thread{
    Game game;
    int delay = 3000;

    public AddPoussins(Game game){
        this.game = game;
    }

    @Override
    public void run(){
        for (int i = 0; i < Poussin.numTotal; i++) {
            System.out.println("add " + i);
            game.addPoussin(new Poussin(i,game));
            game.mysleep(delay);
        }
    }
}
