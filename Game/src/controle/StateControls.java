package controle;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import poussin.Poussin;
import poussin.state.BloqueurState;
import poussin.state.BombeurState;
import poussin.state.CharpentierState;
import poussin.state.ForeurState;
import poussin.state.GrimpeurState;
import poussin.state.NormalState;
import poussin.state.PoussinState;
import view.View;

public class StateControls {
    private Poussin selectedPoussin;
    private View view;
    private static StateControls stateControls;
    public StateControls(View view){
        this.view =view;
        selectedPoussin = view.getSelectedPoussin();
        stateControls = this;
    }

    public void selectPoussin(Poussin poussin){
        this.selectedPoussin = poussin;
    }

    public static Action newAction(String state){
        System.out.println("actionnew ");

        return stateControls.new Action(state);
    }

    public void aplyState(String selectedState) {
        // view.aplyState(selectedState);
        if (selectedPoussin != null) {
            PoussinState state;
            switch (selectedState) {
                case "Bombeur":
                    state = new BombeurState(selectedPoussin);
                    selectedPoussin.setState(state);
                    break;
                case "Bloqueur":
                    state = new BloqueurState(selectedPoussin);
                    selectedPoussin.setState(state);
                    break;
                case "Charpentier":
                    state = new CharpentierState(selectedPoussin);
                    selectedPoussin.setState(state);
                    break;
                case "Foureur":
                    state = new ForeurState(selectedPoussin);
                    selectedPoussin.setState(state);
                    break;
                case "Grimpeur":
                    state = new GrimpeurState(selectedPoussin);
                    selectedPoussin.setState(state);
                    break;
                case "Tunnelier":
                    state = new GrimpeurState(selectedPoussin);
                    selectedPoussin.setState(state);
                    break;
                case "Normal":
                    state = new NormalState(selectedPoussin);
                    selectedPoussin.setState(state);
                    break;
            }
        }

    }

    public class Action implements ActionListener {
        private String state2;

        public Action(String state1) {
            state2 = state1;
        }

        @Override
        public void actionPerformed(ActionEvent e1) {
            aplyState(state2);
        }

    }
}
