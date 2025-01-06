package controle;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class keysBoard extends KeyAdapter {
    private StateControls controls;
    public keysBoard(StateControls controls){
        this.controls = controls;
    }

    @Override
    public void keyPressed(KeyEvent e) {
        System.out.println("actionPerformed key presssed ");
        char keyChar = Character.toUpperCase(e.getKeyChar());
        String selectedState = selectState(keyChar);
        controls.aplyState(selectedState);
    }

    public String selectState(char keyChar) {
        System.out.println("actionPerformed " + keyChar);

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
}
