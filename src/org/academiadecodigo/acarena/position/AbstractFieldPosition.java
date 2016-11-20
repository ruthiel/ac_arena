package org.academiadecodigo.acarena.position;

import org.academiadecodigo.acarena.Direction;
import org.academiadecodigo.acarena.Field;
import org.academiadecodigo.acarena.GameObjects.GameObject;
import org.academiadecodigo.acarena.TextColor;

import java.io.IOException;

/**
 * Created by codecadet on 14/11/16.
 */
public abstract class AbstractFieldPosition implements FieldPosition {
    private int col;
    private int row;
    private TextColor color;
    private final int distance = 1;
    private Field field;

    public AbstractFieldPosition(int col, int row, Field field) {
        this.col = col;
        this.row = row;
        this.field = field;
    }

    public Field getField() {
        return field;
    }

    @Override
    public TextColor getColor() {
        return color;
    }

    @Override
    public void setColor(TextColor color) {
        this.color = color;
    }

    public void setPos(int col, int row) {
        this.col = col;
        this.row = row;
    }
    public void draw(){

    }


    // TODO: 13/11/16 For the players to move and appear on screen

    @Override
    public abstract void show(GameObject object) throws IOException;

    public void moveInDirection(Direction direction, int distance) throws IOException {

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

        int maxRowsDown = dist > field.getRows() - (row + 1) ? field.getRows() - (row + 1) : dist;
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
        int maxRowsRight = dist > field.getCols() - (col + 1) ? field.getCols() - (col + 1) : dist;
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

