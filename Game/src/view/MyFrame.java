package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import controle.keysBoard;

public class MyFrame extends JFrame{
    private int pixelSize = 31;
    private int ofSet = 100;
    private int ofSetY = 35;

    public MyFrame(View view){
        super("Penguins");
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        addKeyListener(new keysBoard(view));
    }
    public void reSize(int x,int y){
        setSize(new Dimension(pixelSize * x, pixelSize * y + ofSetY + ofSet));
    }
    public void showEndPanel(String result) {
                getContentPane().removeAll();

                JPanel endPanel = new JPanel();
                endPanel.setLayout(new GridBagLayout());
                endPanel.setBackground(Color.GRAY);

                JLabel endLabel = new JLabel("La partie est terminée !\n result: " + result);
                endLabel.setFont(new Font("SansSerif", Font.BOLD, 24));
                endLabel.setForeground(Color.WHITE);
                endPanel.add(endLabel);

                add(endPanel, BorderLayout.CENTER);

                revalidate();
                repaint();
        }
 
    
   
}
