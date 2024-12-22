import java.awt.Graphics;

import javax.swing.JComponent;
import javax.swing.JFrame;

public class View extends JComponent implements IObsover {
    public JFrame frame;
    public Game game;

    public View(Game game) {
        this.game = game;
        frame = new JFrame("Penguins");
        frame.setDefaultCloseOperation(0);
        frame.setSize(1000, 515);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        frame.setContentPane(this);
        game.addObserver(this);
    }
    
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        game.drawGrid(g, this);
        for (Poussin poussin : game.getPoussins()) {
            poussin.draw(g, this);
        }
    }
    
    @Override
    public void update() {
        repaint();
    }
    
    // public void drowPoussin(Graphics g, Poussin poussin) {
    //     if (poussin.isAlive()&& poussin.getStatus()) {
    //         int x1=((frame.getWidth() * poussin.getX()) / game.gridSizeX())+10;
    //         int x3=((frame.getWidth() * poussin.getX()) / game.gridSizeX())+10+poussin.getDirection()*12;
    //         int y=((frame.getHeight() - 35) * poussin.getY() / game.gridSizeY())-8  ;
    //         int[] XPoints={x1,x1,x3};
    //         int[] Ypoints={y-5,y+5,y}; 
    //         g.setColor(poussin.getColor());
    //         g.fillOval((frame.getWidth() * poussin.getX()) / game.gridSizeX(),
    //                 (frame.getHeight() - 35) * poussin.getY() / game.gridSizeY(), 20, 20);
    //         g.fillOval(((frame.getWidth() * poussin.getX()) / game.gridSizeX())+3,
    //                 ((frame.getHeight() - 35) * poussin.getY() / game.gridSizeY())-14, 15, 15);
    //         g.fillPolygon(XPoints, Ypoints, 3);
    //     }
    // }

    // public void drawGrid(Graphics g) {
    //     for (int i = 0; i < game.gridSizeX(); i++) {
    //         for (int j = 0; j < game.gridSizeY(); j++) {
    //             g.setColor(game.grid[i][j].getColor());
    //             g.fillRect(frame.getWidth() * i / game.gridSizeX(), (frame.getHeight() - 35) * j / game.gridSizeY(),
    //                     20, 20);
    //         }
    //     }
    // }
    
    // public void drawEntry(Graphics g){
        //     g.setColor(game.getEntry().getColor());
        //     int x=game.getEntry().getX();
        //     int y=game.getEntry().getY();
        //     int X=frame.getWidth() * x / game.gridSizeX();
        //     int Y=(frame.getHeight() - 35) * (y-1) / game.gridSizeY();
        //     int[] Xs={X,X+20,X+10};
        //     int[] Ys={Y,Y, Y+20};
        //     g.fillPolygon(Xs, Ys, 3);
        
        // }
        
        // public void drawExit(Graphics g){
            //     g.setColor(game.getExit().getColor());
            //     int x=game.getExit().getX();
            //     int y=game.getExit().getY();
            //     int X=frame.getWidth() * x / game.gridSizeX();
            //     int Y=(frame.getHeight() - 35) * (y-1) / game.gridSizeY();
            //     int[] Xs={X,X+20,X+10};
            //     int[] Ys={Y,Y, Y-20};
            //     g.fillPolygon(Xs, Ys, 3);
            
            // }
            
        }
        