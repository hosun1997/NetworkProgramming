package Java_IO;

import java.io.*;

// FileInputStream : 파일의 Data를 read
// FileOutputStream : 파일에 Data를 write

public class S2_FileStream {
    public static void main(String[] args) {

        // 파일 생성
        File file = new File("./sample.txt");

        // 해당 파일에 write하기.
        try {
            FileOutputStream out = new FileOutputStream("./sample.txt");
            for (int i = 65; i <= 90; i++) {
                //System.out.println((char) i);
                out.write(i);
            }
            out.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


        // 해당 파일 read하기
        try {
            FileInputStream in = new FileInputStream("./sample.txt");
            int data = 0;

            while ((data = in.read()) != -1) {
                char c = (char) data;
                System.out.print(c);
            }
            in.close();

        } catch (IOException e) {
            e.printStackTrace();
        }

        // 파일 복사하기
        try {
            FileInputStream input = new FileInputStream("./sample.txt");
            FileOutputStream output = new FileOutputStream("./samplecopy.txt");
            int currentByte = 0;
            while((currentByte= input.read()) != -1) {
                output.write(currentByte);
            }
            input.close();
            output.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
