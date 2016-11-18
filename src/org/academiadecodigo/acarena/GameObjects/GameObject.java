package org.academiadecodigo.acarena.GameObjects;

import org.academiadecodigo.acarena.position.AbstractFieldPosition;
import org.academiadecodigo.acarena.CollisionDetector;
import org.academiadecodigo.acarena.Field;

/**
 * Created by codecadet on 14/11/16.
 */
abstract public class GameObject {

    AbstractFieldPosition abstractFieldPosition;

    //This class needs a FieldPosition, a Field and a CollisionDetector
    private AbstractFieldPosition position;
    private Field field;

    protected CollisionDetector collisionDetector;


    public GameObject(AbstractFieldPosition position) {
        this.position = position;
    }

    public void setField(Field field) {
        this.field = field;
    }

    public AbstractFieldPosition getPosition() {
        return position;
    }

    public void setCollisionDetector(CollisionDetector collisionDetector) {
        this.collisionDetector = collisionDetector;
    }

}
