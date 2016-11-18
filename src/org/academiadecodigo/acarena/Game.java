package org.academiadecodigo.acarena;

import org.academiadecodigo.acarena.GameObjects.GameObject;

/**
 * Created by codecadet on 14/11/16.
 */
public class Game {

    //TODO Check Collision goes here!

    private Field field;
    private GameObject[] gameObjects;
    private CollisionDetector collisionDetector;

    public Game() {

        collisionDetector = CollisionDetector.getCollisionDetector();

    }
}
