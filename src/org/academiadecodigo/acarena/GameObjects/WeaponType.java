package org.academiadecodigo.acarena.GameObjects;

/**
 * Created by codecadet on 14/11/16.
 */
public enum WeaponType {

    BOW,
    AXE,
    FLAMETHROWER;

    private int range;

    public int getRange() {
        return range;
    }
}
