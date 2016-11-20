package org.academiadecodigo.acarena.networking.server;

/**
 * Created by codecadet on 20/11/16.
 */
public class ServerMain {

    public static void main(String[] args) {


        Server server = new Server();
        Thread thread = new Thread(server);
        thread.start();

    }
}

