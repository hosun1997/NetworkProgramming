package Thread.UDP;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

public class Main {
    // DatagramSocket : Socket Creation
    // DatagramPacket : UDP Packet
    public static void main(String[] args) {
        //10.109.11.23
        try (DatagramSocket socket = new DatagramSocket(8080)) {
            byte[] buffer = new byte[1024 * 1024];
            DatagramPacket packet = new DatagramPacket(buffer, buffer.length);
            while (true) {
//                String a = "안녕하세요";
//                System.out.println(a.length());
//                System.out.println(a.getBytes().length);
                System.out.println("==========================================");
                System.out.println("UDP Client Waiting......");
                socket.receive(packet);
                byte[] receivedData = packet.getData();
                System.out.printf("[Client] IP: %s, Port: %d\n", packet.getAddress().getHostAddress(), packet.getPort());
                System.out.printf("Offset: %d, Length: %d\n", packet.getOffset(), packet.getLength());
                String message = new String(receivedData, packet.getOffset(), packet.getLength());
                System.out.println("[Message] " + message);
            }
        } catch (SocketException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}// UDP Server