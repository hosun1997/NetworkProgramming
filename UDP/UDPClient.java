import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.Inet6Address;
import java.net.InetAddress;
import java.net.SocketException;
import java.util.Scanner;

class UDPClient {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String message = "Hello UDP Server!";
        try {
            DatagramSocket clientSocket = new DatagramSocket(5000);
            InetAddress serveAddress = Inet6Address.getByName("127.0.0.1");
            DatagramPacket datagramPacket = new DatagramPacket(message.getBytes(), message.length(), serveAddress, 8080);
            clientSocket.send(datagramPacket);
            clientSocket.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
