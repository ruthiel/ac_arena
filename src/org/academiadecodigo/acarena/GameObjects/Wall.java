package org.academiadecodigo.acarena.GameObjects;

import com.googlecode.lanterna.TextCharacter;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.terminal.Terminal;
import org.academiadecodigo.acarena.position.FieldPosition;

import java.io.IOException;

/**
 * Created by codecadet on 14/11/16.
 */
public class Wall extends GameObject {

    public Wall(FieldPosition fieldPosition) {
        super(fieldPosition);
        setCharacter(new TextCharacter(' ', TextColor.RGB.Indexed.fromRGB(179,179,179), TextColor.RGB.Indexed.fromRGB(255,255,255)));
    }

    @Override
    public void setCharacter(TextCharacter character) {
        super.setCharacter(character);
    }


}
