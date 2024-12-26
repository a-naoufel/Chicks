package state;

import model.*;

import java.awt.Color;

public class BombeurState extends PoussinState {
        private int stups;

        public BombeurState(Poussin poussin){
                super(poussin);
                stups=3;
        }

        @Override
        public Color getColor() {
                return Color.RED;
        }

        @Override
        public void move() {

                if (stups > 0) {
                        super.move();
                        stups--;
                } else if (stups == 0) {
                        makeExplosion();
                        stups--;

                } else if (stups < 0) {

                        poussin.kill();
                }
        }

        private void makeExplosion() {
                Explosenext(-1, 0);
                Explosenext(1, 0);
                Explosenext(0, 1);
                Explosenext(0, -1);

                for (int i = -1; i < 2; i++)
                        for (int j = -1; j < 2; j++)
                                ExploseRelativeCell(i, j);
        }

        private void clearExplosions() {
                for (int i = -3; i < 3; i++)
                        for (int j = -3; j < 3; j++)
                                clearExplosion(i, j);
        }

        @Override
        public void exit() {
                clearExplosions();
        }
}
