package controle;

import java.awt.event.MouseAdapter;

import view.View;

public class MouseControls extends MouseAdapter {
    private View view;
    public MouseControls(View view){
        this.view= view;
    }
    @Override
    public void mouseClicked(java.awt.event.MouseEvent e) {
        int x = e.getX() * view.gridSizeX() / view.getWidth();
        int y = e.getY() * view.gridSizeY() / view.getHeight();
        view.selectPoussin(view.getPoussinClicked(x, y));
        view.update();
    }



}
