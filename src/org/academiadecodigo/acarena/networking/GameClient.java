package org.academiadecodigo.acarena.networking;

import org.academiadecodigo.acarena.Game;

import java.io.IOException;
import java.net.*;

/**
 * Created by codecadet on 18/11/16.
 */
public class GameClient extends Thread {

    private InetAddress ipAddress;
    private DatagramSocket socketClient;
    private Game game;

    public GameClient(Game game, String ipAddress) {
        this.game = game;
        try {
            socketClient = new DatagramSocket();
            this.ipAddress = InetAddress.getByName(ipAddress);
        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (SocketException e) {
            e.printStackTrace();
        }
    }

    public void run() {
        while (true) {
            byte[] data = new byte[2048];
            DatagramPacket packet = new DatagramPacket(data, data.length);
            try {
                socketClient.receive(packet);
            } catch (IOException e) {
                e.printStackTrace();
            }
            String message = new String(packet.getData());
            System.out.println("SERVER: " + message);

        }
    }

    public void sendData(byte[] data) {
        DatagramPacket packet = new DatagramPacket(data, data.length, ipAddress, 5000);
        try {
            socketClient.send(packet);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
