package org.academiadecodigo.acarena.GameObjects.Movable;

import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.gui2.Label;
import com.googlecode.lanterna.input.*;
import org.academiadecodigo.acarena.Direction;
import org.academiadecodigo.acarena.GameObjects.GameObject;
import org.academiadecodigo.acarena.GameObjects.PlayerNumber;
import org.academiadecodigo.acarena.GameObjects.Weapon;
import org.academiadecodigo.acarena.GameObjects.WeaponType;
import org.academiadecodigo.acarena.Lanterna.LanternaField;
import org.academiadecodigo.acarena.Lanterna.LanternaFieldPosition;
import org.academiadecodigo.acarena.position.AbstractFieldPosition;
import org.academiadecodigo.acarena.position.FieldPosition;

import java.io.IOException;
import java.io.ObjectInput;

/**
 * Created by codecadet on 14/11/16.
 */
public class Player extends GameObject {

    AbstractFieldPosition pos;
    LanternaField lanternaField;
    Label label;

    private Weapon weapon;
    private PlayerNumber playerNumber;
    private Direction direction;
    private FieldPosition abstractFieldPosition;
    private int health;
    private boolean isDead;
    private boolean hasWeapon;

    private int points;

    private final int HEALTH = 100;

    public Player(LanternaFieldPosition position, LanternaField lanternaField) throws IOException {
        super(position);
        this.pos = position;
        this.lanternaField = lanternaField;
        setColor(TextColor.ANSI.BLUE);
        setName(" ");
        setHealth(HEALTH);
    }

    public void repaint() throws IOException {
        lanternaField.repaint(getPosition());
    }

    public void playerMove(KeyStroke keyStroke) throws IOException {

        switch (keyStroke.getKeyType()) {
            case ArrowUp:
                pos.moveUp(1);
                label.setPosition(new TerminalPosition((pos.getCol()), pos.getRow()));
                lanternaField.getGui().updateScreen();
                System.out.println(pos.toString());
                break;

            case ArrowDown:
                pos.moveDown(1);
                label.setPosition(new TerminalPosition((pos.getCol()), pos.getRow()));
                lanternaField.getGui().updateScreen();
                System.out.println(pos.toString());
                // pos.show();

                break;
            case ArrowLeft:
                System.out.println("player test " + Thread.currentThread().getName());
                pos.moveLeft(1);
                label.setPosition(new TerminalPosition((pos.getCol()), pos.getRow()));
                lanternaField.getGui().updateScreen();
                System.out.println(pos.toString());
                // pos.show();

                break;
            case ArrowRight:
                pos.moveRight(1);
                label.setPosition(new TerminalPosition((pos.getCol()), pos.getRow()));
                lanternaField.getGui().updateScreen();
                System.out.println(pos.toString());
                System.out.println(((LanternaField) pos.getField()).getScreen().toString().getBytes());
                // pos.show();
                break;
            default:
                System.out.println("W8iting for Input motherfucker");
                break;
        }
    }


    public void useWeapon(WeaponType weaponType) {

        if (hasWeapon) {
            Projectile projectile = new Projectile(weaponType, this);
            projectile.move();
            dropWeapon();
        }
    }


    public void setDead(boolean dead) {
        isDead = dead;
    }

    public void getWeapon() {
        hasWeapon = true;
    }

    public void dropWeapon() {
        hasWeapon = false;
    }

    public void takeDamage(int damage) {
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

    public void setPoints(int points) {
        this.points = points;
    }

    public void increasePoints(Weapon weapon) {

        int tmp = weapon.getWeaponType().getPoints();
        setPoints(points + tmp);
    }

    public int getPoints() {
        return points;
    }

}



