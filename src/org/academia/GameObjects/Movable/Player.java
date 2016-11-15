package org.academia.GameObjects.Movable;

import org.academia.Direction;
import org.academia.GameObjects.GameObject;
import org.academia.GameObjects.Weapon;
import org.academia.GameObjects.WeaponType;
import org.academia.Position;

/**
 * Created by codecadet on 14/11/16.
 */
public class Player extends GameObject implements Movable {

    private Weapon weapon;
    private WeaponType weaponType;
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

    public void getWeapon() {
        hasWeapon = true;
    }

    public Projectile useWeapon(){

        WeaponType type;
        int damage;
        Projectile newProjectile = null;

        switch (type){
            case BOW:
                Projectile bowProjectile = new Projectile(1, 5);
                break;

            case AXE:
                Projectile axeProjectile1 = new Projectile(3, 1);
                //TODO create projectiles around the player
                break;

            case FLAMETRHOWER:
                Projectile flameProjectile = new Projectile(5, 7);
                break;

            default:
                System.out.println("Something really bad happened!");
        }

        return newProjectile;
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

    public Direction getDirection() {
        return direction;
    }

}
