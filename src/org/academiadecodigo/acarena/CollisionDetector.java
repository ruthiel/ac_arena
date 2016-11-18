package org.academiadecodigo.acarena;

import org.academiadecodigo.acarena.GameObjects.GameObject;
import org.academiadecodigo.acarena.GameObjects.Movable.Player;
import org.academiadecodigo.acarena.position.AbstractFieldPosition;

/**
 * Created by codecadet on 17/11/16.
 */
public class CollisionDetector {

    private GameObject[] objects;

    public CollisionDetector(GameObject[] objects) {
        this.objects = objects;
    }

    public boolean hasCollided(AbstractFieldPosition position){

        for (GameObject object : objects){
            if (object.getPosition()!= position && object.getPosition().equals(position)){
                return true;
            }
        }
        return false;
    }


    //Checks for collisions with player
    //

    public void check(Player player){

        for (GameObject ob : objects){

            if (ob == player){
                continue;
            }

            if (ob.getPosition().equals(player.getPosition())){
                player.collision();
            }

        }
    }

}
