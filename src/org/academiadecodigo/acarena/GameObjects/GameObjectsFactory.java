package org.academiadecodigo.acarena.GameObjects;

import com.googlecode.lanterna.gui2.EmptySpace;
import com.googlecode.lanterna.gui2.Label;
import org.academiadecodigo.acarena.GameObjects.Movable.Boss;
import org.academiadecodigo.acarena.GameObjects.Movable.EmptySlut;
import org.academiadecodigo.acarena.GameObjects.Movable.Player;
import org.academiadecodigo.acarena.Lanterna.LanternaField;
import org.academiadecodigo.acarena.Lanterna.LanternaFieldPosition;
import org.academiadecodigo.acarena.position.FieldPosition;
import test.PlayerTest;

import java.io.IOException;

/**
 * Created by codecadet on 18/11/16.
 */
public class GameObjectsFactory {


    private FieldPosition position;
    private GameObject[][] gameObjects;
    private Label[][] labels;
    private LanternaField lanternaField;

    private int cols;
    private int rows;
    private int middleCol = cols / 2;
    private int middleRow = rows / 2;
    private final int WEAPON_ABUNDANCY = 160; //the higher the number, lesser the weapons

    public GameObjectsFactory(LanternaField lanternaField) {
        this.lanternaField = lanternaField;
        cols = lanternaField.getCols();
        rows = lanternaField.getRows();
        labels = lanternaField.getLabels();
        gameObjects = lanternaField.getGameObjects();
    }


    // NOT RIGHT! Player is created with new Client!!!
    //    public void getNewPlayers(Field field) {
    //
    //        Player player1 = new Player(PlayerNumber.ONE);
    //        Player player2 = new Player(PlayerNumber.TWO);
    //
    //    }

    //This probably works but game logic is totally compromised with lanterna

    private void createPlayers() {


    }


    public void populateFieldWithWalls() {

        try {
            for (int i = 0; i < cols; i++) {
                for (int j = 0; j < rows; j++) {

                    //Creates walls around field

                    if (i == 0) {
                        gameObjects[i][j] = new Wall(new LanternaFieldPosition(i, j, lanternaField));
                        gameObjects[i][j].getPosition().create(gameObjects[i][j]);
                        labels[i][j] = new Label(gameObjects[i][j].getName()).setBackgroundColor(gameObjects[i][j].getColor());
                        System.out.println(i + "," + j );
                        continue;
                    } else if (j == 0) {
                        gameObjects[i][j] = new Wall(new LanternaFieldPosition(i, j, lanternaField));
                        gameObjects[i][j].getPosition().create(gameObjects[i][j]);
                        labels[i][j] = new Label(gameObjects[i][j].getName()).setBackgroundColor(gameObjects[i][j].getColor());
                        System.out.println(i + "," +j);
                        continue;
                    } else if (j == rows - 1) {
                        gameObjects[i][j] = new Wall(new LanternaFieldPosition(i, j, lanternaField));
                        gameObjects[i][j].getPosition().create(gameObjects[i][j]);
                        labels[i][j] = new Label(gameObjects[i][j].getName()).setBackgroundColor(gameObjects[i][j].getColor());
                        continue;
                    } else if (i == cols-1 ) {
                        gameObjects[i][j] = new Wall(new LanternaFieldPosition(i, j, lanternaField));
                        gameObjects[i][j].getPosition().create(gameObjects[i][j]);
                        labels[i][j] = new Label(gameObjects[i][j].getName()).setBackgroundColor(gameObjects[i][j].getColor());
                        continue;
                    }

                    gameObjects[i][j] = new EmptySlut(new LanternaFieldPosition(i, j, lanternaField));
                    gameObjects[i][j].getPosition().create(gameObjects[i][j]);
                    labels[i][j] = new Label(gameObjects[i][j].getName()).setBackgroundColor(gameObjects[i][j].getColor());


                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public void populateFieldWithFuckinWeapons() {

        int numberOfWeapons = (cols * rows) / WEAPON_ABUNDANCY;
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

//    private void createBoss(){
//
//        try{
//        gameObjects[middleRow+1][middleCol+1] = new Boss(new LanternaFieldPosition(middleCol+1, middleRow+1, lanternaField));
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//
//    }

    private void placeFlag() {

        try {
            gameObjects[middleRow][middleCol] = new Flag(new LanternaFieldPosition(middleCol, middleRow, lanternaField));
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void setLanternaField(LanternaField lanternaField) {
        this.lanternaField = lanternaField;
    }
}


