package org.academiadecodigo.acarena.GameObjects;

import org.academiadecodigo.acarena.Field;
import org.academiadecodigo.acarena.GameObjects.Movable.Player;
import org.academiadecodigo.acarena.Lanterna.LanternaField;
import org.academiadecodigo.acarena.Lanterna.LanternaFieldPosition;
import org.academiadecodigo.acarena.position.FieldPosition;

import java.io.IOException;

/**
 * Created by codecadet on 18/11/16.
 */
public class GameObjectsFactory {

<<<<<<< HEAD
    private FieldPosition position;

    public void getNewPlayers(Field field) {

        Player player1 = new Player(PlayerNumber.ONE);
        Player player2 = new Player(PlayerNumber.TWO);

    }




    public void getWalls(Field field) {

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (i == 0) {

                }
            }
        }


    }


    private void populateFieldWithWalls(LanternaField lanternaField) {




        try {
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (i == 0) {

                        gameObjects[j][i] = new Wall(new LanternaFieldPosition(i,j, lanternaField));

                } else if (j == cols - 1) {
                    gameObjects[j][i] = new Wall();
                } else if (i == rows - 1) {
                    gameObjects[j][i] = new Wall();
                } else if (j == 0) {
                    gameObjects[j][i] = new Wall();
                }
            }
        }
    } catch (IOException e) {
        e.printStackTrace();
    }


    private void populateFieldWithWeapons() {

        int tempNum = (int) (Math.random() * 10);

        for (int i = 1; i < rows; i++) {
            for (int j = 1; j < cols; j++) {
                if (tempNum < 2) {
                    gameObjects[j][i] = new Weapon();
                }

            }

        }
    }
=======
>>>>>>> 6e5c90839022dc793c26f45bb87e513b997d55c5
}

