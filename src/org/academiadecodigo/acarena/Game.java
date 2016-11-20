package org.academiadecodigo.acarena;


import org.academiadecodigo.acarena.networking.server.GameClient;


import org.academiadecodigo.acarena.GameObjects.GameObjectsFactory;
import org.academiadecodigo.acarena.Lanterna.LanternaField;
import org.academiadecodigo.acarena.Lanterna.LanternaFieldPosition;
import test.PlayerTest;


import java.io.IOException;
import java.util.Map;

/**
 * Created by codecadet on 19/11/16.
 */
public class Game {

    public Game(Map<String, GameClient> map) {
    }


    private GameObjectsFactory factory;
    private LanternaField lanternaField;
    private Map<String, GameClient> map;
    private LanternaFieldPosition lanternaFieldPosition;


    public Game() throws IOException {

        lanternaField = new LanternaField(50, 50);
        Thread thread = new Thread(lanternaField);
        thread.start();
        PlayerTest playerTest = new PlayerTest(lanternaField);

    }
}
