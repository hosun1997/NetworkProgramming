package Java_IO.Serialization;

import java.io.*;
import java.net.*;

public class Server {


    public static void main(String[] args) throws IOException, ClassNotFoundException {
        ServerSocket serverSocket = new ServerSocket();
        serverSocket.bind(new InetSocketAddress("localhost", 3000));



        while (true) {
            Socket clientSocket = serverSocket.accept();

            System.out.println("Client Accept!");
            System.out.println();

            // Client로부터 객체를 읽어올 역할을 하는 객체를 생성
            ObjectInputStream objIn = new ObjectInputStream(clientSocket.getInputStream()); // Class의 객체를 읽어올때 사용
            Member member = (Member)objIn.readObject();
            System.out.println(member);

            ObjectOutputStream objOut = new ObjectOutputStream(clientSocket.getOutputStream());             // Server to Client
            BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            Member kim = new Member("Kim", 30);
            Member hwang = new Member("Hwang", 25);

            objOut.writeObject(kim);
            objOut.writeObject(hwang);

        }



    }
}
