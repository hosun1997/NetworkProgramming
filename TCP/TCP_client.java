package TCP;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Inet4Address;
import java.net.Socket;

public class TCP_client{
    Socket client_socket;
    PrintWriter out;
    BufferedReader in;
    public void serverConnection() {
        try {
            client_socket = new Socket(Inet4Address.getByName("localhost"), 3000); // Server의 Server Socket에 요청
//            client_socket = new Socket("localhost", 9500);
            out = new PrintWriter(client_socket.getOutputStream(), true);
            in = new BufferedReader(new InputStreamReader(client_socket.getInputStream()));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void sendMessage(String message) {
        try {
            out.println(message);
            String response = in.readLine();
            System.out.println(response);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void sendImage() {

    }
    public static void main(String[] args) {
        TCP_client tcp_client= new TCP_client();
        tcp_client.serverConnection();
        tcp_client.sendMessage("Hello Server!");
    }

}
