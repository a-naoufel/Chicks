import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class SaveLeval {
    public static void main(String[] args) throws IOException {
        Game game = new Game();
        game.defaultGame();
        File f = new File("leval1.data");
        FileOutputStream fos = new FileOutputStream(f);
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        oos.writeObject(game.grid);
        oos.close();
    }
}
