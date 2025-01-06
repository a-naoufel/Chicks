package view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;

public class MyFrame extends JFrame implements KeyListener{
    private int pixelSize = 31;
    private int ofSet = 100;
    private int ofSetY = 35;
    private View view;

    public MyFrame(View view){
        this.view = view;
        super("Penguins");
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        addKeyListener(this);
    }
    public void reSize(int x,int y){
        setSize(new Dimension(pixelSize * x, pixelSize * y + ofSetY + ofSet));
    }
 
    @Override
    public void keyPressed(KeyEvent e) {
        System.out.println("actionPerformed key presssed ");
        char keyChar = Character.toUpperCase(e.getKeyChar());
        String selectedState = selectState(keyChar);
        view.getControls().aplyState(selectedState);
    }

    public String selectState(char keyChar) {

        switch (keyChar) {
            case 'B':
                return "Bombeur";
            case 'L':
                return "Bloqueur";
            case 'M':
                return "Charpentier";
            case 'Y':
                return "Foureur";
            case 'G':
                return "Grimpeur";
            case 'P':
                return "Parachutist";
            case 'T':
                return "Tunnelier";
            case 'N':
                return "Normal";
            default:
                return "";
        }
    }
    @Override
    public void keyTyped(KeyEvent e) {
        System.out.println("actionPerformed key presssed ");
        char keyChar = Character.toUpperCase(e.getKeyChar());
        String selectedState = selectState(keyChar);
        view.getControls().aplyState(selectedState);
            }
    
    @Override
    public void keyReleased(KeyEvent e) {
        System.out.println("actionPerformed key presssed ");
        char keyChar = Character.toUpperCase(e.getKeyChar());
        String selectedState = selectState(keyChar);
        view.getControls().aplyState(selectedState);
           }
   
}
