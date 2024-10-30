import java.util.ArrayList;

public class Game implements IObsovable{
    public Square[][] grid;
    private ArrayList<Poussin> poussins;
    private ArrayList<IObsover> obsovers;

    public Game() {
        grid = new Square[200][100];
        poussins = new ArrayList<>();
        obsovers = new ArrayList<>();

        //for (int i = 0; i < 10; i++) {
            poussins.add(new Poussin(10,10));
            poussins.add(new Poussin(10, 40));
        //}
        initialGame();
    }

    
    private void initialGame(){
    
        Square emptySquare = new EmptySquare();
        Square lavaSquare = new LavaSquare();
        Square obstacleSquare = new ObstacleSquare();

        for(int i = 0 ;i<200;i++){
            for(int j = 0;j<80;j++){
                grid[i][j] = emptySquare;
            }
        }
        for(int i = 0 ;i<200;i++){
            for(int j = 90;j<100;j++){
                grid[i][j] = lavaSquare;
            }
        }
        for(int i = 0 ;i<200;i++){
            for(int j = 80;j<90;j++){
                grid[i][j] = obstacleSquare;
            }
        }
       
        }

        public void updateGame() {
            for (Poussin poussin : poussins) {
                poussin.Move(grid); 
            }
            notifyObservers(); // Update view after all moves
        }
        
        
    

    public ArrayList<Poussin> getPoussins(){
        return poussins;
    }

    public void addObserver(IObsover o){
        obsovers.add(o);
    }
    @Override
    public void removeObserver(IObsover o) {
        obsovers.remove(o);
    }
    @Override
    public void notifyObservers() {
        for(IObsover o: obsovers){
            o.update();
        }
    }

}
