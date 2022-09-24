package Java_IO;

import java.io.*;

public class S6_DataStream {
    public static void main(String[] args) {
        try {
            FileOutputStream fileOut = new FileOutputStream("./sample.dat");
            DataOutputStream dataOut = new DataOutputStream(fileOut);
            dataOut.writeInt(10);
            dataOut.writeFloat(22.2f);
            dataOut.writeBoolean(true);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
