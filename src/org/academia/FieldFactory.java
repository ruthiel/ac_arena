package org.academia;

import org.academia.GameObjects.GameObject;
import org.academia.GameObjects.Wall;

/**
 * Created by codecadet on 14/11/16.
 */
public class FieldFactory {

    private GameObject[][] gameObjects;
    private int rows;
    private int cols;

    public GameObject[] field() {
        rows = 40;
        cols = 60;

        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                if ( row == 0) {
                    gameObjects[row][col] = new Wall();
                } else if ( row == rows) {
                    gameObjects[row][col] = new Wall();
                }
            }

            }



    }


}
