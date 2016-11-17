package org.academiadecodigo.acarena.Networking;

import java.io.IOException;
import java.net.*;

/**
 * Created by codecadet on 14/11/16.
 */
public class Client {

    private String hostName;
    private int portNumber;
    DatagramSocket clientSocket;
    byte[] recBuffer;
    byte[] sendBuffer;
    DatagramPacket recPacket;
    DatagramPacket sendPacket;

    public Client(String hostName, int portNumber) {
        this.hostName = hostName;
        this.portNumber = portNumber;

        try {
            clientSocket = new DatagramSocket(portNumber);
        } catch (SocketException e) {
            e.printStackTrace();
        }
        sendClientData();

        try {
            sendPacket = new DatagramPacket(sendBuffer, sendBuffer.length, InetAddress.getByName(hostName), portNumber);
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
        recPacket = new DatagramPacket(recBuffer, recBuffer.length);
        receiveServerData();
    }

    public void sendClientData() {
        try {
            clientSocket.send(sendPacket);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void receiveServerData() {
        try {
            clientSocket.receive(recPacket);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
