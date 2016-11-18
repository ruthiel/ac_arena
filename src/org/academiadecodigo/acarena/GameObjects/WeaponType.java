package org.academiadecodigo.acarena.GameObjects;

/**
 * Created by codecadet on 14/11/16.
 */
public enum WeaponType {

    BOW (8, 4),
    AXE (2, 8),
    FLAMETRHOWER (10, 10);

    private int range;
    private int damage;

    WeaponType(int range, int damage) {
        this.range = range;
        this.damage = damage;
    }

    public int getRange() {
        return range;
    }

    public int getDamage() { return damage; }
}

