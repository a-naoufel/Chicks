package view;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JFrame;

public class MyFrame extends JFrame{
    private int pixelSize = 31;
    private int ofSet = 100;
    private int ofSetY = 35;


    public MyFrame(String name){
        super(name);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
    }
    public void reSize(int x,int y){
        setSize(new Dimension(pixelSize * x, pixelSize * y + ofSetY + ofSet));
    }
    @Override
    public int getHeight() {
        return super.getHeight();
    }
   
}
