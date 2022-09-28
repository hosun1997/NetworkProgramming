package TCP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Inet4Address;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class Ex2_Server {
    //TCP Server 제작
    ServerSocket serverSocket;
    Socket clientSocket;
    PrintWriter out;
    BufferedReader in;

    public void startServer() {
        try {
            serverSocket = new ServerSocket(4000); // port 지정 x : 임의의 포트번호 배정됨.
//            clientSocket.bind(new InetSocketAddress(Inet4Address.getByName("172.16.39.165"), 3000));
            System.out.println("Listening......");
            clientSocket = serverSocket.accept();
            System.out.println("Accept......");
            out = new PrintWriter(clientSocket.getOutputStream(), true);
            in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            String message = in.readLine();
//            System.out.println(message);
            if(message.equals("Hello Server!")) {
                System.out.println("Hello Client!");
            } else {
                System.out.println("Get out!");
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void stopServer() throws IOException {
        in.close();
        out.close();
        clientSocket.close();
        serverSocket.close();;
    }

    public static void main(String[] args) {
        Ex2_Server ex2_server = new Ex2_Server();
        ex2_server.startServer();

    }
}
