package Java_IO.ByteArray;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.util.Arrays;

public class Ex_ByteArray3 {
    public static void main(String[] args) {

        byte[] original = new byte[] {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
        byte[] copy = null;

        ByteArrayInputStream in = new ByteArrayInputStream(original);
        ByteArrayOutputStream out = new ByteArrayOutputStream();

        int data = 0;
        while((data = in.read()) != -1) {
            out.write(data);
        }
        copy = out.toByteArray();
        System.out.println("[Original Data]");
        System.out.println(Arrays.toString(original));
        System.out.println("[Copy Data]");
        System.out.println(Arrays.toString(copy));


        System.out.println();
        System.out.println("개선하기");
        byte[] temp = new byte[original.length];
        in.read(temp, 0, temp.length);
        out.write(temp, 0, 5);
        copy = out.toByteArray();
        System.out.println("[Original Data]");
        System.out.println(Arrays.toString(original));
        System.out.println("[Copy Data]");
        System.out.println(Arrays.toString(copy));


    }
}
//과제 : inputStream 문서 참고 : https://docs.oracle.com/javase/8/docs/api/java/io/InputStream.html
// 과제: 3바이트씩 읽으면 마지막 9가 남는데 이때 -1로 넘어가면서 [9,7,8]값이 출력된다. 이를 해결하라.