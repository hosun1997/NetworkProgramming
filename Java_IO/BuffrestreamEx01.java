package Java_IO;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.RandomAccessFile;

public class BuffrestreamEx01 {

    public static void main(String[] args) {
        try {
            createFile();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static void createFile() throws IOException {
        RandomAccessFile file = new RandomAccessFile("./MyFile", "rw");
        long fileSize = 1024 * 1024 * 3L;
        file.setLength(fileSize);
    }

}
