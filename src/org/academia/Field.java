package org.academia;


import com.googlecode.lanterna.screen.Screen;
import com.googlecode.lanterna.screen.TerminalScreen;
import com.googlecode.lanterna.terminal.DefaultTerminalFactory;
import com.googlecode.lanterna.terminal.Terminal;

import java.io.IOException;

/**
 * Created by codecadet on 14/11/16.
 */
public class Field {
    public Screen screen;
    private int cols;
    private int rows;
    private Terminal terminal;

    public Field(int rows, int cols) {
        this.rows = rows;
        this.cols = cols;
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
        screen.getTerminalSize().withColumns(rows);

        // display the grid
        screen.startScreen();
    }

    public Screen getScreen() {
        return screen;
    }
}
