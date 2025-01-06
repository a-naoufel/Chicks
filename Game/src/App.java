import controle.StateControls;
import game.Game;
import view.View;

public class App {
    public static void main(String[] args){
       Game game = new Game();
       StateControls controls = new StateControls();
       new View(game,controls);
       game.run();
    }
}