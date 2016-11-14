package org.academia;

/**
 * Created by codecadet on 14/11/16.
 */
public class Position {

    private int col;
    private int row;

    public Position(int col, int row) {
        this.col = col;
        this.row = row;
    }

    public Position move(Direction direction, int speed) {

        switch (direction) {

            case UP:
                moveUp();
                break;
            case DOWN:
                moveDown();
                break;
            case RIGHT:
                moveRight();
                break;
            case LEFT:
                moveLeft();
                break;
        }
        return this;
    }

    private void moveUp() {
        if (row <= 0) return;
        row--;
    }

    private void moveDown() {
        if (row >= Field.height - 1) return;
        row++;
    }

    private void moveRight() {
        if (col >= Field.width - 1) return;
        col++;
    }

    private void moveLeft() {
        if (col <= 0) return;
        col--;
    }

}
