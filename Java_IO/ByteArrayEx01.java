package Java_IO;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.util.Arrays;

public class ByteArrayEx01 {

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

    }

}
