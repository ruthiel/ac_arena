package org.academiadecodigo.acarena.GameObjects.Movable;

import org.academiadecodigo.acarena.Direction;
import org.academiadecodigo.acarena.GameObjects.Weapon;
import org.academiadecodigo.acarena.GameObjects.WeaponType;
import org.academiadecodigo.acarena.Position;

/**
 * Created by codecadet on 14/11/16.
 */
public class Projectile implements Movable {

    private Position initPosition;
    private Direction direction;
    private int damage;
    private int range;

    public Projectile(WeaponType type, Player player) {
        this.damage = type.getDamage();
        this.range = type.getRange();
        this.initPosition = player.getPosition();
        this.direction = player.getDirection();
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
