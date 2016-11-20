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
    FOUR (TextColor.YELLOW);

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
        }

        return position;
    }

}
