package org.academiadecodigo.acarena.networking.server;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

/**
 * Created by codecadet on 19/11/16.
 */
public class Server2nd {

        DatagramSocket serverSocket;

        public Server2nd() {
            this(9999);
        }


        public Server2nd(int portNumber) {
            try {
                serverSocket = new DatagramSocket(portNumber);
            } catch (SocketException e) {
                e.printStackTrace();
            }
        }


        public void run() {

            DatagramPacket packetReceive = new DatagramPacket(new byte[1024], 1024);

           while (true)
            try {
                //Vão ter de receber criar uma nova socket e enviar da mesma socket que receberam o primeiro packet, com a informação de onde se vão ligar a seguir (port)
                serverSocket.receive(packetReceive);

                DatagramSocket clientSocket = new DatagramSocket();
                String toSend = "Connect to port: " + clientSocket.getLocalPort();
                serverSocket.send(new DatagramPacket(toSend.getBytes(), toSend.getBytes().length, packetReceive.getAddress(), packetReceive.getPort()));
                clientSocket.receive(packetReceive);
                clientSocket.send(new DatagramPacket("Connected".getBytes(), "Connected".getBytes().length, packetReceive.getAddress(), packetReceive.getPort()));

                //Só testei com o nc mas se dá com ele também dá com código vosso.

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

