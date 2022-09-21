package Java_IO;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.Arrays;

public class EndianTest {
    public static void main(String[] args) {
        int data = 0x01020304;

        ByteBuffer buffer = ByteBuffer.allocate(4);
        buffer.order(ByteOrder.BIG_ENDIAN);
        buffer.putInt(data);
        byte[] result = buffer.array();
        System.out.println(Arrays.toString(result));

    }
}
