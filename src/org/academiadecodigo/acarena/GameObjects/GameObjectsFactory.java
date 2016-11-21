package org.academiadecodigo.acarena.GameObjects;

import com.googlecode.lanterna.gui2.Label;
import org.academiadecodigo.acarena.CollisionDetector;
import org.academiadecodigo.acarena.GameObjects.Movable.EmptySlut;
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
    private Label[][] labels;
    private LanternaField lanternaField;

    private int cols;
    private int rows;
    private int middleCol = cols / 2;
    private int middleRow = rows / 2;
    private final int WEAPON_ABUNDANCY = 100; //the higher the number, lesser the weapons

    public GameObjectsFactory(LanternaField lanternaField) {
        this.lanternaField = lanternaField;
        cols = lanternaField.getCols();
        rows = lanternaField.getRows();
        labels = lanternaField.getLabels();
        gameObjects = lanternaField.getGameObjects();
        CollisionDetector.setObjects(gameObjects);
    }

    //This probably works but game logic is totally compromised with lanterna

    public void populateFieldWithWalls() {

        try {
            for (int i = 0; i < cols; i++) {
                for (int j = 0; j < rows; j++) {

                    //Creates walls around field

                    if (i == 0) {
                        gameObjects[i][j] = new Wall(new LanternaFieldPosition(i, j, lanternaField));
                        labels[i][j] = new Label(gameObjects[i][j].getName()).setBackgroundColor(gameObjects[i][j].getColor());
                        System.out.println(i + "," + j);
                        continue;
                    } else if (j == 0) {
                        gameObjects[i][j] = new Wall(new LanternaFieldPosition(i, j, lanternaField));
                        labels[i][j] = new Label(gameObjects[i][j].getName()).setBackgroundColor(gameObjects[i][j].getColor());
                        System.out.println(i + "," + j);
                        continue;
                    } else if (j == rows - 1) {
                        gameObjects[i][j] = new Wall(new LanternaFieldPosition(i, j, lanternaField));
                        labels[i][j] = new Label(gameObjects[i][j].getName()).setBackgroundColor(gameObjects[i][j].getColor());
                        continue;
                    } else if (i == cols - 1) {
                        gameObjects[i][j] = new Wall(new LanternaFieldPosition(i, j, lanternaField));
                        labels[i][j] = new Label(gameObjects[i][j].getName()).setBackgroundColor(gameObjects[i][j].getColor());
                        continue;
                    }

                    gameObjects[i][j] = new EmptySlut(new LanternaFieldPosition(i, j, lanternaField));
                    labels[i][j] = new Label(gameObjects[i][j].getName()).setBackgroundColor(gameObjects[i][j].getColor());


                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public void populateFieldWithFuckinWeapons() {

        int numberOfWeapons = (cols * rows) / WEAPON_ABUNDANCY;
        double prob;

        try {
            for (int i = 1; i < cols - 1; i++) {
                for (int j = 1; j < rows - 1; j++) {

                    prob = (Math.random() * 130);

                    if (prob > 0.08 && prob < 0.09 && numberOfWeapons > 0) {
                        gameObjects[i][j] = new Weapon(new LanternaFieldPosition(i, j, lanternaField), WeaponType.FLAMETRHOWER);
                        labels[i][j] = new Label(gameObjects[i][j].getName()).setBackgroundColor(gameObjects[i][j].getColor());
                        numberOfWeapons--;
                        System.out.println("FLAMETRHOWER in:" + i + "," + j);
                    } else if (prob > 0.5 && prob < 0.8 && numberOfWeapons > 0) {
                        gameObjects[i][j] = new Weapon(new LanternaFieldPosition(i, j, lanternaField), WeaponType.AXE);
                        labels[i][j] = new Label(gameObjects[i][j].getName()).setBackgroundColor(gameObjects[i][j].getColor());
                        numberOfWeapons--;
                        System.out.println("AXE in:" + i + "," + j);
                    } else if (prob > 0 && prob < 0.5 && numberOfWeapons > 0) {
                        gameObjects[i][j] = new Weapon(new LanternaFieldPosition(i, j, lanternaField), WeaponType.BOW);
                        labels[i][j] = new Label(gameObjects[i][j].getName()).setBackgroundColor(gameObjects[i][j].getColor());
                        numberOfWeapons--;
                        System.out.println("BOW in:" + i + "," + j);
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


