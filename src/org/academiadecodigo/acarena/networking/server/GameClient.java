package org.academiadecodigo.acarena.networking.server;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

/**
 * Created by codecadet on 19/11/16.
 */
public class GameClient implements Runnable {
    private DatagramPacket packet;
    private DatagramSocket socket;
    private InetAddress adress;
    private int port;
    public GameClient(DatagramPacket receivePacket, DatagramSocket datagramSocket) {
        this.socket = datagramSocket;
        adress = receivePacket.getAddress();
        port = receivePacket.getPort();
    }
    @Override
    public void run() {
//        while (true) {
//            if (packet == null) {
//                continue;
//            }
//            try {
//                socket.send(packet);
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//            packet = null;
//        }
    }
    public void sendPacket(DatagramPacket datagramPacket) {
        this.packet = datagramPacket;
        try {
            socket.send(new DatagramPacket(datagramPacket.getData(), datagramPacket.getLength(), adress, port)); // TODO: 18/11/16 parse the data to find the new port to send to
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
