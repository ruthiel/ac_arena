package org.academiadecodigo.acarena.Networking;

import java.io.IOException;
import java.net.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Vector;

/**
 * Created by codecadet on 14/11/16.
 */
public class Server {

        private String hostName;
        private int portNumber;
        DatagramSocket serverSocket;
        DatagramPacket recPacket;
        DatagramPacket sendPacket;
        byte[] recBuffer;
        byte[] sendBuffer;
        private Vector<ClientHandler> container;
        private int[] arrPorts = {9010, 9020, 9030, 9040, 9050, 9060};

        public Server(String hostName, int portNumber) {
                this.hostName = hostName;
                this.portNumber = portNumber;
                container = new Vector<>();
        }

        public void start() {
                try {
                        serverSocket = new DatagramSocket(portNumber);
                } catch (SocketException e) {
                        e.printStackTrace();
                }
                recBuffer = new byte[2048];

                recPacket = new DatagramPacket(recBuffer, recBuffer.length);

                System.out.println("--------------- Waiting for players! --------------- ");
                try {
                        serverSocket.receive(recPacket);
                        System.out.println("Connection established");
                } catch (IOException e) {
                        e.printStackTrace();
                }

//                String message = new String(recBuffer, 0, recPacket.getLength());
//                System.out.println(message);
//
//                sendBuffer = message.getBytes();

                sendPacket = new DatagramPacket(sendBuffer, sendBuffer.length, recPacket.getAddress(), recPacket.getPort());

                try {
                        serverSocket.send(sendPacket);
                } catch (IOException e) {
                        e.printStackTrace();
                }

//                System.out.println(message);

        }

        public int getPortNumber() {
                return portNumber;
        }
}
