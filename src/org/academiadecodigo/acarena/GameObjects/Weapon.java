package org.academiadecodigo.acarena.GameObjects;

<<<<<<< HEAD
import org.academiadecodigo.acarena.position.AbstractFieldPosition;
=======
import org.academiadecodigo.acarena.GameObjects.Movable.Projectile;
import org.academiadecodigo.acarena.Position;
>>>>>>> gamelogic

/**
 * Created by codecadet on 14/11/16.
 */
public class Weapon extends GameObject {

<<<<<<< HEAD
    private int col;
    private int row;
    private AbstractFieldPosition abstractFieldPosition;
=======
>>>>>>> gamelogic
    private boolean used;
    private Projectile projectile;
    private WeaponType weaponType;

    public Weapon(Position position, WeaponType weaponType) {
        super(position);
        this.weaponType = weaponType;
    }

    public void setUsed(boolean used) {
        this.used = used;
    }
}
