package Java_IO.File;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileCopy {
    public static void main(String[] args) {
        try {
            FileInputStream in1 = new FileInputStream("Java_IO/File/copy1.txt");
            FileInputStream in2 = new FileInputStream("Java_IO/File/copy2.txt");
            FileOutputStream out = new FileOutputStream("Java_IO/File/copyResult.txt");
            int currentByte1 = 0;
            int currentByte2 = 0;
            while((currentByte2 = in2.read()) != -1) {
                while((currentByte1 = in1.read()) != -1) {
                    out.write(currentByte1);
                }
                out.write(currentByte2);
            }
            in1.close();
            in2.close();
            out.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
