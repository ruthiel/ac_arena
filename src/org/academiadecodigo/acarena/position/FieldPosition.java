package org.academiadecodigo.acarena.position;


import org.academiadecodigo.acarena.Direction;
import org.academiadecodigo.acarena.GameObjects.GameObject;
import org.academiadecodigo.acarena.TextColor;

import java.io.IOException;

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

    void setColor(TextColor color);

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
    public TextColor getColor();

    /**
     * Changes the getColor of this grid position
     *
     * @param color the new position getColor
     */
    public void setColor(com.googlecode.lanterna.TextColor color);

    /**
     * Displays the position in the grid
     */
    public void show(GameObject gameObject) throws IOException;

    /**
     * Hides the position in the grid
     */
    public void hide() throws IOException;

    /**
     * Moves this grid position towards a specified direction
     *
     * @param direction the direction to move to
     * @param distance  the number of positions to move
     */
    public void moveInDirection(Direction direction, int distance) throws IOException;

    /**
     * Tests equality with another position
     *
     * @param position the position to test against
     * @return true if positions are equal
     */
    public boolean equals(FieldPosition position);

    void create(GameObject gameObject);
}
