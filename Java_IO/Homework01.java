package Java_IO;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Arrays;

public class Homework01 {
    public static void main(String[] args) {
        byte[] original = new byte[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
        byte[] copy;
        byte[] temp = new byte[4];

        ByteArrayInputStream in = new ByteArrayInputStream(original);
        ByteArrayOutputStream out = new ByteArrayOutputStream();

        System.out.println("[Original Data]");
        System.out.println(Arrays.toString(original));

        int len;
        try {
            while ((len=in.read(temp)) > 0) {
                out.write(temp, 0, len);
                System.out.println("[Temp Data]");
                System.out.println(Arrays.toString(temp));
                copy = out.toByteArray();
                printArrays(temp, copy);
            }
        } catch (IOException e) {
// TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public static void printArrays(byte[] temp, byte[] copy) {
        System.out.println("[temp Data]");
        System.out.println(Arrays.toString(temp));
        System.out.println("[Copy Data]");
        System.out.println(Arrays.toString(copy));
    }

}

// 이런 현상이 나타나는 이유 : temp에 남아있던것을 지우고 쓰는게아니라 덮어쓰기(overwrite)때문이다.
// 길이를 지정하지 않고 write를 하면 overwrite하기 떄문에 write에 출력될 길이를 지정하면 해결할 수 있다.
// read(byte[] b)는 파라미터로 주어진 byte 배열 크기만큼 데이터를 읽고 총 몇 byte를 읽었는지 반환한다. 데이터를 읽다가 모두 읽으면, 그 만큼의 크기를 반환하고 시작부터 읽을게 없으면 -1을 반환한다.


// 문제점 : temp에 남아있는 Data를 초기화하고 사용하는 것이 아니다. 기존 temp에 있던 Data 위에 덮어쓰기(overwrite)하기 때문이다.
// 해결방안 : write 함수에 길이를 지정해준다. 길이 값을 저장하는 변수를 선언하고 write에 해당 변수로 length를 지정하여 copy의 출력길이를 지정해 주었다. (4byte, 4byte, 2byte)