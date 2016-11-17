package org.academiadecodigo.acarena;

import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.gui2.*;
import com.googlecode.lanterna.screen.Screen;
import com.googlecode.lanterna.screen.TerminalScreen;
import com.googlecode.lanterna.terminal.DefaultTerminalFactory;
import com.googlecode.lanterna.terminal.Terminal;
import org.academiadecodigo.acarena.Lanterna.LanternaField;
import test.PlayerTest;

import java.io.IOException;

/**
 * Created by codecadet on 14/11/16.
 */
public class Main {
    public static void main(String[] args) throws IOException {
        LanternaField lanternaField = new LanternaField(10,10);

        // Setup terminal and screen layers
        Terminal terminal = new DefaultTerminalFactory().createTerminal();
        Screen screen = new TerminalScreen(terminal);
        screen.startScreen();

        // Create panel to hold components
        Panel panel = new Panel();


        // Create panel to hold components
        panel.setLayoutManager(new GridLayout(10));


        // Create window to hold the panel
        BasicWindow window = new BasicWindow();
        window.setComponent(panel);

        // Create gui and start gui
        MultiWindowTextGUI gui = new MultiWindowTextGUI(screen, new DefaultWindowManager(), new EmptySpace(TextColor.ANSI.BLUE));
        gui.addWindowAndWait(window);



        PlayerTest player = new PlayerTest(lanternaField,screen);


    }
}
