package org.academiadecodigo.acarena.GameObjects;

import com.googlecode.lanterna.TextCharacter;
import com.googlecode.lanterna.TextColor;
import org.academiadecodigo.acarena.Direction;
import org.academiadecodigo.acarena.position.AbstractFieldPosition;
import org.academiadecodigo.acarena.CollisionDetector;
import org.academiadecodigo.acarena.Field;
import org.academiadecodigo.acarena.position.FieldPosition;

import java.io.IOException;

/**
 * Created by codecadet on 14/11/16.
 */
abstract public class GameObject {

    private FieldPosition position;
    private Field field;
    protected CollisionDetector collisionDetector;
    private TextCharacter character;
    private String name;
    private TextColor color;


    public GameObject(FieldPosition position) {
        this.position = position;
    }

    public void setField(Field field) {
        this.field = field;
    }

    public FieldPosition getPosition() {
        return position;
    }

    public void setCollisionDetector(CollisionDetector collisionDetector) {
        this.collisionDetector = collisionDetector;
    }

    public void move(Direction direction, int moves) {

        try {
            getPosition().moveInDirection(direction, moves);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public TextCharacter getChar() {
        return character;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setColor(TextColor color) {
        this.color = color;
    }

    public void setCharacter(TextCharacter character) {
        this.character = character;
    }

    public String getName() {
        return name;
    }

    public TextColor getColor() {
        return color;
    }
}
