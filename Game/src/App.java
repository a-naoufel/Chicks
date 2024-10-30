public class App {
    public static void main(String[] args){
       Game game = new Game();
       View view = new View(game); 


       new Thread(() -> {
        while (true) {
            game.updateGame();;
            try {
                Thread.sleep(200); // adjust for game speed
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }).start();
    }
}
