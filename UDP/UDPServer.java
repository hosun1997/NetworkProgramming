import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

class UDPServer {
    public static void main(String[] args) {
        try {
            DatagramSocket serverSocket = new DatagramSocket(8080);
            byte[] buf = new byte[2000];
            DatagramPacket datagram = new DatagramPacket(buf, buf.length);
            System.out.println("Server Listening.......");
            while (true) {
                serverSocket.receive(datagram);
                datagram.getAddress().getHostAddress();
                System.out.println("Client Address: " + datagram.getAddress().getHostAddress());
                String message = new String(datagram.getData());
                System.out.println("Client가 전송한 Message: " + message);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
