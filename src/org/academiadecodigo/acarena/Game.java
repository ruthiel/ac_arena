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

    public synchronized void start() {
        socketServer = new GameServer(this);
        socketServer.start();
    }

    public synchronized void newPlayer() {
        socketClient = new GameClient(this, "localhost");
        socketClient.start();
        socketClient.sendData("ping".getBytes());
    }
}
