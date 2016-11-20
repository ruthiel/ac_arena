package org.academiadecodigo.acarena.networking.server;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by codecadet on 19/11/16.
 */
public class Server2nd implements Runnable {

    DatagramSocket serverSocket;

    Map<String, GameClient> map;

    public Server2nd() {
        this(9999);
    }


    public Server2nd(int portNumber) {
        try {
            serverSocket = new DatagramSocket(portNumber);
        } catch (SocketException e) {
            e.printStackTrace();
        }
        map = new HashMap<>();
    }


    public void run() {

        DatagramPacket packetReceive = new DatagramPacket(new byte[1024], 1024);

        while (true)
            try {
                System.out.println("Waiting for Players!");
                //Vão ter de receber criar uma nova socket e enviar da mesma socket que receberam o primeiro packet, com a informação de onde se vão ligar a seguir (port)
                serverSocket.receive(packetReceive);

                System.out.println(map.size());

                if (map.containsKey(packetReceive.getAddress())) {
                    for (GameClient value : map.values()) {
                        serverSocket.send(packetReceive);
                        value.sendPacket(packetReceive);
                        continue;
                    }
                }
                DatagramSocket clientSocket = new DatagramSocket();

                String upper = String.valueOf(packetReceive.getAddress());
                GameClient client = new GameClient(packetReceive, clientSocket);
                Thread clientThread = new Thread(client);
                clientThread.start();

                map.put(upper, client);

                byte[] sendBuffer = new byte[2048];
                for (GameClient value : map.values()) {
                    serverSocket.send(packetReceive);
                    value.sendPacket(packetReceive);

                }

                String toSend = "Connect to port: " + clientSocket.getLocalPort();
//                serverSocket.send(new DatagramPacket(toSend.getBytes(), toSend.getBytes().length, packetReceive.getAddress(), packetReceive.getPort()));
//                clientSocket.receive(packetReceive);
//                clientSocket.send(new DatagramPacket("Connected".getBytes(), "Connected".getBytes().length, packetReceive.getAddress(), packetReceive.getPort()));

            } catch (IOException e) {
                e.printStackTrace();
            }
    }
}

