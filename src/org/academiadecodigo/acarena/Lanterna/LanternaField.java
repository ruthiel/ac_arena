package org.academiadecodigo.acarena.Lanterna;


import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.TextCharacter;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.gui2.*;
import com.googlecode.lanterna.gui2.table.TableHeaderRenderer;
import com.googlecode.lanterna.screen.Screen;
import com.googlecode.lanterna.screen.TerminalScreen;
import com.googlecode.lanterna.terminal.DefaultTerminalFactory;
import com.googlecode.lanterna.terminal.Terminal;
import org.academiadecodigo.acarena.Field;
import org.academiadecodigo.acarena.Game;
import org.academiadecodigo.acarena.GameObjects.GameObject;
import org.academiadecodigo.acarena.GameObjects.GameObjectsFactory;
import org.academiadecodigo.acarena.position.FieldPosition;
import test.PlayerTest;

import java.io.IOException;
import java.util.Arrays;

/**
 * Created by codecadet on 14/11/16.
 */
public class LanternaField implements Field, Runnable {
    public Screen screen;
    private int cols;
    private int rows;
    private GameObject[][] gameObjects;
    private Panel panel;
    private Terminal terminal;
    private MultiWindowTextGUI gui;
    private PlayerTest player;

    public LanternaField(int rows, int cols) throws IOException {
        this.rows = rows;
        this.cols = cols;
        gameObjects = new GameObject[cols][rows];
        this.panel = new Panel();
        terminal = new DefaultTerminalFactory().createTerminal();
        screen = new TerminalScreen(terminal);
        screen.startScreen();
        GameObjectsFactory factory = new GameObjectsFactory(this);
        factory.populateFieldWithWalls();
        factory.populateFieldWithFuckinWeapons();
        player = factory.getPlayertest();


    }

    public PlayerTest getPlayer() {
        return player;
    }

    public Panel getPanel() {
        return panel;
    }

    @Override
    public void init() throws IOException {

    }

    public int getCols() {
        return cols;
    }

    public int getRows() {
        return rows;
    }

    @Override
    public FieldPosition makeFieldPosition() throws IOException {
        return new LanternaFieldPosition(this);
    }

    @Override
    public FieldPosition makeFieldPosition(int col, int row) throws IOException {
        return new LanternaFieldPosition(col, row, this);
    }


    public Screen getScreen() {
        return screen;
    }


    public void show(GameObject object) throws IOException {
        screen.setCharacter(object.getPosition().getCol(), object.getPosition().getRow(), new TextCharacter(object.getChar()));
        screen.refresh();
    }


    public void hide(FieldPosition pos) throws IOException {
        screen.setCharacter(pos.getCol(), pos.getRow(), TextCharacter.DEFAULT_CHARACTER.withCharacter(' '));
        screen.refresh();

    }

    @Override
    public void run() {



            panel.setLayoutManager(new GridLayout(cols).setHorizontalSpacing(0));
            panel.setPreferredSize(new TerminalSize(100, 100));


            // Create window to hold the panel
            BasicWindow window = new BasicWindow();
            window.setComponent(panel);


            // Create gui and start gui
            gui = new MultiWindowTextGUI(screen, new DefaultWindowManager(), new EmptySpace(TextColor.ANSI.BLUE));

            gui.addWindowAndWait(window);


        }

    public MultiWindowTextGUI getGui() {
        return gui;
    }
}
