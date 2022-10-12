package Java_IO.Serialization;

import java.io.*;
import java.net.Socket;

public class Client {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Socket socket = new Socket("192.168.56.1", 3000);

        ObjectOutputStream objOut = new ObjectOutputStream(socket.getOutputStream());    // Client to Server

        Member ryu = new Member("Ryu", 40);
        objOut.writeObject(ryu);


        ObjectInputStream objIn = new ObjectInputStream(socket.getInputStream());
        Member a = (Member) objIn.readObject();
        Member b = (Member) objIn.readObject();
        System.out.println(a);
        System.out.println(b);

        socket.close();

    }
}
