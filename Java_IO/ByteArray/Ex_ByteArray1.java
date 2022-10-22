package Java_IO.ByteArray;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Arrays;

public class Ex_ByteArray1 {
    public static void main(String[] args) throws IOException {
        byte[] inSrc = {0, 1, 2, 3, 4, 5};
        byte[] outSrc = null;
        byte[] temp = new byte[4];

        ByteArrayInputStream in = new ByteArrayInputStream(inSrc);
        ByteArrayOutputStream out = new ByteArrayOutputStream();

        while (in.available() > 0) {
            int len = in.read(temp);
            out.write(temp, 0 ,len);
        }

        outSrc = out.toByteArray();

        System.out.println("Input Source: " + Arrays.toString(inSrc));
        System.out.println("Temp: " + Arrays.toString(temp));
        System.out.println("Output Source: " + Arrays.toString(outSrc));
    }
}

// temp에 [4, 5, 2, 3]이 출력된 이유를 생각해 보자.
// -> temp에 남은 데이터를 초기화하고 사용하는 것이 아니라 Overwrite했기 때문이다.