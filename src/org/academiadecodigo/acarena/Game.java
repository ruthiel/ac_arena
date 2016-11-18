package org.academiadecodigo.acarena;

import org.academiadecodigo.acarena.networking.GameClient;
import org.academiadecodigo.acarena.networking.GameServer;

/**
 * Created by codecadet on 14/11/16.
 */
public class Game {

    //TODO Check Collision goes here!

    private GameServer socketServer;
    private GameClient socketClient;

//    public void init() {
//        socketClient = new GameClient(this, "localhost");
//        socketClient.sendData("ping".getBytes());
//        start();
//    }

    public synchronized void start() {
        socketServer = new GameServer(this);
        socketClient = new GameClient(this, "localhost");
        socketServer.start();
        socketClient.start();
        socketClient.sendData("ping".getBytes());
    }
}
