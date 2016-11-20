package org.academiadecodigo.acarena.Lanterna;


import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.TextCharacter;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.gui2.*;
import com.googlecode.lanterna.screen.Screen;
import com.googlecode.lanterna.screen.TerminalScreen;
import com.googlecode.lanterna.screen.VirtualScreen;
import com.googlecode.lanterna.terminal.DefaultTerminalFactory;
import com.googlecode.lanterna.terminal.Terminal;
import org.academiadecodigo.acarena.Field;
import org.academiadecodigo.acarena.Game;
import org.academiadecodigo.acarena.GameObjects.GameObject;
import org.academiadecodigo.acarena.position.FieldPosition;
import java.io.IOException;

import static sun.plugin.javascript.navig.JSType.Window;

/**
 * Created by codecadet on 14/11/16.
 */
public class LanternaField implements Field {
    public Screen screen;
    private int cols;
    private int rows;
    private GameObject[][] gameObjects;
    private Panel panel;

    public LanternaField(Terminal terminal, int rows, int cols) {
        this.rows = rows;
        this.cols = cols;
        gameObjects = new GameObject[cols][rows];

    }

    public int getCols() {
        return cols;
    }

    public int getRows() {
        return rows;
    }

    @Override
    public FieldPosition makeFieldPosition() throws IOException { return new LanternaFieldPosition(this);}

    @Override
    public FieldPosition makeFieldPosition(int col, int row) throws IOException {return new LanternaFieldPosition(col ,row ,this);}


    public void init() throws IOException {

        Terminal terminal = new DefaultTerminalFactory().createTerminal();
        screen = new TerminalScreen(terminal);
        screen.startScreen();

}

    public Screen getScreen() {
        return screen;
    }


//    public void show(FieldPosition pos) throws IOException {
//        screen.setCharacter(pos.getCol(),pos.getRow(), new TextCharacter('w',TextColor.ANSI.BLUE,TextColor.ANSI.RED));
//        screen.refresh();
//    }

    public void show(GameObject object) throws IOException {
        screen.setCharacter(object.getPosition().getCol(), object.getPosition().getRow(), new TextCharacter(object.getChar()));
        screen.refresh();
    }


    public void hide(FieldPosition pos) throws IOException {
        screen.setCharacter(pos.getCol(), pos.getRow(), TextCharacter.DEFAULT_CHARACTER.withCharacter(' '));
        screen.refresh();

    }


}
