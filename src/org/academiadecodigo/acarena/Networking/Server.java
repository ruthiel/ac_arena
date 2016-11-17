package org.academiadecodigo.acarena.Networking;

import java.io.IOException;
import java.net.*;
import java.util.Scanner;

/**
 * Created by codecadet on 14/11/16.
 */
public class Server {

        private String hostName;
        private int portNumber;
        Scanner keyboardInput;
        DatagramSocket serverSocket;
        DatagramPacket recPacket;
        DatagramPacket sendPacket;
        byte[] recBuffer;
        byte[] sendBuffer;

        public Server(String hostName, int portNumber) {
                this.hostName = hostName;
                this.portNumber = portNumber;
                keyboardInput = new Scanner(System.in);

                //creation of Socket
                try {
                        serverSocket = new DatagramSocket(portNumber);
                } catch (SocketException e) {
                        e.printStackTrace();
                }

                recBuffer = new byte[2048];
                recPacket = new DatagramPacket(recBuffer, recBuffer.length);
                createConnection();

                try {
                        sendPacket = new DatagramPacket(sendBuffer, sendBuffer.length, InetAddress.getByName(hostName), portNumber);
                } catch (UnknownHostException e) {
                        e.printStackTrace();
                }
        }

        public void createConnection() {
                System.out.println("--------------- Waiting for players! --------------- ");
                try {
                        serverSocket.receive(recPacket);
                } catch (IOException e) {
                        e.printStackTrace();
                }
        }

        public void updatePosition() {
                try {
                        serverSocket.send(sendPacket);
                } catch (IOException e) {
                        e.printStackTrace();
                }
        }
}
