package org.academiadecodigo.acarena.GameObjects.Movable;

import org.academiadecodigo.acarena.Direction;
import org.academiadecodigo.acarena.Field;
import org.academiadecodigo.acarena.GameObjects.GameObject;
import org.academiadecodigo.acarena.GameObjects.Weapon;
import org.academiadecodigo.acarena.GameObjects.WeaponType;
import org.academiadecodigo.acarena.Position;

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
    private Field field;

    public Player(Field field) {
        this.field = field;
        setHealth(100);
        setPosition();

    }


    @Override
    public void move(){


    }

    public void getWeapon() {
        hasWeapon = true;
    }

    public Projectile useWeapon(WeaponType weaponType){

        int damage;
        Projectile newProjectile = null;

        switch (weaponType){
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
