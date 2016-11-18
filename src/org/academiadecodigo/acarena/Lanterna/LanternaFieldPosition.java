package org.academiadecodigo.acarena.Lanterna;

import com.googlecode.lanterna.TextCharacter;
import com.googlecode.lanterna.TextColor;
import org.academiadecodigo.acarena.Direction;
import org.academiadecodigo.acarena.FieldColor;
import org.academiadecodigo.acarena.position.AbstractFieldPosition;
import org.academiadecodigo.acarena.position.FieldPosition;

import java.io.IOException;

/**
 * A GridPosition implementation for the Lanterna based Grid
 */
public class LanternaFieldPosition extends AbstractFieldPosition {

    /**
     * Construct a new random field position
     *
     * @param field  the field where the position will live on
     */
    public LanternaFieldPosition(LanternaField field) throws IOException {

        super((int) (Math.random() * field.getCols()), (int) (Math.random() * field.getRows()), field);
        show();

    }

    /**
     * Creates a new grid position at a specific column and row
     *
     * @param col   the grid position column
     * @param row   the  grid position row
     * @param field  the grid where the position will live on
     */
    public LanternaFieldPosition(int col, int row, LanternaField field) throws IOException {

        super(col, row, field);

    }

    @Override
    public FieldColor getColor() {
        return null;
    }

    @Override
    public void setColor(FieldColor color) {

    }

    @Override
    public void show() throws IOException {
        ((LanternaField)getField()).getScreen().setCharacter(getCol(),getRow(), new TextCharacter('w', TextColor.ANSI.BLUE,TextColor.ANSI.RED));
        ((LanternaField)getField()).getScreen().refresh();
    }


    @Override
    public void hide() throws IOException {
        ((LanternaField)getField()).getScreen().setCharacter(getCol(),getRow(), new TextCharacter(' '));


    }

    @Override
    public boolean equals(FieldPosition position) {
        return false;
    }

    @Override
    public void moveInDirection(Direction direction, int distance) throws IOException {

        hide();
        super.moveInDirection(direction, distance);
        show();

    }

}
