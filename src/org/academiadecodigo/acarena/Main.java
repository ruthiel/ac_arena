package org.academiadecodigo.acarena;


import org.academiadecodigo.acarena.networking.server.Server;

import java.io.IOException;

/**
 * Created by codecadet on 14/11/16.
 */
public class Main {
    public static void main(String[] args) throws IOException {

//        LanternaField lanternaField = new LanternaField(10,10);
//        lanternaField.init();
//        Player playerTest = new Player(lanternaField);
        Server server = new Server();
        Thread thread = new Thread(server);
        thread.start();

    }
}
