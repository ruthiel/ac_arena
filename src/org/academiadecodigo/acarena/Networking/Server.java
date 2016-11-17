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
        DatagramSocket serverSocket;
        DatagramPacket recPacket;
        DatagramPacket sendPacket;
        byte[] recBuffer;
        byte[] sendBuffer;




        public Server(String hostName, int portNumber) {
                this.hostName = hostName;
                this.portNumber = portNumber;
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

                String message = new String(recBuffer, 0, recPacket.getLength());
                System.out.println(message);

                //mudar p bytes
                sendBuffer = message.getBytes();

                try {
                        sendPacket = new DatagramPacket(sendBuffer, sendBuffer.length, InetAddress.getByName(hostName), portNumber);
                } catch (UnknownHostException e) {
                        e.printStackTrace();
                }
                try {
                        serverSocket.send(sendPacket);
                } catch (IOException e) {
                        e.printStackTrace();
                }

        }

}
