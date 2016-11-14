package org.academia.GameObjects.Movable;

import org.academia.Direction;
import org.academia.GameObjects.GameObjects;
import org.academia.GameObjects.Weapon;
import org.academia.Position;

/**
 * Created by codecadet on 14/11/16.
 */
public class Player extends GameObjects implements Movable {

    private Weapon weapon;
    private Direction direction;
    private Position position;
    private int health;
    private boolean isDead;
    private boolean hasWeapon;


    public Player() {
        setHealth(100);
        setPosition();

    }


    @Override
    public void move(){


    }

    public void useWeapon(Player opponent){



    }

    public void takeDamage(int damage){
        health -= damage;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public void setPosition() {


    }
}
