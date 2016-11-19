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


    private FieldPosition position;

    public void getNewPlayers(Field field) {

        Player player1 = new Player(PlayerNumber.ONE);
        Player player2 = new Player(PlayerNumber.TWO);

    }


    public void getWalls(Field field) {

        for (int i = 0; i < field.getRows(); i++) {
            for (int j = 0; j < field.getRows(); j++) {
                if (i == 0) {

                }
            }
        }


    }


    private void populateFieldWithWalls(LanternaField lanternaField) {


//        try {
//            for (int i = 0; i < lanternaField.getRows(); i++) {
//                for (int j = 0; j < lanternaField.getCols(); j++) {
//                    if (i == 0) {
//
//                        gameObjects[j][i] = new Wall(new LanternaFieldPosition(i, j, lanternaField));
//
//                    } else if (j == cols - 1) {
//                        gameObjects[j][i] = new Wall(new LanternaFieldPosition(j, i, lanternaField));
//                    } else if (i == rows - 1) {
//                        gameObjects[j][i] = new Wall(new LanternaFieldPosition(j, i, lanternaField));
//                    } else if (j == 0) {
//                        gameObjects[j][i] = new Wall(new LanternaFieldPosition(j, i, lanternaField));
//                    }
//                }
//            }
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }


//    private void populateFieldWithWeapons() {
//
//        int tempNum = (int) (Math.random() * 10);
//
//        for (int i = 1; i < la; i++) {
//            for (int j = 1; j < cols; j++) {
//                if (tempNum < 2) {
//                    gameObjects[j][i] = new Weapon();
//                }
//
//            }
//
//        }
//    }
    }
}

