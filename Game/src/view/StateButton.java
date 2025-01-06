package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;

import controle.StateControls;

public class StateButton extends JButton{
    public StateButton(String state,String key,StateControls controls){
        super(state + " (Press " + key + ")");
        setHorizontalTextPosition(JLabel.RIGHT);
        setVerticalTextPosition(JLabel.CENTER);
        addActionListener(new Action(state,controls));
        
    }
    
}
class Action implements ActionListener {
    private String state2;
    private StateControls controls;

    public Action(String state1,StateControls controls) {
        state2 = state1;
        this.controls = controls;

    }

    @Override
    public void actionPerformed(ActionEvent e1) {
        controls. aplyState(state2);
    }

}