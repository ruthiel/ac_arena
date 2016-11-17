package org.academiadecodigo.acarena.GameObjects;

import org.academiadecodigo.acarena.position.AbstractFieldPosition;

/**
 * Created by codecadet on 14/11/16.
 */
public class Wall extends GameObject {

    private AbstractFieldPosition abstractFieldPosition;

    public Wall(AbstractFieldPosition abstractFieldPosition) {
        this.abstractFieldPosition = abstractFieldPosition;
    }

    public Wall(){

    }

}
