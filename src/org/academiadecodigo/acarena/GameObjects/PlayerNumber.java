package org.academiadecodigo.acarena.GameObjects;

import org.academiadecodigo.acarena.FieldColor;
import org.academiadecodigo.acarena.position.FieldPosition;

/**
 * Created by codecadet on 18/11/16.
 */
public enum PlayerNumber {

    ONE (FieldColor.BLUE),
    TWO (FieldColor.RED),
    THREE (FieldColor.GREEN),
    FOUR (FieldColor.YELLOW),
    FIVE (FieldColor.MAGENTA),
    SIX (FieldColor.ORANGE);

    //Each Player must have an initial position that is fixed!
    //See other enums for this!

    private FieldColor color;
    private FieldPosition position;

    PlayerNumber(FieldColor color){
        this.position = setPosition();
        this.color = color;
    }

    public FieldPosition setPosition(){

        switch (this) {
            case ONE:
                position.setPos(1,1);
                break;
            case TWO:
                position.setPos(2,0);
                break;
            case THREE:
                position.setPos(3,0);
                break;
            case FOUR:
                position.setPos(4,0);
                break;
            case FIVE:
                position.setPos(5,0);
                break;
            case SIX:
                position.setPos(6,0);
                break;
        }

        return position;
    }

}