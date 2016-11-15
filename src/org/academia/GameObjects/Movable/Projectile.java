package org.academia.GameObjects.Movable;

import org.academia.Direction;
import org.academia.GameObjects.Movable.Movable;
import org.academia.Position;

/**
 * Created by codecadet on 14/11/16.
 */
public class Projectile implements Movable {

    private Position position;
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
