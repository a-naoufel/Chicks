package view;

import javax.swing.JButton;
import javax.swing.JLabel;

import controle.StateControls;

public class StateButton extends JButton{
    public StateButton(String state,String key){
        super(state + " (Press " + key + ")");
        setHorizontalTextPosition(JLabel.RIGHT);
        setVerticalTextPosition(JLabel.CENTER);
        addActionListener(StateControls.newAction(state));
    }
}

