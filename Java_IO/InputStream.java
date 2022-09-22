package Java_IO;

import java.io.*;

public class InputStream {

    public int read() throws IOException {
        return 0;
    }

    public static void main(String[] args) {
        System.out.println("<Input stream의 Method>");
        System.out.println("1. InputStream은 데이터를 읽어야 한다.");

        /*1byte를 읽어 그 값을 int로 바꿔 반환하거나 더 이상 읽을 수 없는 경우는 -1을 반환한다.*/

        System.out.println("InputStream.read()");

        byte[] data1 = new byte[]{1, 3};
        ByteArrayInputStream inputStream1 = new ByteArrayInputStream(data1);

        System.out.println("read(): " + inputStream1.read()); // 바이트 하나를 읽었으니, 1을 읽었고 1이 출력된다.
        System.out.println("read(): " + inputStream1.read()); // 바이트 하나를 추가로 읽었으니, 2를 읽었고 2가 출력된다.
        System.out.println("read(): " + inputStream1.read()); //  더 이상 읽을 바이트가 없으니 -1이 출력된다.

        /*
        파라미터로 주어진 byte 배열 크기만큼 데이터를 읽고 총 몇 byte를 읽었는지 반환한다.
        데이터를 일다가 모두 읽으면, 그 만큼의 크기를 반환하고 시작부터 읽을게 없으면 -1을 반환한다.
         */

        System.out.println("InputStream.read(byte[] b)");
        byte[] data2 = new byte[]{10, 20, 30, 40, 50};
        ByteArrayInputStream inputStream2 = new ByteArrayInputStream(data2);

        byte[] buffer = new byte[3];
        try {
            System.out.println("read(byte[] b): " + inputStream2.read(buffer)); // 바이트 3개(10,20,30)을 읽어 buffer에 넘겨주고 3을 출력한다.
            System.out.println("read(byte[] b): " + inputStream2.read(buffer)); // 바이트 2개(40,50)을 읽어 buffer에 넘겨주고 2를 출력한다.
            System.out.println("read(byte[] b): " + inputStream2.read(buffer)); //  시작부터 읽을 바이트가 없으니 -1을 출력한다.
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("InputStream.read(byte[] b, int off, int len)");
        byte[] data3 = new byte[]{10, 20, 30, 40, 50, 60};

        ByteArrayInputStream inputStream3 = new ByteArrayInputStream(data3);
        int num = inputStream3.read(buffer, 1, 2);
        System.out.println("Bytes read: " + num);
        for(int i=0; i < buffer.length; i++) {
            int nr = (int) buffer[i];
            if (buffer[i] == 0) {
                System.out.println("null");
            } else {
                System.out.println(nr + " ");
            }

        }

    }
}


// Reader - InputStream : Stream을 통해 데이터를 읽어온다.
