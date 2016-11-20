package org.academiadecodigo.acarena.GameObjects;

import com.googlecode.lanterna.TextColor;
import org.academiadecodigo.acarena.GameObjects.Movable.Projectile;
import org.academiadecodigo.acarena.position.FieldPosition;

/**
 * Created by codecadet on 14/11/16.
 */
public class Weapon extends GameObject {


    private boolean used;
    private Projectile projectile;
    private WeaponType weaponType;

    public Weapon(FieldPosition position, WeaponType weaponType) {
        super(position);
        this.weaponType = weaponType;
        setColor(weaponType.getTextColor());
        setName(weaponType.getName());
    }

    public void setUsed(boolean used) {
        this.used = used;
    }
}
