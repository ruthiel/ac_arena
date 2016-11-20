package org.academiadecodigo.acarena.networking.server;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

/**
 * Created by codecadet on 19/11/16.
 */
public class GameClient implements Runnable {
    private DatagramPacket packet;
    private DatagramSocket socket;
    private InetAddress address;
    private int port;

    public GameClient(DatagramPacket receivePacket, DatagramSocket socket) throws SocketException {
        this.socket = socket;
        address = receivePacket.getAddress();
        port = receivePacket.getPort();
    }

    @Override
    public void run() {
    }

    public void sendPacket(DatagramPacket datagramPacket) {
        this.packet = datagramPacket;
        try {
            socket.send(new DatagramPacket(datagramPacket.getData(), datagramPacket.getLength(), address, port));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
