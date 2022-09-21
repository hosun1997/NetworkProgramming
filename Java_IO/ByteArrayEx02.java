package Java_IO;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Arrays;

public class ByteArrayEx02 {

    public static void main(String[] args) {
        byte[] temp = new byte[3];
        byte[] original = new byte[] {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
        byte[] copy = null;

        ByteArrayInputStream in = new ByteArrayInputStream(original);
        ByteArrayOutputStream out = new ByteArrayOutputStream();

        System.out.println("[Original Data]");
       // System.out.println(Arrays.toString(original));
        while(in.available() > 0) {
            try{
                int count = in.read(temp);
                System.out.println(count);
//                in.read(temp);
                System.out.println("[TEMP] " + Arrays.toString(temp));
                out.write(temp);
            }
            catch (IOException e) {
                e.printStackTrace();
            }
        }
        System.out.println("[Copy Data]");
        System.out.println(Arrays.toString(out.toByteArray()));
    }

}

//과제 : inputStream 문서 참고 : https://docs.oracle.com/javase/8/docs/api/java/io/InputStream.html
// 과제: 3바이트씩 읽으면 마지막 9가 남는데 이때 -1로 넘어가면서 [9,7,8]값이 출력된다. 이를 해결하라.
