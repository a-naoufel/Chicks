package controle;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import view.View;

public class keysBoard extends KeyAdapter {
    private View view;
    public keysBoard(View view){
        this.view = view;
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
}
