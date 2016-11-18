package org.academiadecodigo.acarena.GameObjects.Movable;

import org.academiadecodigo.acarena.Direction;
import org.academiadecodigo.acarena.position.AbstractFieldPosition;
import org.academiadecodigo.acarena.GameObjects.WeaponType;

/**
 * Created by codecadet on 14/11/16.
 */
public class Projectile implements Movable {

    private AbstractFieldPosition abstractFieldPosition;
    private Direction direction;
    private int damage;
    private int range;

    public Projectile(WeaponType type, Player player) {
        damage = type.getDamage();
        range = type.getRange();
//        initPosition = player.getPosition();
        direction = player.getDirection();
    }

    @Override
    public void move(){

        //Projectile moves in this.direction for this.range

    }
    public void hit(){


    }


    public int getDamage() {
        return damage;
    }

    public int getRange() {
        return range;
    }
}
