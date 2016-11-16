package org.academiadecodigo.acarena;


import com.googlecode.lanterna.screen.Screen;
import com.googlecode.lanterna.screen.TerminalScreen;
import com.googlecode.lanterna.terminal.DefaultTerminalFactory;
import com.googlecode.lanterna.terminal.Terminal;
import org.academiadecodigo.acarena.GameObjects.GameObject;
import org.academiadecodigo.acarena.GameObjects.Wall;

import java.io.IOException;

/**
 * Created by codecadet on 14/11/16.
 */
public class Field {
    public Screen screen;
    private int cols;
    private int rows;
    private Terminal terminal;
    private GameObject[][] gameObjects;


    public Field(int rows, int cols) {
        this.rows = rows;
        this.cols = cols;
        gameObjects = new GameObject[cols][rows];
        populateFieldWithWalls();

    }

    private void populateFieldWithWalls() {

//        int col = 0;
//        int row = 0;


        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (i == 0) {
                    gameObjects[j][i] = new Wall();
                } else if (j == cols-1) {
                    gameObjects[j][i] = new Wall();
                } else if (i == rows-1) {
                    gameObjects[j][i] = new Wall();
                } else if (j == 0) {
                    gameObjects[j][i] = new Wall();
                }
            }
        }
    }

    public void toStrange() {
        for (int i = 0; i < cols; i++) {
            for (int j = 0; j < rows; j++) {
                if (gameObjects[i][j] instanceof Wall) {
                    System.out.println(gameObjects[i][j]);
                }
            }

        }
    }





    public int getCols() {
        return cols;
    }

    public int getRows() {
        return rows;
    }

    public Terminal getTerminal() {
        return terminal;
    }

    public void init() throws IOException {

        terminal = new DefaultTerminalFactory().createTerminal();


        // create the GUI
        screen = new TerminalScreen(terminal);


        // set the grid size
        //terminal.setCursorVisible(false); // Not Working
        screen.getTerminalSize().withColumns(cols);
        screen.getTerminalSize().withRows(rows);

        // display the grid
        screen.startScreen();
    }

    public Screen getScreen() {
        return screen;
    }


}
