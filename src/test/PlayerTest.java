package test;

import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TextCharacter;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.gui2.Panel;
import com.googlecode.lanterna.input.*;
import com.googlecode.lanterna.screen.Screen;
import org.academiadecodigo.acarena.Lanterna.LanternaField;
import org.academiadecodigo.acarena.Lanterna.LanternaFieldPosition;
import org.academiadecodigo.acarena.position.AbstractFieldPosition;

import java.awt.*;
import java.io.IOException;

/**
 * Created by codecadet on 14/11/16.
 */
public class PlayerTest {

    private AbstractFieldPosition pos;






    public PlayerTest(LanternaField lanternaField) throws IOException {

        this.pos = new LanternaFieldPosition(0, 0, lanternaField);
        pos.show();
        KeyStroke keyStroke = null;
       /* Panel panel = new Panel();
        panel.setLayoutManager(new GridLayout(10));

        Label hello = new Label("Hello");

        panel.addComponent(hello);
        panel.addComponent(new TextBox("Hello world"));



        BasicWindow window = new BasicWindow();
        window.setComponent(panel);


        MultiWindowTextGUI gui = new MultiWindowTextGUI(lanternaField.getScreen(), new DefaultWindowManager(), new EmptySpace(TextColor.ANSI.RED));
        gui.addWindow(window);*/


        while (true) {
            System.out.println("im here");
            keyStroke = lanternaField.getScreen().readInput();



            switch (keyStroke.getKeyType()) {
                case ArrowUp:
                    pos.hide();
                    pos.moveUp(1);
                    System.out.println(pos.toString());
                    pos.show();
                    break;

                case ArrowDown:
                    pos.hide();
                    pos.moveDown(1);
                    System.out.println(pos.toString());
                    pos.show();

                    break;
                case ArrowLeft:
                    pos.hide();
                    pos.moveLeft(1);
                    System.out.println(pos.toString());
                    pos.show();

                    break;
                case ArrowRight:
                    pos.hide();
                    pos.moveRight(1);
                    System.out.println(pos.toString());
                    pos.show();
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

