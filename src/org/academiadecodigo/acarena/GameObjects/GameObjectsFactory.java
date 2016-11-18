package org.academiadecodigo.acarena.GameObjects;

import org.academiadecodigo.acarena.Field;
import org.academiadecodigo.acarena.GameObjects.Movable.Player;

/**
 * Created by codecadet on 18/11/16.
 */
public class GameObjectsFactory {



    public static Player getNewPlayer(Field field){

        Player player = new Player(field.makeFieldPosition())



        return player;
    }




}
