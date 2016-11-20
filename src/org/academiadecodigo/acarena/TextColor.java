package org.academiadecodigo.acarena;

import java.awt.*;

/**
 * Created by codecadet on 17/11/16.
 */
public enum TextColor implements com.googlecode.lanterna.TextColor {

    RED,
    GREEN,
    BLUE,
    MAGENTA,
    YELLOW,
    ORANGE;

    @Override
    public byte[] getForegroundSGRSequence() {
        return new byte[0];
    }

    @Override
    public byte[] getBackgroundSGRSequence() {
        return new byte[0];
    }

    @Override
    public Color toColor() {
        return null;
    }
}
