package org.academiadecodigo.acarena;

import org.academiadecodigo.acarena.GameObjects.GameObject;
import org.academiadecodigo.acarena.GameObjects.Movable.Player;
import org.academiadecodigo.acarena.position.FieldPosition;

/**
 * Created by codecadet on 17/11/16.
 */
public class CollisionDetector {

    private static GameObject[] objects;

    private CollisionDetector(GameObject[] objects) {
        this.objects = objects;
    }

    public boolean hasCollided(FieldPosition position){

        for (GameObject object : objects){
            if (object.getPosition() != position && object.getPosition().equals(position)){
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

    private static class CollisionDetectorHolder{

        private static final CollisionDetector collisionDetector = new CollisionDetector(objects);
    }

    public static CollisionDetector getCollisionDetector(){
        return CollisionDetectorHolder.collisionDetector;
    }

}
