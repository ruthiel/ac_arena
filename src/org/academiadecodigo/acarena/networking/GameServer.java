package org.academiadecodigo.acarena.networking;

import org.academiadecodigo.acarena.Game;

import java.io.IOException;
import java.net.*;

/**
 * Created by codecadet on 18/11/16.
 */
public class GameServer extends Thread {

    private DatagramSocket socketServer;
    private Game game;

    public GameServer(Game game) {
        this.game = game;
        try {
            socketServer = new DatagramSocket(5000);
        } catch (SocketException e) {
            e.printStackTrace();
        }
    }

    public void run() {
        while (true) {
            byte[] data = new byte[2048];
            DatagramPacket receivePacket = new DatagramPacket(data, data.length);
            try {
                socketServer.receive(receivePacket);
            } catch (IOException e) {
                e.printStackTrace();
            }

            String message = new String(receivePacket.getData());
            System.out.println("CLIENT:" + message);
            if (message.trim().equalsIgnoreCase("ping")) {
                sendData("pong".getBytes(), receivePacket.getAddress(), receivePacket.getPort());
            }

        }
    }

    public void sendData(byte[] data, InetAddress ipAddress, int portNumber) {
        DatagramPacket sendPacket = new DatagramPacket(data, data.length, ipAddress, portNumber);
        try {
            socketServer.send(sendPacket);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
