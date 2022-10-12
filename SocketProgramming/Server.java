package SocketProgramming;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.*;
import java.sql.SQLOutput;

// 192.168.56.1

public class Server {

    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket();
        serverSocket.bind(new InetSocketAddress("192.168.56.1", 3000));
//        System.out.println("Bound? : " + serverSocket.isBound());

        while (true) {
            Socket clientSocket = serverSocket.accept();
            DataInputStream in = new DataInputStream(clientSocket.getInputStream());

            System.out.println("Client Accept!");
            System.out.println();
            System.out.println("[Server Socket]");
            System.out.println(serverSocket.getLocalPort());
            System.out.println(serverSocket.getLocalSocketAddress());
            System.out.println();
            System.out.println("[Client Socket]");
            System.out.println("Client Port: " + clientSocket.getPort());
            System.out.println("Client IP: " + clientSocket.getInetAddress());
            System.out.println();
            System.out.println("[Client Socket] - Local");
            System.out.println(clientSocket.getLocalPort());
            System.out.println(clientSocket.getLocalSocketAddress());
            System.out.println();
            System.out.println("[Client가 전송한 데이터]");
            System.out.println(in.readUTF());

            String message = "Hello Client!";
            DataOutputStream out = new DataOutputStream(clientSocket.getOutputStream());
            out.writeUTF("[ECHO] " + message);
            clientSocket.close();
        }


    }
}
