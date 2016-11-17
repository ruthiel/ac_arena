package org.academiadecodigo.acarena;

import org.academiadecodigo.acarena.position.FieldPosition;

import java.io.IOException;

public interface Field {

    /**
     * Initializes the grid
     */
    public void init() throws IOException;

    /**
     * Gets the number of columns in the grid
     *
     * @return the number of columns
     */
    public int getCols();

    /**
     * Gets the number of rows in the grid
     *
     * @return the number of rows
     */
    public int getRows();

    /**
     * Create a random grid position
     *
     * @return the new grid position
     */
    public FieldPosition makeFieldPosition();

    /**
     * Creates a a grid position in a specific column and row
     *
     * @param col   the position column
     * @param row   the position row
     * @return the new grid position
     */
    public FieldPosition makeFieldPosition(int col, int row);

}
