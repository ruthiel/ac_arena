package org.academiadecodigo.acarena;

import org.academiadecodigo.acarena.GameObjects.GameObject;
import org.academiadecodigo.acarena.GameObjects.Movable.Player;

import java.io.IOException;

/**
 * Created by codecadet on 14/11/16.
 */
public class Game {

    //TODO Check Collision goes here!

    private Field field;
    private GameObject[] gameObjects;
    private Player[] players;
    private CollisionDetector collisionDetector;
    private int numberOfPlayers;


    //This class needs a lot of things...see CarCrash

    public Game(int numberPlayers) {

        collisionDetector = CollisionDetector.getCollisionDetector();
        field = FieldFactory.makeField();
        numberOfPlayers = numberPlayers;

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

    }


}
