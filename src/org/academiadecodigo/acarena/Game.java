package org.academiadecodigo.acarena;

import org.academiadecodigo.acarena.networking.GameClient;
import org.academiadecodigo.acarena.networking.GameServer;

import java.io.IOException;

/**
 * Created by codecadet on 14/11/16.
 */
public class Game {

    //TODO Check Collision goes here!

    private GameServer socketServer;
    private GameClient socketClient;

<<<<<<< HEAD
        init();

    }


    public void init(){

        try {
            field.init();
        } catch (IOException e) {
            e.printStackTrace();
        }

        players = new Player[numberOfPlayers];

        players[0].setCollisionDetector(collisionDetector);
        players[0].setField(field);

=======
    public synchronized void start() {
        socketServer = new GameServer(this);
        socketServer.start();
    }

    public synchronized void newPlayer() {
        socketClient = new GameClient(this, "localhost");
        socketClient.start();
        socketClient.sendData("ping".getBytes());
>>>>>>> c6f2eda170b4a098391b360d7474c5b8e74fa2d5
    }
}
