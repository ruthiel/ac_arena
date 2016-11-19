package org.academiadecodigo.acarena.GameObjects;

import org.academiadecodigo.acarena.GameObjects.Movable.Boss;
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
    private GameObject[][] gameObjects;
    private LanternaField lanternaField;

    private int cols = lanternaField.getCols();
    private int rows = lanternaField.getRows();
    private int middleCol = cols/2;
    private int middleRow = rows/2;
    private final int WEAPON_ABUNDANCY = 160; //the higher the number, lesser the weapons

    // NOT RIGHT! Player is created with new Client!!!
    //    public void getNewPlayers(Field field) {
    //
    //        Player player1 = new Player(PlayerNumber.ONE);
    //        Player player2 = new Player(PlayerNumber.TWO);
    //
    //    }

    //This probably works but game logic is totally compromised with lanterna

    private void populateFieldWithWalls() {

        try {
            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < cols; j++) {
                    if (i == 0) {
                        gameObjects[j][i] = new Wall(new LanternaFieldPosition(i, j, lanternaField));
                    } else if (j == cols - 1) {
                        gameObjects[j][i] = new Wall(new LanternaFieldPosition(j, i, lanternaField));
                    } else if (i == rows - 1) {
                        gameObjects[j][i] = new Wall(new LanternaFieldPosition(j, i, lanternaField));
                    } else if (j == 0) {
                        gameObjects[j][i] = new Wall(new LanternaFieldPosition(j, i, lanternaField));
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    private void populateFieldWithFuckinWeapons() {

        int numberOfWeapons = (cols*rows) / WEAPON_ABUNDANCY;
        int prob;

        try {
            for (int i = 1; i < rows - 1; i++) {
                for (int j = 1; j < cols - 1; j++) {

                    prob = (int) (Math.random() * 10);

                    if (prob > 5 && numberOfWeapons > 0) {
                        gameObjects[j][i] = new Weapon(new LanternaFieldPosition(i, j, lanternaField), WeaponType.BOW);
                        numberOfWeapons--;
                    } else if (prob > 2 && numberOfWeapons > 0) {
                        gameObjects[j][i] = new Weapon(new LanternaFieldPosition(i, j, lanternaField), WeaponType.AXE);
                        numberOfWeapons--;
                    } else if (prob > 0 && numberOfWeapons > 0) {
                        gameObjects[j][i] = new Weapon(new LanternaFieldPosition(i, j, lanternaField), WeaponType.AXE);
                        numberOfWeapons--;
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void createBoss(){

        try{
        gameObjects[middleRow+1][middleCol+1] = new Boss(new LanternaFieldPosition(middleCol+1, middleRow+1, lanternaField));
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private void placeFlag(){

        try {
            gameObjects[middleRow][middleCol] = new Flag(new LanternaFieldPosition(middleCol, middleRow, lanternaField));
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}


