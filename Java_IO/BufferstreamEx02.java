package Java_IO;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Date;

public class BufferstreamEx02 {

    public static void main(String[] args) {

        try {
            FileInputStream in = new FileInputStream("./MyFile");
            BufferedInputStream bufin = new BufferedInputStream(in);
            System.out.println("File Read Start!!");
            System.out.println(new Date());
            int data = 0;
            while((data = in.read()) != -1) {
//                System.out.println(data);
            }
            System.out.println("File Read Finish!!");
            System.out.println(new Date());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
