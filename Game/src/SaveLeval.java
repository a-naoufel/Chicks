import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

import game.Game;

public class SaveLeval {
    static Game game;

    public static void main(String[] args) throws IOException {
        game = new Game();
        game.defaultGame();
        saveLeval("leval1.data");
    }

    private static void saveLeval(String leval) throws IOException {
        File f = new File(leval);
        FileOutputStream fos = new FileOutputStream(f);
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        oos.writeObject(game.getTerrain());
        oos.close();
    }
}
