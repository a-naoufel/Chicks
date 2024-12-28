package terrain.blockes;
import java.awt.Color;

import poussin.Poussin;
import view.View;

public class Exit extends Cell implements ObstacleIndestructible{
    public Exit(int i,int j){
        super(i, j);
    }
    public Exit(){
        super();

    }

    public void draw(View view) {
        super.draw(view);
        view.setColor(Color.YELLOW);
        view.drawTrangle(this);

    }


    @Override
    public void handale(Poussin p) {
        p.hitExit();
    }

}
