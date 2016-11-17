package org.academiadecodigo.acarena.position;

import org.academiadecodigo.acarena.Direction;
import org.academiadecodigo.acarena.Lanterna.LanternaField;

/**
 * Created by codecadet on 14/11/16.
 */
public abstract class AbstractFieldPosition implements FieldPosition {
    private int col;
    private int row;
    private final int distance = 1;

    private LanternaField lanternaField;

    public AbstractFieldPosition(int col, int row, LanternaField lanternaField) {
        this.col = col;
        this.row = row;
        this.lanternaField = lanternaField;
    }

    public void setPos(int col, int row) {
        this.col = col;
        this.row = row;
        show();
    }
    public void draw(){
        lanternaField.getTerminal();
    }


    // TODO: 13/11/16 For the players to move and appear on screen


    public void moveInDirection(Direction direction, int distance) {

        switch (direction) {

            case UP:
                moveUp(distance);
                break;
            case DOWN:
                moveDown(distance);
                break;
            case LEFT:
                moveLeft(distance);
                break;
            case RIGHT:
                moveRight(distance);
                break;
        }

    }

    public void moveUp(int dist) {

        int maxRowsUp = dist < row ? dist : row;
        setPos(col, row - maxRowsUp);

    }

    /**
     * Moves the position down
     *
     * @param dist the number of positions to move
     */
    public void moveDown(int dist) {

        int maxRowsDown = dist > lanternaField.getRows() - (row + 1) ? lanternaField.getRows() - (row + 1) : dist;
        setPos(col, row + maxRowsDown);

    }

    /**
     * Moves the position left
     *
     * @param dist the number of positions to move
     */
    public void moveLeft(int dist) {

        int maxRowsLeft = dist < col ? dist : col;
        setPos(col - maxRowsLeft, row);

    }

    /**
     * Moves the position right
     *
     * @param dist the number of positions to move
     */
    public void moveRight(int dist) {
        int maxRowsRight = dist > lanternaField.getCols() - (col + 1) ? lanternaField.getCols() - (col + 1) : dist;
        setPos(col + maxRowsRight, row);
    }


    @Override
    public String toString() {
        return "AbstractFieldPosition: " + col + ", " + row;

    }

    public int getRow() {
        return row;
    }

    public int getCol() {
        return col;
    }
}

