package org.academiadecodigo.acarena.Networking;

import java.io.IOException;
import java.net.*;
import java.util.Scanner;

/**
 * Created by codecadet on 14/11/16.
 */
public class Client {

    private String hostName;
    private int portNumber;
    DatagramSocket clientSocket = null;
    byte[] recBuffer;
    byte[] sendBuffer;
    DatagramPacket recPacket;
    DatagramPacket sendPacket = null;
    Server server;

    public Client(String hostName, int portNumber) {
        this.hostName = hostName;
        this.portNumber = portNumber;
    }

    public void start() {
        try {
            clientSocket = new DatagramSocket(portNumber);
        } catch (SocketException e) {
            e.printStackTrace();
        }

        while (true) {

            recBuffer = new byte[2048];

            try {
                System.out.println(sendBuffer.length);
                System.out.println(InetAddress.getByName(hostName));
                sendPacket = new DatagramPacket(sendBuffer, sendBuffer.length, InetAddress.getByName(hostName), 8080);
            } catch (UnknownHostException e) {
                e.printStackTrace();
            }

            try {
                clientSocket.send(sendPacket);
            } catch (IOException e) {
                e.printStackTrace();
            }

            recPacket = new DatagramPacket(recBuffer, recBuffer.length);

            try {
                clientSocket.receive(recPacket);
            } catch (IOException e) {
                e.printStackTrace();
            }

            String serverMessage = new String(recBuffer, 0, recPacket.getLength());
            System.out.println(serverMessage);
        }

    }
}
