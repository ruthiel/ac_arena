package org.academiadecodigo.acarena;

import org.academiadecodigo.acarena.GameObjects.GameObject;
import org.academiadecodigo.acarena.GameObjects.Movable.Player;
import org.academiadecodigo.acarena.GameObjects.Weapon;
import org.academiadecodigo.acarena.position.FieldPosition;
import org.academiadecodigo.acarena.position.AbstractFieldPosition;

/**
 * Created by codecadet on 17/11/16.
 */
public class CollisionDetector {

    private static GameObject[][] objects;

    public CollisionDetector(GameObject[][] objects) {
        this.objects = objects;
    }

    public boolean hasCollided(AbstractFieldPosition position) {


        for (int i = 0; i < objects.length; i++) {
            for (int j = 0; j < objects[0].length; j++) {
                if (objects[i][j].getPosition() != position && objects[i][j].getPosition().equals(position)) {
                    return true;
                }
            }
        }
        return false;
    }


    //Checks for collisions with player
    //

    public void check(Player player) {

        for (int i = 0; i < objects.length; i++) {
            for (int j = 0; j < objects[0].length; j++) {
                if (objects[i][j].getPosition().getCol()==player.getPosition().getCol() && objects[i][j].getPosition().getRow() == player.getPosition().getRow()&&  objects[i][j]instanceof Weapon){
                   player.increasePoints((Weapon) objects[i][j]);
                    System.out.println("OI");

                }
//
//                if (objects[i][j].getPosition().equals(player.getPosition()) && objects[i][j] instanceof Weapon) {
//
//                }

            }
        }
    }

//    public boolean checkCollision(Direction direction, GameObject object) {
//
//        FieldPosition tempPosition = adjacentPosition(direction, object);
//
//        if (object instanceof Player) {
//
//            for (int i = 0; i < objects.length; i++) {
//                if (!objects[i][].getPosition().equals(tempPosition)) {
//                    continue;
//                }
//                if (!(objects[i] instanceof Weapon)) {
//                    return true;
//                }
//            }
//            return false;
//        } else {
//            for (int i = 0; i < objects.length; i++) {
//                if (!objects[i].getPosition().equals(tempPosition)) {
//                    continue;
//                }
//                return true;
//            }
//            return false;
//        }
//    }

    private FieldPosition adjacentPosition(Direction direction, GameObject object) {

        FieldPosition position = object.getPosition();

        switch (direction) {
            case UP:
                position.setPos(position.getCol(), position.getRow() - 1);
                break;
            case DOWN:
                position.setPos(position.getCol(), position.getRow() + 1);
                break;
            case LEFT:
                position.setPos(position.getCol() - 1, position.getRow());
                break;
            case RIGHT:
                position.setPos(position.getCol() + 1, position.getRow());
                break;
        }
        return position;
    }

    private static class CollisionDetectorHolder {

        private static final CollisionDetector collisionDetector = new CollisionDetector(objects);
    }

    public static CollisionDetector getCollisionDetector() {
        return CollisionDetectorHolder.collisionDetector;
    }


    public static void setObjects(GameObject[][] objects) {
        CollisionDetector.objects = objects;
    }
}
