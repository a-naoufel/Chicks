package controle;

import poussin.Poussin;
import poussin.state.BloqueurState;
import poussin.state.BombeurState;
import poussin.state.CharpentierState;
import poussin.state.ForeurState;
import poussin.state.GrimpeurState;
import poussin.state.NormalState;
import poussin.state.ParachutistState;
import poussin.state.PoussinState;
import poussin.state.TunnelierState;
import view.View;

public class StateControls {
    private View view;
    public keysBoard keysBoard;

    public void setView(View view) {
        this.view = view;
        view.addKeyListener(new keysBoard(view));
        view.addMouseListener(new MouseControls(view));
        
    }

    public void aplyState(String selectedState) {

        Poussin selectedPoussin = view.getSelectedPoussin();
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
                case "Parachutist":
                    state = new ParachutistState(selectedPoussin);
                    selectedPoussin.setState(state);
                    break;
                case "Tunnelier":
                    state = new TunnelierState(selectedPoussin);
                    selectedPoussin.setState(state);
                    break;
                case "Normal":
                    state = new NormalState(selectedPoussin);
                    selectedPoussin.setState(state);
                    break;
            }
        }

    }

}
