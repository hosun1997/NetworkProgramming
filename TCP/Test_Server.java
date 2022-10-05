package TCP;

import java.io.*;
import java.net.Inet4Address;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class Test_Server {
    // 이미지 파일 하나를 클라이언트에게 전송합니다.
    ServerSocket serverSocket; // 서버의 소켓
    Socket newsocket;   // 새로 생성된 소켓, 클라이언트의 소켓과 연결될 새로운 소켓
    OutputStream out;
    FileInputStream in;

    public void startServer() {
        File file = new File("C:/Users/user/Downloads/photo.jpg");

        try {
            serverSocket = new ServerSocket(); // 서버 소켓 생성
            serverSocket.bind(new InetSocketAddress(Inet4Address.getByName("localhost"), 3000)); // 서버 소켓 IP 주소 및 Port 지정

            System.out.println("Listen......(Waiting Client Request)");
            newsocket = serverSocket.accept(); // 연결 허용
            System.out.println("Connection Accept, Start transferring file.");

            // Server에서 이미지 파일을 Client로 전송합니다.
            in = new FileInputStream(file);
            out = newsocket.getOutputStream();

            byte[] tmp = new byte[1024];    //버퍼기능
            int c = 0;
            while ((c = in.read(tmp)) != -1) {
                out.write(tmp, 0, c);
            }
            out.close();
            System.out.println("Finish the Job!");


        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void stopServer() throws IOException {
        in.close();
        out.close();
        newsocket.close();
        serverSocket.close();
    }

    public static void main(String[] args) {
        Test_Server test_server = new Test_Server();
        test_server.startServer();
        try {
            test_server.stopServer();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
