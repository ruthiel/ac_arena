package org.academiadecodigo.acarena.GameObjects.Movable;

import org.academiadecodigo.acarena.Direction;
import org.academiadecodigo.acarena.GameObjects.GameObject;
import org.academiadecodigo.acarena.position.FieldPosition;

/**
 * Created by codecadet on 14/11/16.
 */
public class Boss extends GameObject implements Movable {

    private Direction direction;
    private FieldPosition position;
    private int health;
    private boolean isDead;

    private final int HEALTH = 500;
    private final int DAMAGE = 50;
    private final int RANGE = 2;


    public Boss(FieldPosition position) {
        super(position);
        setHealth(HEALTH);
    }

    @Override
    public void move() {

        //DO THIS
        move(chooseDirection(), 1);

    }

    public Direction chooseDirection(){

        Direction newDirection = direction;

        if(Math.random() > ((double) 2) / 10){
            newDirection = Direction.values()[(int)(Math.random()*Direction.values().length)];
        }
        return newDirection;
    }

    public void setHealth(int health) {this.health = health;}

    public void setDead(boolean dead) {isDead = dead;}
}
