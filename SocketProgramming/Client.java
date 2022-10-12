package SocketProgramming;

import java.io.*;
import java.net.Socket;

public class Client {


    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("192.168.56.1", 3000);
        DataOutputStream out = new DataOutputStream(socket.getOutputStream());
        out.writeUTF("Hello Server!");
//        System.out.println(socket.isBound());

        DataInputStream in = new DataInputStream(socket.getInputStream());
        System.out.println(in.readUTF());

    }

}
