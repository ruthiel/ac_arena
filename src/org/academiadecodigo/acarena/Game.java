package org.academiadecodigo.acarena;

import org.academiadecodigo.acarena.GameObjects.GameObjectsFactory;
import org.academiadecodigo.acarena.Lanterna.LanternaField;
import org.academiadecodigo.acarena.Lanterna.LanternaFieldPosition;
import org.academiadecodigo.acarena.networking.server.GameClient;

import java.io.IOException;
import java.util.Map;

/**
 * Created by codecadet on 19/11/16.
 */
public class Game {

    private GameObjectsFactory factory;
    private LanternaField lanternaField;
    private Map<String,GameClient> map;
    private LanternaFieldPosition lanternaFieldPosition;


    public Game() {

        lanternaField = new LanternaField(50,50);

        try {
            lanternaField.init();
        } catch (IOException e) {
            e.printStackTrace();
        }

        factory = new GameObjectsFactory(lanternaField);
        factory.populateFieldWithWalls();
        factory.populateFieldWithFuckinWeapons();


    }







}
