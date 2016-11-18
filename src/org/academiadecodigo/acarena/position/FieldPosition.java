package org.academiadecodigo.acarena.position;


import org.academiadecodigo.acarena.Direction;
import org.academiadecodigo.acarena.FieldColor;

/**
 * A position on the grid that is capable of moving around
 */
public interface FieldPosition {

    /**
     * Gets the position column in the grid
     *
     * @return the position column
     */
    public int getCol();

    /**
     * Gets the position row in the grid
     *
     * @return the position row
     */
    public int getRow();

    /**
     * Updates the position column and row
     *
     * @param col the new position column
     * @param row the new position row
     */
    public void setPos(int col, int row);

    /**
     * Gets the position getColor
     *
     * @return the position getColor
     */
    public FieldColor getColor();

    /**
     * Changes the getColor of this grid position
     *
     * @param color the new position getColor
     */
    public void setColor(FieldColor color);

    /**
     * Displays the position in the grid
     */
    public void show();

    /**
     * Hides the position in the grid
     */
    public void hide();

    /**
     * Moves this grid position towards a specified direction
     *
     * @param direction the direction to move to
     * @param distance  the number of positions to move
     */
    public void moveInDirection(Direction direction, int distance);

    /**
     * Tests equality with another position
     *
     * @param position the position to test against
     * @return true if positions are equal
     */
    public boolean equals(FieldPosition position);

}