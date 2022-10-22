package Java_IO.File;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class FileReaderWriter {
    public static void main(String[] args) throws IOException {

        FileReader fileReader = new FileReader("Java_IO/File/file.txt");
        FileInputStream fileInputStream = new FileInputStream("Java_IO/File/file.txt");

        System.out.println("<FileInputStream으로 읽었을 때>");
        int data = 0;
        while((data = fileInputStream.read()) != -1) {
            System.out.print((char) data);
        }

        System.out.println("\n\n<FileReader로 읽었을 때>");
        while((data = fileReader.read()) != -1) {
            System.out.print((char) data);
        }

    }
}
