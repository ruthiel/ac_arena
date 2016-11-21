package org.academiadecodigo.acarena.networking.server;

import com.googlecode.lanterna.input.KeyStroke;
import org.academiadecodigo.acarena.Game;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.*;
import java.util.*;

/**
 * Created by codecadet on 14/11/16.
 */
public class Server implements Runnable {
    static Map<GameClient, String> map;
    private LinkedList<GameClient> clientList;
    private Game game;
    boolean gameOnline;

    public Server() {
        map = new HashMap<>();
    }

    public static Map<GameClient, String> getMap() {
        return map;
    }

    @Override
    public void run() {
        DatagramSocket socket = null;
        int portNumber = 5000;
        clientList = new LinkedList<>();

        try {
            socket = new DatagramSocket(portNumber);
        } catch (SocketException e) {
            e.printStackTrace();
        }

        while (true) {
            System.out.println("----- Server open ------");
            byte[] receiveBuffer = new byte[2048];
            DatagramPacket receivePacket = new DatagramPacket(receiveBuffer, receiveBuffer.length);

            if (map.size() == 1 && gameOnline == false) {
                try {
                    game = new Game(map);
                } catch (IOException e) {
                    e.printStackTrace();
                }
                gameOnline = true;
            }


            try {
                socket.receive(receivePacket);
                String data = new String(receivePacket.getData());

                movePlayer(data, receivePacket);
            } catch (IOException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }

            Iterator<GameClient> iterator = map.keySet().iterator();

            if (map.containsValue(String.valueOf(receivePacket.getAddress()))) {
                System.out.println("Cliente existente");
                System.out.println(clientList.size());
                for (int i = 0; i < clientList.size(); i++) {
                    clientList.get(i).sendPacket(receivePacket);
                    continue;
                }
            } else {

                String ip = String.valueOf(receivePacket.getAddress());
                GameClient client = null;
                try {
                    client = new GameClient(receivePacket, socket);
                } catch (SocketException e) {
                    e.printStackTrace();
                }

                Thread clientThread = new Thread(client);
                clientThread.start();
                clientList.add(client);
                map.put(client, ip);
                System.out.println(map.size());

                byte[] sendBuffer = new byte[2048];
                DatagramPacket sendPacket = new DatagramPacket(receiveBuffer, receiveBuffer.length);


                for (int i = 0; i < clientList.size(); i++) {
                    clientList.get(i).sendPacket(sendPacket);
                }


            }
        }
    }

private void movePlayer (String data ,DatagramPacket datagramPacket) throws IOException, ClassNotFoundException {
        System.out.println("before sending the message");
        if(map.containsValue(String.valueOf(datagramPacket.getAddress()))){
            System.out.println("sending message");
            game.movePlayer(data, String.valueOf(datagramPacket.getAddress()));
        }
    }
}

