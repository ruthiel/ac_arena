package org.academia;

import java.io.IOException;

/**
 * Created by codecadet on 14/11/16.
 */
public class Main {
    public static void main(String[] args) throws IOException {
        Field field = new Field(30,30);
        field.init();
        Player player = new Player(field);

    }
}
