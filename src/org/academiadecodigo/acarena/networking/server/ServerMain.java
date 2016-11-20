package org.academiadecodigo.acarena.networking.server;

/**
 * Created by codecadet on 20/11/16.
 */
public class ServerMain {

    public static void main(String[] args) {


        Server2nd server = new Server2nd(5000);
        Thread thread = new Thread(server);
        thread.start();

    }
}

