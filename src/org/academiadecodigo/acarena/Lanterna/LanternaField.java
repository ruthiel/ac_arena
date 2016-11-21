package org.academiadecodigo.acarena.Lanterna;


import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.TextCharacter;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.gui2.*;
import com.googlecode.lanterna.screen.Screen;
import com.googlecode.lanterna.screen.TerminalScreen;
import com.googlecode.lanterna.terminal.DefaultTerminalFactory;
import com.googlecode.lanterna.terminal.Terminal;
import org.academiadecodigo.acarena.Field;
import org.academiadecodigo.acarena.GameObjects.GameObject;
import org.academiadecodigo.acarena.GameObjects.GameObjectsFactory;
import org.academiadecodigo.acarena.position.FieldPosition;
import org.academiadecodigo.acarena.GameObjects.Movable.Player;

import java.io.IOException;

/**
 * Created by codecadet on 14/11/16.
 */
public class LanternaField implements Field, Runnable {
    public Screen screen;
    private int cols;
    private int rows;
    private Terminal terminal;
    private GameObject[][] gameObjects;
    private Label[][] labels;
    private MultiWindowTextGUI gui;
    private Panel panel;
    private Player player;

    public LanternaField(int rows, int cols) throws IOException {
        this.rows = rows;
        this.cols = cols;
        this.labels = new Label[cols][rows];
        this.panel = new Panel();
        gameObjects = new GameObject[cols][rows];
        terminal = new DefaultTerminalFactory().createTerminal();
        screen = new TerminalScreen(terminal);
        screen.startScreen();

        GameObjectsFactory factory = new GameObjectsFactory(this);
        factory.populateFieldWithWalls();
        factory.populateFieldWithFuckinWeapons();



    }

    public GameObject[][] getGameObjects() {
        return gameObjects;
    }

    public Label[][] getLabels() {
        return labels;
    }

    public Player getPlayer() {
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

    public void repaint(FieldPosition position) throws IOException {

        position = new LanternaFieldPosition((position.getCol() * 2) + 1, position.getRow(), this);
        for (int i = 1; i < cols -1; i++) {
            for (int j = 1; j < rows -1; j++) {
                if (labels[j][i].getPosition().getColumn() == position.getCol()
                        && labels[j][i].getPosition().getRow() == position.getRow()) {

                    labels[j][i].setText(" ");
                    labels[j][i].setBackgroundColor(TextColor.ANSI.RED);
                    getScreen().refresh();
                    getGui().updateScreen();
                }
            }
        }
    }

    public void removepaint(FieldPosition position) throws IOException {

        position = new LanternaFieldPosition((position.getCol() * 2) + 1, position.getRow(), this);
        for (int i = 1; i < cols -1; i++) {
            for (int j = 1; j < rows -1; j++) {
                if (labels[j][i].getPosition().getColumn() == position.getCol()
                        && labels[j][i].getPosition().getRow() == position.getRow()) {

                    labels[j][i].setText(" ");
                    labels[j][i].setBackgroundColor(TextColor.ANSI.WHITE);
                    getScreen().refresh();
                    getGui().updateScreen();
                }
            }
        }
    }

    @Override
    public void run() {
        panel.setLayoutManager(new GridLayout(cols).setHorizontalSpacing(0));
        panel.setPreferredSize(new TerminalSize(100, 50));

        for (int i = 0; i < cols; i++) {
            for (int j = 0; j < rows; j++) {
                panel.addComponent(labels[j][i]);

            }

        }

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
