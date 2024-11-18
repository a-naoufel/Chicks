import java.awt.Color;

public class EmptySquare extends Cell {
    public EmptySquare() {
        color = Color.BLUE;
    }

    @Override
    public void handalePoussin(Poussin p) {
        if (!p.fall()) {
            if (p.fallcoun > 5) {
                p.killpoussin();
            }

            else
                p.fallcoun = 0;
            if (p.obstistical()) {
                p.takeOthreDirction();

            } else if (p.canMouveX()) {
                p.takeStepX();
            } else {
                p.takeStepX();
                p.moveup();
            }

        } else {
            p.fallcoun++;
        }
    }
}
