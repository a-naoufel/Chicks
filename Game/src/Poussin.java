import java.awt.Color;

public class Poussin {
    public EmptySquare emptySquare;
    private int x;
    private int y;
    private boolean isAlive;
    private int direction;// 1: for right and -1: for left
    private Color PoussColor=Color.YELLOW; 
    public int id;
    
    public Poussin(int x, int y,int id){
        this.x = x;
        this.y = y;
        this.id = id;
        this.isAlive=true;
        this.direction=1;
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
                    if(grid[this.x+direction][this.y] instanceof EmptySquare){
                        this.x = this.x+direction;
                    }else if(!(grid[this.x+direction][this.y-1] instanceof EmptySquare)|!(grid[this.x][this.y-1] instanceof EmptySquare)){
                        
                        direction*=-1;
                    }else if(y>0){
                        this.x = this.x+direction;
                        this.y = this.y-1;
                    }
            }
                

        }
    }
        }
