package test;

import com.googlecode.lanterna.input.*;
import org.academiadecodigo.acarena.Field;
import org.academiadecodigo.acarena.Position;

import java.io.IOException;

/**
 * Created by codecadet on 14/11/16.
 */
public class PlayerTest {

    private Position pos;
    private Field field;


    public PlayerTest(Field field) throws IOException {
        this.field = field;
        this.pos = new Position(0, 0, field);
        KeyStroke keyStroke = null;
        field.getTerminal().readInput();
       /* Panel panel = new Panel();
        panel.setLayoutManager(new GridLayout(10));

        Label hello = new Label("Hello");

        panel.addComponent(hello);
        panel.addComponent(new TextBox("Hello world"));



        BasicWindow window = new BasicWindow();
        window.setComponent(panel);


        MultiWindowTextGUI gui = new MultiWindowTextGUI(field.getScreen(), new DefaultWindowManager(), new EmptySpace(TextColor.ANSI.RED));
        gui.addWindow(window);*/


        while (true) {
            System.out.println("im here");
            keyStroke = field.getTerminal().readInput();

            switch (keyStroke.getKeyType()) {
                case ArrowUp:
                    pos.moveUp(1);
                    System.out.println("UP UP");
                    System.out.println(pos.toString());
                    break;
                case ArrowDown:
                    pos.moveDown(1);
                    System.out.println(pos.toString());
                    break;
                case ArrowLeft:
                    pos.moveLeft(1);
                    System.out.println(pos.toString());
                    break;
                case ArrowRight:
                    pos.moveRight(1);
                    System.out.println(pos.toString());
                    break;
                default:
                    System.out.println("W8iting for Input motherfucker");
                    break;
            }
        }
    }

    // testing shit bros!!!!
   // public static void main(String[] args) {

        /*terminal.setBackgroundColor(new TextColor.RGB(255,0,0));
        terminal.setForegroundColor(new TextColor.RGB(255,255,0));*/


      /*  Panel panel = new Panel();
        panel.setLayoutManager(new GridLayout(2));
        Label j = new Label("Eurico");
        System.out.println(j);
        panel.addComponent(j);
        panel.addComponent(new TextBox());
        panel.addComponent(new Button("Submit"));
        // Create window to hold the panel
        BasicWindow window = new BasicWindow();
        window.setComponent(panel);
        // Create gui and start gui
        MultiWindowTextGUI gui = new MultiWindowTextGUI(screen, new DefaultWindowManager(), new EmptySpace(TextColor.ANSI.RED));
        gui.addWindowAndWait(window);

        j.setPosition(new TerminalPosition(10, 10));*/
//    }

}

