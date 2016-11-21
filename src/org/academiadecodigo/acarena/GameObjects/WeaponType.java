package org.academiadecodigo.acarena.GameObjects;

import org.academiadecodigo.acarena.TextColor;

/**
 * Created by codecadet on 14/11/16.
 */
public enum WeaponType {

    BOW (8, 4, "B", TextColor.ANSI.CYAN),
    AXE (2, 8, "A", TextColor.ANSI.GREEN),
    FLAMETRHOWER (10, 10, "F", TextColor.ANSI.MAGENTA);

    private int range;
    private int damage;
    private String name;
    private TextColor.ANSI textColor;

    WeaponType(int range, int damage, String name, TextColor.ANSI textColor) {
        this.range = range;
        this.damage = damage;
        this.name = name;
        this.textColor = textColor;
    }

    public int getRange() {
        return range;
    }

    public int getDamage() { return damage; }

    public String getName() {
        return name;
    }

    public TextColor.ANSI getTextColor() {
        return textColor;
    }
}

