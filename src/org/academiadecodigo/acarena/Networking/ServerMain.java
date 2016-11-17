package org.academiadecodigo.acarena.Networking;

/**
 * Created by codecadet on 17/11/16.
 */
public class ServerMain {

    public static void main(String[] args) {

        Server s1 = new Server("localhost", 8080);
        s1.start();
    }
}
