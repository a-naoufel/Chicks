import java.util.ArrayList;

public class Game implements IObsovable{
    public Square[][] grid;
    private ArrayList<Poussin> poussins;
    private ArrayList<IObsover> obsovers;

    public Game() {
        grid = new Square[50][24];
        poussins = new ArrayList<>();
        obsovers = new ArrayList<>();

        //for (int i = 0; i < 10; i++) {
            poussins.add(new Poussin(1,2,1));
            poussins.add(new Poussin(5, 4,2));
        //}
        initialGame();
    }

    
    private void initialGame(){
    
        Square emptySquare = new EmptySquare();
        Square lavaSquare = new LavaSquare();
        Square obstacleSquare = new ObstacleSquare();

        for(int i = 0 ;i<50;i++){
            for(int j = 0;j<24;j++){
                grid[i][j] = emptySquare;
            }
        }
        for(int i = 0 ;i<50;i++){
            for(int j = 22;j<24;j++){
                grid[i][j] = lavaSquare;
            }
        }
        for(int i = 0 ;i<50;i++){
            for(int j = 21;j<22;j++){
                grid[i][j] = obstacleSquare;
            }
        }
        grid[0][19]=obstacleSquare;
        grid[0][20]=obstacleSquare;
        grid[49][19]=obstacleSquare;
        grid[25][20]=obstacleSquare;
        grid[49][20]=obstacleSquare;

       
        }

        public void updateGame() {
            for (Poussin poussin : poussins) {
                poussin.Move(grid); 
                notifyObservers(); // Update view after all moves
            }
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
