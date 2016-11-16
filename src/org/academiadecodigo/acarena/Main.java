package org.academiadecodigo.acarena;

import org.academiadecodigo.acarena.GameObjects.Movable.Player;
import test.PlayerTest;

import java.io.IOException;

/**
 * Created by codecadet on 14/11/16.
 */
public class Main {
    public static void main(String[] args) throws IOException {
        Field field = new Field(10,10);
        field.init();
        //Player player = new Player(field);
        field.toStrange();


    }
}
