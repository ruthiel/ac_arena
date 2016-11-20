package org.academiadecodigo.acarena.networking.server;

import org.academiadecodigo.acarena.Game;

import java.io.IOException;
import java.net.*;
import java.util.*;

/**
 * Created by codecadet on 14/11/16.
 */
public class Server {
//    public static void main(String[] args) {
//        Map<String, GameClient> map = new HashMap<>();
//        DatagramSocket socket = null;
//        int portNumber = 5000;
//        try {
//            socket = new DatagramSocket(portNumber);
//        } catch (SocketException e) {
//            e.printStackTrace();
//        }
//        while (true) {
//            System.out.println("----- Server open ------");
//            byte[] receiveBuffer = new byte[2048];
//            DatagramPacket receivePacket = new DatagramPacket(receiveBuffer, receiveBuffer.length);
//            try {
//                socket.receive(receivePacket);
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//            if (map.containsKey(receivePacket.getAddress())) {
//                System.out.println("Cliente existente");
//                continue;
//            }
//            String upper = String.valueOf(receivePacket.getAddress());
////            GameClient client = new GameClient(receivePacket, socket);
////            Thread clientThread = new Thread(client);
//            clientThread.start();
//            map.put(upper, client);
//            byte[] sendBuffer = new byte[2048];
//            System.out.println(map.size());
//            for (GameClient value : map.values()) {
//                value.sendPacket(receivePacket);
//            }
//        }
//    }
}
