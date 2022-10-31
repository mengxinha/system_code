package net;


import java.io.IOException;
import java.net.*;

import java.util.Scanner;

public class UdpEchoClient {
   private DatagramSocket socket=null;
   private String serverIP;
   private int serverPort;



    public UdpEchoClient(String serverIP,int serverPort) throws SocketException {

        socket = new DatagramSocket();
        this.serverIP =serverIP;
        this.serverPort=serverPort;
    }


    public void start() throws IOException {
        Scanner scanner= new Scanner(System.in);
        while(true){
            System.out.println("-> ");
            String request= scanner.next();
            DatagramPacket requestPacket = new DatagramPacket(request.getBytes(),request.getBytes().length,
                    InetAddress.getByName(this.serverIP),this.serverPort
                    );
            socket.send(requestPacket);


            //System.out.println("[%s:%d] req:; resp: \n",requestPacket.getAddress().toString(),requestPacket.getAddress());

            System.out.println("ch");

        }



    }

    public String process(String request){
        return request;
    }


    public static void main(String[] args) throws IOException {
        UdpEchoServer server = new UdpEchoServer(9090);
        server.start();
    }
}
