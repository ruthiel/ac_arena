package org.academiadecodigo.acarena;


import org.academiadecodigo.acarena.Lanterna.LanternaField;
import org.academiadecodigo.acarena.networking.server.Server;
import org.academiadecodigo.acarena.networking.server.Server2nd;
import test.PlayerTest;

import java.io.IOException;

/**
 * Created by codecadet on 14/11/16.
 */
public class Main {
    public static void main(String[] args) throws IOException {

//        LanternaField lanternaField = new LanternaField(10,10);
//        lanternaField.init();
//        PlayerTest playerTest = new PlayerTest(lanternaField);
        Server server = new Server();
        Thread thread = new Thread(server);
        thread.start();

        Game game = new Game(Server.getMap());


    }
}
