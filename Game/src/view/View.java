package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;

import javax.swing.ImageIcon;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import game.Game;
import poussin.Poussin;
import terrain.blockes.Cell;


public class View extends JComponent implements IObsover {
    public JFrame frame;
    private Game game;
    private int ofSetY = 35;
    private Graphics g ;
    private String selectedState="Normal";
    private int ofSet = 100;
    private JLabel counterLabel; 
    private JPanel endPanel;


    
    
    
        public View(Game game) {
            this.game = game;
            frame = new JFrame("Penguins");
            frame.setSize(1000 , 515 + ofSet);
            frame.setResizable(false);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            this.setFocusable(true);


            frame.setLayout(new BorderLayout());
            this.setPreferredSize(new Dimension(985, 515));
            frame.add(this, java.awt.BorderLayout.CENTER);
            //frame.setLayout(new BorderLayout());;
            //frame.setContentPane(this);


           


            JPanel instructionPanel = new JPanel();
            instructionPanel.setLayout(new FlowLayout(FlowLayout.CENTER)); // Align components to the left
            instructionPanel.setPreferredSize(new Dimension(900, 60)); // Explicit dimensions

            // Add icons with text
            String[] states = {"Bombeur", "Bloqueur", "Charpentier", "Foreur", "Grimpeur", "Parachutist"};
            String[] keys = {"B", "L", "M", "Y", "G", "P"};
            String[] iconPaths = {"C:\\Users\\CHAKER YOUSFI\\Desktop\\UPEC L3\\S1\\ConceptionEtProgrammationOrienteeObjet\\Penguins\\javaGame\\Game\\src\\view\\bomb.jpg",
                                    "C:\\Users\\CHAKER YOUSFI\\Desktop\\UPEC L3\\S1\\ConceptionEtProgrammationOrienteeObjet\\Penguins\\javaGame\\Game\\src\\view\\block.jpg",
                                "C:\\Users\\CHAKER YOUSFI\\Desktop\\UPEC L3\\S1\\ConceptionEtProgrammationOrienteeObjet\\Penguins\\javaGame\\Game\\src\\view\\charp.jpg",
                            "C:\\Users\\CHAKER YOUSFI\\Desktop\\UPEC L3\\S1\\ConceptionEtProgrammationOrienteeObjet\\Penguins\\javaGame\\Game\\src\\view\\Foruer.jpg",
                        "C:\\Users\\CHAKER YOUSFI\\Desktop\\UPEC L3\\S1\\ConceptionEtProgrammationOrienteeObjet\\Penguins\\javaGame\\Game\\src\\view\\",
                        "C:\\Users\\CHAKER YOUSFI\\Desktop\\UPEC L3\\S1\\ConceptionEtProgrammationOrienteeObjet\\Penguins\\javaGame\\Game\\src\\view\\Parach.jpg"};
                JLabel statesLabel =new JLabel("States: ");
                instructionPanel.add(statesLabel);
            for (int i = 0; i < states.length; i++) {
                // Load and resize the icon
                ImageIcon icon = new ImageIcon(iconPaths[i]);
                Image img = icon.getImage();
                Image scaledImg = img.getScaledInstance(30, 30, Image.SCALE_SMOOTH);
                icon = new ImageIcon(scaledImg);

                JLabel label = new JLabel(states[i] + " (Press " + keys[i] + ")");
                label.setIcon(icon);
                label.setHorizontalTextPosition(JLabel.RIGHT);
                label.setVerticalTextPosition(JLabel.CENTER);

                instructionPanel.add(label);

                
}
                counterLabel= new JLabel( game.poussins.displayCounter());
                counterLabel.setFont(new Font("SansSerif", Font.BOLD, 16));
                instructionPanel.add(counterLabel);

            

            frame.add(instructionPanel, BorderLayout.SOUTH);


            
                    
            
            this.addKeyListener(new KeyAdapter() {
                @Override
                public void keyPressed(KeyEvent e) {
                    char keyChar = e.getKeyChar();
                    if (keyChar == 'b' || keyChar == 'B') {
                        selectedState = "Bombeur"; 
                        System.out.println("State changed to Bombeur");
                    } else if (keyChar == 'l' || keyChar == 'L') {
                        selectedState = "Bloquer"; 
                        System.out.println("State changed to Bloqueur");
                    }else if (keyChar == 'm' || keyChar == 'M') {
                        selectedState = "Charpentier"; 
                        System.out.println("State changed to Charpentier");
                    }else if (keyChar == 'y' || keyChar == 'Y') {
                        selectedState = "Foureur"; 
                        System.out.println("State changed to Foureur");
                    }else if (keyChar == 'g' || keyChar == 'G') {
                        selectedState = "Grimpeur"; 
                        System.out.println("State changed to Grimpeur");
                    }
                    else if (keyChar == 'p' || keyChar == 'P') {
                        selectedState = "Parachutist"; 
                        System.out.println("State changed to Parachutist");
                    }
                    
                    
                    
                }
            });
    
    
            this.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(java.awt.event.MouseEvent e) {
                    super.mouseClicked(e);
                    int x = e.getX();
                    int y = e.getY();
                    
    
                    int gridX = x * game.getTerrain().gridSizeX() / getWidth();
                    int gridY = y * game.getTerrain().gridSizeY() / getHeight();
                    
    
                Poussin clickedPoussin = game.getPoussinClicked(gridX, gridY);
                if (clickedPoussin!=null){
                    clickedPoussin.changeState(clickedPoussin, selectedState);
                }
               
                }
            
        });

            frame.pack(); 
            frame.setVisible(true);
            game.addObserver(this);
        }

        public void showEndPanel() {
            // Supprimer tous les composants existants
                frame.getContentPane().removeAll();

                // Configurer le panneau de fin
                JPanel endPanel = new JPanel();
                endPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
                endPanel.setBackground(Color.BLACK);

                JLabel endLabel = new JLabel("La partie est terminée !");
                endLabel.setFont(new Font("SansSerif", Font.BOLD, 24));
                endLabel.setForeground(Color.WHITE);
                endPanel.add(endLabel);

                

                // Ajouter le panneau de fin au frame
                frame.add(endPanel, BorderLayout.CENTER);

                // Rafraîchir l'affichage
                frame.revalidate();
                frame.repaint();
        }
        

        
    
        public Graphics getGraphics(){
            return g;
        }
    
        public int getHeight() {
            return frame.getHeight() - ofSetY - ofSet;
        }
    
        public int getWidth() {
            return frame.getWidth();
    }

    public int gridSizeX() {
        return game.getTerrain().gridSizeX();
    }

    public int gridSizeY() {
        return game.getTerrain().gridSizeY();
    }

    @Override
    protected void paintComponent(Graphics g) {
        this.g = g;
        super.paintComponent(g);
        game.draw(this);

        

    }

    public void drawTrangle(Cell c) {
        int X = getWidth() * c.getX() / gridSizeX();
        int Y = getHeight() * (c.getY()- 1) / gridSizeY();
        int[] Xs = { X, X + 20, X + 10 };
        int[] Ys = { Y, Y, Y - 20 };
        g.fillPolygon(Xs, Ys, 3);
    }

    public void drawSquare(Cell c) {
        g.fillRect(getWidth() * c.getX() / gridSizeX(), getHeight() * c.getY() / gridSizeY(), c.getSize(), c.getSize());
    }
    public void setColor(Color c){
        g.setColor(c);
    }

    @Override
    public void update() {
        counterLabel.setText(game.poussins.displayCounter());
        repaint();
    }

}
