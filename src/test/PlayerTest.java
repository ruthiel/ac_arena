package test;

import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.TextCharacter;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.gui2.*;
import com.googlecode.lanterna.gui2.Label;
import com.googlecode.lanterna.gui2.Panel;
import com.googlecode.lanterna.input.*;
import com.googlecode.lanterna.screen.AbstractScreen;
import com.googlecode.lanterna.screen.Screen;
import org.academiadecodigo.acarena.GameObjects.GameObject;
import org.academiadecodigo.acarena.Lanterna.LanternaField;
import org.academiadecodigo.acarena.Lanterna.LanternaFieldPosition;
import org.academiadecodigo.acarena.position.AbstractFieldPosition;
import org.academiadecodigo.acarena.position.FieldPosition;

import java.awt.*;
import java.io.IOException;

/**
 * Created by codecadet on 14/11/16.
 */
public class PlayerTest extends GameObject {
    AbstractFieldPosition pos;
    LanternaField lanternaField;
    Label label;


    public PlayerTest(LanternaFieldPosition position, LanternaField lanternaField) throws IOException {
        super(position);
        this.pos = position;
        this.lanternaField = lanternaField;

        setColor(TextColor.ANSI.BLUE);
        setName("  ");
    }

    public void repaint() throws IOException {
        lanternaField.repaint(getPosition());
    }

    //    public void run() throws IOException {
//        KeyStroke keyStroke = null;
//        while (true) {
//            System.out.println("im here");
//            keyStroke = lanternaField.getScreen().readInput();
    public void playerMove(KeyStroke keyStroke) throws IOException {

        switch (keyStroke.getKeyType()) {
            case ArrowUp:
                pos.moveUp(1);
                label.setPosition(new TerminalPosition((pos.getCol()), pos.getRow()));
                lanternaField.getGui().updateScreen();
                System.out.println(pos.toString());
                break;

            case ArrowDown:
                pos.moveDown(1);
                label.setPosition(new TerminalPosition((pos.getCol()), pos.getRow()));
                lanternaField.getGui().updateScreen();
                System.out.println(pos.toString());
                // pos.show();

                break;
            case ArrowLeft:
                System.out.println("player test " + Thread.currentThread().getName());
                pos.moveLeft(1);
                label.setPosition(new TerminalPosition((pos.getCol()), pos.getRow()));
                lanternaField.getGui().updateScreen();
                System.out.println(pos.toString());
                // pos.show();

                break;
            case ArrowRight:
                pos.moveRight(1);
                label.setPosition(new TerminalPosition((pos.getCol()), pos.getRow()));
                lanternaField.getGui().updateScreen();
                System.out.println(pos.toString());
                System.out.println(((LanternaField) pos.getField()).getScreen().toString().getBytes());
                // pos.show();
                break;
            default:
                System.out.println("W8iting for Input motherfucker");
                break;
        }
    }


}



