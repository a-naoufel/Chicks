package view;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import controle.StateControls;
import controle.keysBoard;
import poussin.States;

public class InstructionPanal extends JPanel {
    private StateControls controls ;
    private View view;
    public InstructionPanal(View view) {
        this.view = view;
        this.controls = view.getControls();
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
            add(buildButton(icons[i], states[i], keys[i]));
        }
    }
    private StateButton buildButton(String iconPath,String state,String key){
        StateButton button = new StateButton(state, key,controls);
        button.setIcon(prepareIcon(iconPath));
        button.addKeyListener(new keysBoard(view));

        return button;
    }
    private ImageIcon prepareIcon(String iconPath){
        // Load and resize the icon
        ImageIcon icon = new ImageIcon(States.path + iconPath);
        Image img = icon.getImage();
        Image scaledImg = img.getScaledInstance(30, 30, Image.SCALE_SMOOTH);
        return new ImageIcon(scaledImg);
    }
}
