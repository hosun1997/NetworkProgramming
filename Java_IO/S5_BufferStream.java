package Java_IO;

import java.io.BufferedOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class S5_BufferStream {

    public static void main(String[] args) {

        try {
            FileOutputStream fileout = new FileOutputStream("./sample.txt");
            BufferedOutputStream bufferOut = new BufferedOutputStream(fileout, 10);
            for(int i=0; i<= 90; i++) {
                bufferOut.write(i);
            }
//            fileout.close();       -> BufferedOutputStream close()를 호출해 주여야만 Buffer에 남아있는 모든 Data가 출력된다. FilterOutputStream의 close()를 overriding 없이 그대로 상속받는다.
            bufferOut.close();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

}
