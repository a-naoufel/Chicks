import java.awt.Color;

public class NormalState implements PoussinState {

    @Override
    public void move(Poussin poussin) {
        if (!poussin.isAlive()) {
            return;
        }
        if(poussin.game.grid[poussin.getX()][poussin.getY()-1] instanceof LavaSquare)
            poussin.killpoussin();
        
        poussin.game.grid[poussin.getX()][poussin.getY()].handalePoussin(poussin);
        
    }

    @Override
    public Color getColor(){
        return Color.YELLOW;
    }

    
    }
    

