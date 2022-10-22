package Java_IO.File;

import java.io.*;

// FileInputStream : 파일의 Data를 read
// FileOutputStream : 파일에 Data를 write

public class FileStream {
    public static void main(String[] args) throws IOException {

        // 파일 생성
        File file = new File("Java_IO/File/sample.txt");

        // 생성된 파일에 write하기.
        FileOutputStream out = new FileOutputStream("Java_IO/File/sample.txt");
        for (int i = 65; i <= 90; i++) {
            out.write(i);
        }
        out.close();

        // 파일 읽어오기
        FileInputStream in = new FileInputStream("Java_IO/File/sample.txt");
        int data = 0;

        while ((data = in.read()) != -1) {
            char c = (char) data;
            System.out.print(c);
        }
        in.close();

        // 파일 복사하기
        FileInputStream input = new FileInputStream("Java_IO/File/sample.txt");
        FileOutputStream output = new FileOutputStream("Java_IO/File/sampleCopy.txt");
        int currentByte = 0;
        while ((currentByte = input.read()) != -1) {
            output.write(currentByte);
        }
        input.close();
        output.flush();
        output.close();
    }
}
