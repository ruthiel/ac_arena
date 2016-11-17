package org.academiadecodigo.acarena;

import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.gui2.*;
import com.googlecode.lanterna.screen.Screen;
import com.googlecode.lanterna.screen.TerminalScreen;
import com.googlecode.lanterna.terminal.DefaultTerminalFactory;
import com.googlecode.lanterna.terminal.Terminal;
import org.academiadecodigo.acarena.GameObjects.Movable.Player;
import test.PlayerTest;

import java.io.IOException;
import java.util.Collection;
import java.util.List;

/**
 * Created by codecadet on 14/11/16.
 */
public class Main {
    public static void main(String[] args) throws IOException {
        Field field = new Field(10,10);
        field.init();


        // Setup terminal and screen layers
        Terminal terminal = new DefaultTerminalFactory().createTerminal();
        Screen screen = new TerminalScreen(terminal);
        screen.startScreen();

        // Create panel to hold components
        Panel panel = new Panel();
        PlayerTest player = new PlayerTest(field,screen);

//        panel.setLayoutManager(new GridLayout(10));
//        panel.withBorder(Borders.doubleLine());


//        panel.addComponent(new Label("Hunger"));
//        panel.addComponent(new TextBox());
//
//        panel.addComponent(new Label("Games"));
//        panel.addComponent(new TextBox());
//
//        panel.addComponent(new EmptySpace(new TerminalSize(0,0))); // Empty space underneath labels
//        panel.addComponent(new Button("Play"));

        // Create window to hold the panel
        BasicWindow window = new BasicWindow();
        window.setComponent(panel);




        for (int i = 0; i < 100; i++) {
            panel.addComponent(new EmptySpace(new TerminalSize(0,0)).withBorder(Borders.singleLine()));

        }


        // Create gui and start gui
        MultiWindowTextGUI gui = new MultiWindowTextGUI(screen, new DefaultWindowManager(), new EmptySpace(TextColor.ANSI.RED));

        panel.addComponent(((Component)player).withBorder(Borders.doubleLine()));
        ((Component) player).setPosition(new TerminalPosition(4,9));

    }
}
