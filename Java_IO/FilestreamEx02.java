package Java_IO;

import java.io.*;

public class FilestreamEx02 {

    public static void main(String[] args) {

        File file = new File("./sample.txt");
        try {
            FileInputStream in = new FileInputStream("./sample.txt");
            while(in.available() > 0) {
                System.out.print((char) in.read());
            }
            in.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
