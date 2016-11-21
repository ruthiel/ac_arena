package org.academiadecodigo.acarena.networking.client;

import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.gui2.*;
import com.googlecode.lanterna.screen.Screen;

/**
 * Created by codecadet on 20/11/16.
 */
public class Visor implements Runnable {

    Screen screen;
    MultiWindowTextGUI gui;
    BasicWindow window;
    Component panel = new Panel();


    public Visor(Screen screen) {
        this.screen = screen;
        window = new BasicWindow();
        window.setComponent(panel);
        gui = new MultiWindowTextGUI(screen, new DefaultWindowManager(), new EmptySpace(TextColor.ANSI.BLUE));
        gui.addWindowAndWait(window);
    }

    @Override
    public void run() {

    }

    public void setGui(MultiWindowTextGUI gui) {
        this.gui = gui;
    }

}

