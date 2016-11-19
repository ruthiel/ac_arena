package org.academiadecodigo.acarena.Lanterna;


import com.googlecode.lanterna.TextCharacter;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.screen.Screen;
import com.googlecode.lanterna.screen.TerminalScreen;
import com.googlecode.lanterna.terminal.DefaultTerminalFactory;
import com.googlecode.lanterna.terminal.Terminal;
import org.academiadecodigo.acarena.Field;
import org.academiadecodigo.acarena.GameObjects.GameObject;
import org.academiadecodigo.acarena.position.FieldPosition;
import java.io.IOException;

/**
 * Created by codecadet on 14/11/16.
 */
public class LanternaField implements Field {
    public Screen screen;
    private int cols;
    private int rows;
    private GameObject[][] gameObjects;

    public LanternaField(int rows, int cols) {
        this.rows = rows;
        this.cols = cols;
        gameObjects = new GameObject[cols][rows];

    }

//    private void populateFieldWithWalls() {
//
//                for (int i = 0; i < rows; i++) {
//                    for (int j = 0; j < cols; j++) {
//                if (i == 0) {
//                    gameObjects[j][i] = new Wall();
//                } else if (j == cols - 1) {
//                    gameObjects[j][i] = new Wall();
//                } else if (i == rows - 1) {
//                    gameObjects[j][i] = new Wall();
//                } else if (j == 0) {
//                    gameObjects[j][i] = new Wall();
//                }
//            }
//        }
//    }
//
//
//    private void populateFieldWithWeapons(){
//
//        int tempNum = (int) (Math.random() * 10);
//
//        for (int i = 1; i < rows ; i++) {
//            for (int j = 1; j < cols ; j++) {
//                if(tempNum < 2){
//                    gameObjects[j][i] = new Weapon();
//                }
//
//            }
//
//        }
//
//
//    }


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
        screen.getTerminalSize().withColumns(cols);
        screen.getTerminalSize().withRows(rows);
        screen.startScreen();


        // Create panel to hold components
       /* this.panel = new Panel();


        // Create panel to hold components
        panel.setLayoutManager(new GridLayout(cols).setHorizontalSpacing(0).setVerticalSpacing(0));


        // Create window to hold the panel
        BasicWindow window = new BasicWindow();
        window.setComponent(panel);

        for (int i = 0; i < 100; i++) {
            panel.addComponent(new EmptySpace(new TerminalSize(2,1)).withBorder(Borders.singleLine()));
        }*/


        // Create gui and start gui
        /* Thread thGui = new Thread() {
            public void run() {
                MultiWindowTextGUI gui = new MultiWindowTextGUI(screen, new DefaultWindowManager(), new EmptySpace(TextColor.ANSI.RED));
                // need to check this!!!
                gui.addWindowAndWait(window);

            }
        };

        thGui.start();*/




    }

    public Screen getScreen() {
        return screen;
    }


    public void show(FieldPosition pos) throws IOException {
        screen.setCharacter(pos.getCol(),pos.getRow(), new TextCharacter('w',TextColor.ANSI.BLUE,TextColor.ANSI.RED));
        screen.refresh();
    }

    public void hide(FieldPosition pos) throws IOException {
        screen.setCharacter(pos.getCol(), pos.getRow(), TextCharacter.DEFAULT_CHARACTER.withCharacter(' '));
        screen.refresh();

    }
}
