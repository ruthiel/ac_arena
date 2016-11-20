package org.academiadecodigo.acarena.GameObjects.Movable;

import com.googlecode.lanterna.TextColor;
import org.academiadecodigo.acarena.GameObjects.GameObject;
import org.academiadecodigo.acarena.position.FieldPosition;

/**
 * Created by codecadet on 20/11/16.
 */
public class EmptySlut extends GameObject {
    public EmptySlut(FieldPosition position) {
        super(position);
        setColor(TextColor.ANSI.WHITE);
        setName("  ");
    }
}
