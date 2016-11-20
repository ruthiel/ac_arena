package org.academiadecodigo.acarena.networking.client;

import com.googlecode.lanterna.TextCharacter;
import com.googlecode.lanterna.gui2.TextGUIGraphics;
import com.googlecode.lanterna.screen.AbstractScreen;
import com.googlecode.lanterna.screen.Screen;
import com.googlecode.lanterna.screen.ScreenBuffer;
import com.googlecode.lanterna.screen.TerminalScreen;
import com.googlecode.lanterna.terminal.Terminal;

import java.io.*;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

/**
 * Created by codecadet on 19/11/16.
 */
public class ReceiveData implements Runnable {
    private DatagramPacket packet;
    private DatagramSocket socket;
    private Screen screen;


    public ReceiveData(Screen screen, DatagramPacket receivePacket, DatagramSocket datagramSocket) {
        this.socket = datagramSocket;
        this.packet = receivePacket;
        this.screen = screen;
    }

    @Override
    public void run() {
        while (true) {

            byte[] receiveBuffer = new byte[2048];
            DatagramPacket recPacket = new DatagramPacket(receiveBuffer, receiveBuffer.length);

            try {
                socket.receive(recPacket);
            } catch (IOException e) {
                e.printStackTrace();
            }
            System.out.println(recPacket.toString());
        }
        }

    public static Object toObject(byte[] bytes) throws IOException, ClassNotFoundException {
        Object obj = null;
        ByteArrayInputStream bis = null;
        ObjectInputStream ois = null;
        try {
            bis = new ByteArrayInputStream(bytes);
            ois = new ObjectInputStream(bis);
            obj = ois.readObject();
        } finally {
            if (bis != null) {
                bis.close();
            }
            if (ois != null) {
                ois.close();
            }
        }
        return obj;
    }
}

