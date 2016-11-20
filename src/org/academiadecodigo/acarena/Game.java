package org.academiadecodigo.acarena;


import com.googlecode.lanterna.input.KeyStroke;
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

    private GameObjectsFactory factory;
    private LanternaField lanternaField;
    private Map<String, PlayerTest> playerTestMap;
    private LanternaFieldPosition lanternaFieldPosition;


    public Game(Map<String, GameClient> map) throws IOException {

        lanternaField = new LanternaField(50, 50);
        Thread threadField = new Thread(lanternaField);

        threadField.start();

        for (String key : map.keySet()) {
            PlayerTest player = new PlayerTest(new LanternaFieldPosition(10,10,lanternaField),lanternaField);
            playerTestMap.put(key,player);
            player.repaint();
        }



    }
    public void movePlayer(KeyStroke keyStroke ,String ip){


    }
}
