package org.academiadecodigo.acarena.GameObjects.Movable;

import org.academiadecodigo.acarena.Direction;
import org.academiadecodigo.acarena.position.FieldPosition;
import org.academiadecodigo.acarena.GameObjects.WeaponType;

import java.io.IOException;

/**
 * Created by codecadet on 14/11/16.
 */
public class Projectile implements Movable {

    private FieldPosition initPosition;
    private Direction direction;


    public Projectile(WeaponType type, Player player) {

//        initPosition = player.getPosition();
        direction = player.getDirection();
    }

    @Override
    public void move(){

//        //Projectile moves in this.direction for this.range
//        try {
//            getInitPosition().moveInDirection(direction, range);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }

    }
    public void hit(){


    }

    public FieldPosition getInitPosition() {return initPosition;}

    public Direction getDirection() {return direction;}

//    public int getDamage() {
//        return damage;
//    }
//
//    public int getRange() {
//        return range;
//    }
}
