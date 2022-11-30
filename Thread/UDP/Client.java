package Thread.UDP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

public class Client {
    // DatagramSocket : Socket Creation
    // DatagramPacket : UDP Packet
    public static void main(String[] args) {

        try (BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
                DatagramSocket socket = new DatagramSocket()){
            while (true) {
                byte[] buffer = in.readLine().getBytes();
                InetAddress address = InetAddress.getByName("localhost");
                DatagramPacket packet = new DatagramPacket(buffer, buffer.length, address, 8080);
                socket.send(packet);
            }

        } catch (SocketException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
