import game.Game;
import view.View;

public class App {
    public static void main(String[] args){
       Game game = new Game();
       new View(game);
       game.run();
    }
}