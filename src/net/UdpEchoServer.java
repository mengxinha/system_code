package net;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

public class UdpEchoServer {
    private DatagramSocket socket = null;

    public UdpEchoServer(int port) throws SocketException {
        socket = new DatagramSocket();

    }

    public void start(){
        System.out.println("服务器启动！");
        while (true){
            DatagramPacket requestPacket = new DatagramPacket(new byte[4096], 4096);
            //socket.receive();

            String request = new String(requestPacket.getData(),0,requestPacket.getLength());


        }
    }


}
