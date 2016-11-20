package org.academiadecodigo.acarena.GameObjects.Movable;

import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.gui2.Label;
import com.googlecode.lanterna.input.KeyStroke;
import org.academiadecodigo.acarena.Direction;
import org.academiadecodigo.acarena.GameObjects.PlayerNumber;
import org.academiadecodigo.acarena.Lanterna.LanternaField;
import org.academiadecodigo.acarena.GameObjects.GameObject;
import org.academiadecodigo.acarena.GameObjects.Weapon;
import org.academiadecodigo.acarena.GameObjects.WeaponType;
import org.academiadecodigo.acarena.Lanterna.LanternaFieldPosition;
import org.academiadecodigo.acarena.position.AbstractFieldPosition;
import org.academiadecodigo.acarena.position.FieldPosition;

import java.io.IOException;

/**
 * Created by codecadet on 14/11/16.
 */
public class ShittyPlayer extends GameObject implements Movable {

    private Weapon weapon;
    private PlayerNumber playerNumber;
    private Direction direction;
    private FieldPosition abstractFieldPosition;
    private int health;
    private boolean isDead;
    private boolean hasWeapon;
    private LanternaField lanternaField;
    private AbstractFieldPosition pos;
    private Label label;

    private final int HEALTH = 100;


    public ShittyPlayer(PlayerNumber playerNumber, LanternaFieldPosition position, LanternaField lanternaField) {
        super(playerNumber.setPosition());
        this.pos = position;
        this.lanternaField = lanternaField;

        setColor(TextColor.ANSI.BLUE);
        setName(" ");

        setHealth(HEALTH);
    }

    @Override
    public void move(){

        move(direction, 1);
    //DO THIS

    }


    public void useWeapon(WeaponType weaponType){

        if (hasWeapon) {
            Projectile projectile = new Projectile(weaponType, this);
            projectile.move();
            dropWeapon();
        }
    }

    public void collision() {

    //ALSO DO THIS
        //Test collision with walls, boss and players

        //Test collision with Weapons: getWeapon();

    }

    public void setDead(boolean dead) {isDead = dead;}

    public void getWeapon() {
        hasWeapon = true;
    }

    public void dropWeapon() {hasWeapon = false; }

    public void takeDamage(int damage){
        health -= damage;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public Direction getDirection() {
        return direction;
    }


}
