package TCP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Inet4Address;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class TCP_server {

    ServerSocket serverSocket; // 서버의 소켓
    Socket client_socket;   // 새로 생성된 소켓, 클라이언트의 소켓과 연결될 새로운 소켓
    PrintWriter out;    // 출력 스트림
    BufferedReader in;  // 버퍼 입력 스트림

    public void startServer() {
        try {
            serverSocket = new ServerSocket(); // 서버 소켓 생성
            serverSocket.bind(new InetSocketAddress(Inet4Address.getByName("localhost"), 3000)); // 서버 소켓 IP주소 및 Port 지정
            System.out.println("Listen......(Waiting Client Request)");
            client_socket = serverSocket.accept(); // 연결 허용
            System.out.println("Connection Accept");
            out = new PrintWriter(client_socket.getOutputStream(), true); // 클라이언트 소켓의 메시지 output
            in = new BufferedReader(new InputStreamReader(client_socket.getInputStream())); // 클라이언트 소켓의 메시지 input
            String message = in.readLine(); // message에 클라이언트의 메시지 값 입력 받기.
            if(message.equals("Hello Server!")) {
                out.println("Hello Client!"); // 클라이언트로부터 받은 메시지가 동일하면 클라이언트에게 성공 메시지 전송
            } else {
                out.println("Get out!"); // 클라이언트로부터 받은 메시지가 다르면 클라이언트에게 실패 메시지 전송
            }
            System.out.println("Finish the Job!");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void stopServer() throws IOException {
        in.close();
        out.close();
        client_socket.close();
        serverSocket.close();
    }

    public static void main(String[] args) {
        TCP_server tcp_server= new TCP_server();
        tcp_server.startServer();
    }
}
