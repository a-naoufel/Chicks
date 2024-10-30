import java.awt.Color;

public class Poussin {
    public EmptySquare emptySquare;
    private int x;
    private int y;
    private boolean isAlive;
    private int direction;// 0: for right and 1: for left
    private Color PoussColor=Color.YELLOW; 
    
    public Poussin(int x, int y){
        this.x = x;
        this.y = y;
        this.isAlive=true;
        this.direction=0;
    }

    public int getX(){
        return x;
    }
    public int getY(){
        return y;
    }
    public boolean isAlive(){
        return isAlive;
    }
    public int getDirection(){
        return direction;
    }
    public Color getColor(){
        return PoussColor;
    }

    public void Move(Square [][] grid){
        if(this.isAlive()){
            //System.out.println(this.x);
            //System.out.println(this.y);
            if(grid[this.x][this.y+1] instanceof EmptySquare){
                this.y++;
                
            }
            else{
                if(direction==0){
                    if(grid[this.x+1][this.y] instanceof EmptySquare){
                        this.x++;
                }
                else{
                    if(grid[this.x-1][this.y] instanceof EmptySquare){
                        this.x--;
                }
            }
                

        }
    }
        }
    }
}
