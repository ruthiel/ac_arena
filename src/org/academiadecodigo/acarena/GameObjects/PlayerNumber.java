package org.academiadecodigo.acarena.GameObjects;

import org.academiadecodigo.acarena.TextColor;
import org.academiadecodigo.acarena.position.FieldPosition;

/**
 * Created by codecadet on 18/11/16.
 */
public enum PlayerNumber {

    ONE (TextColor.BLUE),
    TWO (TextColor.RED),
    THREE (TextColor.GREEN),
    FOUR (TextColor.YELLOW),
    FIVE (TextColor.MAGENTA),
    SIX (TextColor.ORANGE);

    //Each Player must have an initial position that is fixed!
    //See other enums for this!

    private TextColor color;
    private FieldPosition position;

    PlayerNumber(TextColor color){
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
