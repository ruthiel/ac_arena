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
        this.address = receivePacket.getAddress();
        this.port = receivePacket.getPort();
    }

    @Override
    public void run() {

    }

    public void sendPacket(DatagramPacket datagramPacket) {
        try {
            socket.send(new DatagramPacket(datagramPacket.getData(), datagramPacket.getLength(), this.address, this.port));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
