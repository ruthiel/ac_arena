package org.academiadecodigo.acarena.GameObjects;

import org.academiadecodigo.acarena.position.AbstractFieldPosition;

/**
 * Created by codecadet on 14/11/16.
 */
public class Weapon extends GameObject {

    private int col;
    private int row;
    private AbstractFieldPosition abstractFieldPosition;
    private boolean used;


    public Weapon() {
    }

    public Weapon(int col, int row) {
        this.col = col;
        this.row = row;
    }


    // TODO: 14/11/16 implement ammo for weapons




}
