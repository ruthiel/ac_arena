package org.academiadecodigo.acarena.GameObjects;

import org.academiadecodigo.acarena.TextColor;

/**
 * Created by codecadet on 14/11/16.
 */
public enum WeaponType {

    BOW (1, "1", TextColor.ANSI.CYAN),
    AXE (2, "2", TextColor.ANSI.GREEN),
    FLAMETRHOWER (2, "5", TextColor.ANSI.MAGENTA);

    private int points;
    private String name;
    private TextColor.ANSI textColor;

    WeaponType(int points, String name, TextColor.ANSI textColor) {

        this.points = points;
        this.name = name;
        this.textColor = textColor;
    }

//    public int getRange() {
//        return range;
//    }
//
//    public int getDamage() { return damage; }


    public int getPoints() {
        return points;
    }

    public String getName() {
        return name;
    }

    public TextColor.ANSI getTextColor() {
        return textColor;
    }
}

