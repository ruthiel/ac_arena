package org.academiadecodigo.acarena;

/**
 * Created by codecadet on 14/11/16.
 */
public enum Direction {

    UP,
    DOWN,
    LEFT,
    RIGHT;


    public Direction oppositeDirection() {

        switch (this) {

            case UP:
                return DOWN;
            case DOWN:
                return UP;
            case LEFT:
                return RIGHT;
            case RIGHT:
                return LEFT;
            default:
                return null;
        }
    }
}


