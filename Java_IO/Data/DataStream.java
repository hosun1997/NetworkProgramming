package Java_IO.Data;

import java.io.*;

public class DataStream {
    public static void main(String[] args) throws IOException {
        FileOutputStream fileOut = new FileOutputStream("Java_IO/Data/sample.txt");
        DataOutputStream dataOut = new DataOutputStream(fileOut);
        dataOut.writeInt(10);
        dataOut.writeFloat(22.2f);
        dataOut.writeBoolean(true);



        FileInputStream fileIn = new FileInputStream("Java_IO/Data/sample.txt");
        int data = 0;
        while((data = fileIn.read()) != -1) {
            char c = (char) data;
            System.out.print(c);
        }
        fileIn.close();
        System.out.println("\n");

        FileInputStream In = new FileInputStream("Java_IO/Data/sample.txt");
        DataInputStream dataIn = new DataInputStream(In);
        int intValue = dataIn.readInt();
        float floatValue = dataIn.readFloat();
        boolean booleanValue = dataIn.readBoolean();

        System.out.println(intValue);
        System.out.println(floatValue);
        System.out.println(booleanValue);


    }
}
