package terrain.blockes;
import java.awt.Color;

import poussin.Poussin;

public class EmptySquare extends Cell {
    public EmptySquare() {
        color = Color.BLUE;
    }

    @Override
    public void handale(Poussin p) {
    }
}
