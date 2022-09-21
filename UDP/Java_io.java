import java.io.ByteArrayOutputStream;
import java.io.IOException;

public class Java_io {
public static void main(String[] args) throws IOException {
    ByteArrayOutputStream out = new ByteArrayOutputStream();
    System.out.println("Before: "+out.size());
    // for(int i = 65; i < 91; i++) {
    //     out.write(i);
    // } // 효율적이지 못한 코드
    byte[] code = new byte[50];
    for(int i = 65; i<91; i++) {
        code[i-65] = (byte) i;
    }
    // out.write(code); //상속받은 부모의 코드 -> 속도가 빠르지 않다.
    out.write(code, 0, code.length);
    System.out.println("After: "+out.size());
    System.out.println(out.toString());
    }
}
