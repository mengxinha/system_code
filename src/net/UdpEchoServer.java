package net;

import javax.swing.plaf.synth.SynthLookAndFeel;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

public class UdpEchoServer {
    private DatagramSocket socket = null;

    public UdpEchoServer(int port) throws SocketException {
        socket = new DatagramSocket();

    }

    public void start() throws IOException {
        System.out.println("服务器启动！");
        while (true){
            DatagramPacket requestPacket = new DatagramPacket(new byte[4096], 4096);
            socket.receive(requestPacket);

            String request = new String(requestPacket.getData(),0,requestPacket.getLength());

            String response = process(request);

            DatagramPacket responsePacket = new DatagramPacket(requestPacket.getData(),0,requestPacket.getLength(),
            requestPacket.getSocketAddress());

            socket.send(requestPacket);

            System.out.printf("[%s:%d] req: %s; resp:%s \n",requestPacket.getSocketAddress()
                    .toString(),requestPacket.getPort(),request,response);
        }
    }

    private String process(String request) {
        return request;
    }

    public static void main(String[] args) throws IOException {
        UdpEchoServer server = new UdpEchoServer(9090);
        server.start();
    }


}
