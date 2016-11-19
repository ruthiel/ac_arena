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

        while (true) {
            System.out.println("im here");
            keyStroke = lanternaField.getScreen().readInput();


            switch (keyStroke.getKeyType()) {
                case ArrowUp:
                    pos.hide();
                    pos.moveUp(1);
                    System.out.println(pos.toString());
                    pos.show();
                    System.out.println(((LanternaField) pos.getField()).getScreen().toString().getBytes());
                    break;

                case ArrowDown:
                    pos.hide();
                    pos.moveDown(1);
                    System.out.println(pos.toString());
                    System.out.println(((LanternaField) pos.getField()).getScreen().toString().getBytes());
                    pos.show();

                    break;
                case ArrowLeft:
                    pos.hide();
                    pos.moveLeft(1);
                    System.out.println(pos.toString());
                    System.out.println(((LanternaField) pos.getField()).getScreen().toString().getBytes());
                    pos.show();

                    break;
                case ArrowRight:
                    pos.hide();
                    pos.moveRight(1);
                    System.out.println(pos.toString());
                    System.out.println(((LanternaField) pos.getField()).getScreen().toString().getBytes());
                    pos.show();
                    break;
                default:
                    System.out.println("W8iting for Input motherfucker");
                    break;
            }
        }
    }

}

