package org.academia;

/**
 * Created by codecadet on 14/11/16.
 */
public enum Direction {

    UP,
    DOWN,
    RIGHT,
    LEFT;


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
