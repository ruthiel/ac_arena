package org.academiadecodigo.acarena.GameObjects;

import org.academiadecodigo.acarena.CollisionDetector;
import org.academiadecodigo.acarena.Field;
import org.academiadecodigo.acarena.Position;

/**
 * Created by codecadet on 14/11/16.
 */
abstract public class GameObject {


    //This class needs a FieldPosition, a Field and a CollisionDetector
    private Position position;
    private Field field;

    protected CollisionDetector collisionDetector;


    public GameObject(Position position) {
        this.position = position;
    }

    public void setField(Field field){ this.field = field;}

    public Position getPosition() {return position;}

    public void setCollisionDetector(CollisionDetector collisionDetector){
        this.collisionDetector = collisionDetector;
    }

}
