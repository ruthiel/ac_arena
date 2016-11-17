package org.academiadecodigo.acarena.Lanterna;

import org.academiadecodigo.acarena.Direction;
import org.academiadecodigo.acarena.FieldColor;
import org.academiadecodigo.acarena.position.AbstractFieldPosition;
import org.academiadecodigo.acarena.position.FieldPosition;

/**
 * A GridPosition implementation for the Lanterna based Grid
 */
public class LanternaGridPosition extends AbstractFieldPosition {

    private Object field;

    /**
     * Construct a new random field position
     *
     * @param field  the field where the position will live on
     */
    public LanternaGridPosition(LanternaField field) {

        super((int) (Math.random() * field.getCols()), (int) (Math.random() * field.getRows()), field);
        show();

    }

    /**
     * Creates a new grid position at a specific column and row
     *
     * @param col   the grid position column
     * @param row   the  grid position row
     * @param grid  the grid where the position will live on
     */
    public LanternaGridPosition(int col, int row, LanternaField grid) {

        super(col, row, grid);
        show();

    }

    @Override
    public FieldColor getColor() {
        return null;
    }

    @Override
    public void setColor(FieldColor color) {

    }

    @Override
    public void show() {
        ((LanternaField) getField()).show(this);
    }

    @Override
    public void hide() {
        ((LanternaField) getField()).hide(this);
    }

    @Override
    public boolean equals(FieldPosition position) {
        return false;
    }

    @Override
    public void moveInDirection(Direction direction, int distance) {

        hide();
        super.moveInDirection(direction, distance);
        show();

    }

    public Object getField() {
        return field;
    }
}
