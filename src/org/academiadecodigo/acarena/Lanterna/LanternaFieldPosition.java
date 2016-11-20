package org.academiadecodigo.acarena.Lanterna;

import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.TextCharacter;
import com.googlecode.lanterna.gui2.Label;
import org.academiadecodigo.acarena.Direction;
import org.academiadecodigo.acarena.TextColor;
import org.academiadecodigo.acarena.GameObjects.GameObject;
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
     * @param field the field where the position will live on
     */
    public LanternaFieldPosition(LanternaField field) throws IOException {

        super((int) (Math.random() * field.getCols()), (int) (Math.random() * field.getRows()), field);

    }

    /**
     * Creates a new grid position at a specific column and row
     *
     * @param col   the grid position column
     * @param row   the  grid position row
     * @param field the grid where the position will live on
     */
    public LanternaFieldPosition(int col, int row, LanternaField field) throws IOException {

        super(col, row, field);

    }

    @Override
    public TextColor getColor() {
        return null;
    }

    @Override
    public void setColor(com.googlecode.lanterna.TextColor color) {

    }



//    public void show() throws IOException {
//        ((LanternaField)getField()).getScreen().setCharacter(getCol(),getRow(), new TextCharacter('w', TextColor.ANSI.BLUE,TextColor.ANSI.RED));
//        ((LanternaField)getField()).getScreen().refresh();
//    }


    @Override
    public void show(GameObject object) throws IOException {



    }

    @Override
    public void hide() throws IOException {


    }

    @Override
    public boolean equals(FieldPosition position) {
        return false;
    }

    @Override
    public void moveInDirection(Direction direction, int distance) throws IOException {

        hide();
        super.moveInDirection(direction, distance);

    }

    @Override
    public void create(GameObject object){
        ((LanternaField) getField()).getPanel().addComponent(new Label(object.getName()).setBackgroundColor(object.getColor()).setSize(new TerminalSize(1,1)).setLabelWidth(2));
    }

}
