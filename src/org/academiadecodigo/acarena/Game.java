package org.academiadecodigo.acarena;


import org.academiadecodigo.acarena.networking.server.GameClient;


import org.academiadecodigo.acarena.GameObjects.GameObjectsFactory;
import org.academiadecodigo.acarena.Lanterna.LanternaField;
import org.academiadecodigo.acarena.Lanterna.LanternaFieldPosition;
import org.academiadecodigo.acarena.GameObjects.Movable.Player;


import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by codecadet on 19/11/16.
 */
public class Game {

    private GameObjectsFactory factory;
    private LanternaField lanternaField;
    private Map<String, Player> playerTestMap;
    private LanternaFieldPosition lanternaFieldPosition;
    private Player player;

    public Game(Map<GameClient, String> map) throws IOException {

        lanternaField = new LanternaField(50, 50);
        Thread threadField = new Thread(lanternaField);
        threadField.start();
        playerTestMap = new HashMap<>();
        CollisionDetector collisionDetector = new CollisionDetector(lanternaField.getGameObjects());
        for (String value : map.values()) {

            Player player = new Player(new LanternaFieldPosition(10, 10, lanternaField), lanternaField);
            playerTestMap.put(value, player);
            player.repaint();

            System.out.println(Thread.currentThread().getName());
        }
    }

    synchronized public void movePlayer(String data, String ip) throws IOException {

        player = playerTestMap.get(ip);
        data = data.substring(0,1);
        System.out.println("the data is: " + data);
        System.out.println("Player Points: " + player.getPoints());

        switch (data) {
            case "u":
                lanternaField.removepaint(player.getPosition());
                player.getPosition().moveInDirection(Direction.UP, 1);
                lanternaField.repaint(player.getPosition());
                CollisionDetector.getCollisionDetector().check(player);
                System.out.println(player.getPosition());
                break;

            case "d":
                lanternaField.removepaint(player.getPosition());
                player.getPosition().moveInDirection(Direction.DOWN, 1);
                lanternaField.repaint(player.getPosition());
                CollisionDetector.getCollisionDetector().check(player);
                System.out.println(player.getPosition());
                break;

            case "l":
                lanternaField.removepaint(player.getPosition());
                player.getPosition().moveInDirection(Direction.LEFT, 1);
                lanternaField.repaint(player.getPosition());
                CollisionDetector.getCollisionDetector().check(player);
                System.out.println(player.getPosition());
                break;

            case "r":
                lanternaField.removepaint(player.getPosition());
                player.getPosition().moveInDirection(Direction.RIGHT, 1);
                lanternaField.repaint(player.getPosition());
                CollisionDetector.getCollisionDetector().check(player);
                System.out.println(player.getPosition());
                break;

            default:
                System.out.println("W8iting for Input motherfucker");
                break;
        }
        CollisionDetector.getCollisionDetector().check(player);
    }
}
