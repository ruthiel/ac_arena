package org.academiadecodigo.acarena.networking.client;


import com.googlecode.lanterna.input.KeyStroke;
import com.googlecode.lanterna.screen.Screen;
import com.googlecode.lanterna.screen.TerminalScreen;
import com.googlecode.lanterna.terminal.DefaultTerminalFactory;
import com.googlecode.lanterna.terminal.Terminal;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

/**
 * Created by codecadet on 14/11/16.
 */
public class Client {


    public static void main(String[] args) throws IOException {
        int portServer = 5000;
        String ipServer = "localhost";

        DatagramSocket clientSocket = new DatagramSocket();

        Screen screen = null;
        KeyStroke keyStroke;




        try {
            clientSocket = new DatagramSocket();
            Terminal terminal = new DefaultTerminalFactory().createTerminal();
            screen = new TerminalScreen(terminal);
            screen.getTerminalSize().withColumns(50);
            screen.getTerminalSize().withRows(80);
            screen.startScreen();


            byte[] receiveBuffer = new byte[2048];
            DatagramPacket receivePacket = new DatagramPacket(receiveBuffer, receiveBuffer.length);
            Thread thread = new Thread(new ReceiveData(screen,receivePacket,clientSocket));
            thread.start();




        } catch (IOException e) {
            e.printStackTrace();
        }
        while (true) {
            System.out.println("im here");
            keyStroke = screen.readInput();
            byte[] bytes = keyStroke.toString().getBytes();
            DatagramPacket datagramPacket;


            switch (keyStroke.getKeyType()) {
                case ArrowUp:
                    datagramPacket = new DatagramPacket(bytes, bytes.length, InetAddress.getByName(ipServer),portServer );
                    clientSocket.send(datagramPacket);
                    break;
                case ArrowDown:
                    datagramPacket = new DatagramPacket(bytes, bytes.length, InetAddress.getByName(ipServer), portServer);
                    clientSocket.send(datagramPacket);
                    break;
                case ArrowLeft:
                    datagramPacket = new DatagramPacket(bytes, bytes.length, InetAddress.getByName(ipServer), portServer);
                    clientSocket.send(datagramPacket);
                    break;
                case ArrowRight:
                    datagramPacket = new DatagramPacket(bytes, bytes.length, InetAddress.getByName(ipServer), portServer);
                    clientSocket.send(datagramPacket);
                    break;
                default:
                    System.out.println("W8iting for Input motherfucker");
                    break;
            }
        }


    }


}
