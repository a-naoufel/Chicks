public class App {
    public static void main(String[] args){
       Game game = new Game();
       View view = new View(game); 
       game.start();
    }
}