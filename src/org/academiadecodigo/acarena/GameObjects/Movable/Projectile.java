package org.academiadecodigo.acarena.GameObjects.Movable;

import org.academiadecodigo.acarena.Direction;
import org.academiadecodigo.acarena.position.AbstractFieldPosition;

/**
 * Created by codecadet on 14/11/16.
 */
public class Projectile implements Movable {

    private AbstractFieldPosition abstractFieldPosition;
    private Direction direction;
    private int damage;
    private int range;

    public Projectile(int damage, int range) {
        this.damage = damage;
        this.range = range;
    }

    @Override
    public void move(){


    }
    public void hit(){


    }

}
