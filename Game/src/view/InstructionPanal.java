package view;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import poussin.States;

public class InstructionPanal extends JPanel {
    public InstructionPanal() {
        setLayout(new FlowLayout(FlowLayout.CENTER)); // Align components to the left
        setPreferredSize(new Dimension(900, 100)); // Explicit dimensions
        JLabel statesLabel = new JLabel("States: ");
        add(statesLabel);
        addStates();
    }






    public void addStates(){
        String[] states = States.states;
        String[] icons = States.icons;
        String[] keys = States.keys;
        for ( int i = 0; i < states.length; i++) {
            // Load and resize the icon
            buildButton(icons[i], states[i], keys[i]);
        }
    }
    private void buildButton(String iconPath,String state,String key){
        StateButton button = new StateButton(state, key);
        button.setIcon(prepareIcon(iconPath));
        add(button);
    }
    private ImageIcon prepareIcon(String iconPath){
        // Load and resize the icon
        ImageIcon icon = new ImageIcon(States.path + iconPath);
        Image img = icon.getImage();
        Image scaledImg = img.getScaledInstance(30, 30, Image.SCALE_SMOOTH);
        return new ImageIcon(scaledImg);
    }
}
