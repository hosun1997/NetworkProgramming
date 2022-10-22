package Java_IO.Buffered;

import java.io.*;

public class BufferStream {

    public static void main(String[] args) throws IOException {

        FileOutputStream fileOut = new FileOutputStream("Java_IO/Buffered/sample.txt");
        BufferedOutputStream bufferOut = new BufferedOutputStream(fileOut, 10);
        for(int i=65; i<= 90; i++) {
            bufferOut.write(i);
        }
        bufferOut.close(); // -> BufferedOutputStream close()를 호출해 주여야만 Buffer에 남아있는 모든 Data가 출력된다. FilterOutputStream의 close()를 overriding 없이 그대로 상속받는다.

    }

}
