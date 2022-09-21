package Java_IO;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class FilestreamEx01 {

    public static void main(String[] args) {

        File file = new File("./sample.txt");
        try {
            FileOutputStream out = new FileOutputStream("./sample.txt");
            for(int i = 65; i<=90; i++) {
                //System.out.println((char) i);
                out.write(i);
            }
            out.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }

}
