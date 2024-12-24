
public class AddPoussins extends Thread{
    Game game;
    public AddPoussins(Game game){
        this.game = game;
    }
    @Override
    public void run() {
        super.run();
        for (int i = 0; i < Poussin.numTotal; i++) {
            game.poussins.add(new Poussin(i,game));
            Poussin.add();
            Poussin.displayCounter();
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}
