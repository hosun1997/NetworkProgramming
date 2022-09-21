package Java_IO;

import java.io.CharArrayReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class FilestreamEx03 {
    public static void main(String[] args) {

        try {
            CharArrayReader in2 = new CharArrayReader("Asda".toCharArray());
            System.out.println((char) in2.read());

            FileReader in = new FileReader("./sample.txt");
            int data = 0;
            while((data = in.read()) != -1) {
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }


}
