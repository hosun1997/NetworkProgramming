package Java_IO.Endian;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.Arrays;

public class EndianTest {
    private static final int BIG_ENDIAN = 0;
    private static final int LITTLE_ENDIAN = 1;

    public static void main(String[] args) {
        System.out.println("System Default Endian: " + ByteOrder.nativeOrder());
        int value = 0x01020304;
        endian(value, BIG_ENDIAN);
        endian(value, LITTLE_ENDIAN);
    }

    public static void endian(int value, int endian) {
        ByteBuffer buffer = ByteBuffer.allocate(Integer.BYTES);
        if (endian == BIG_ENDIAN) {
            buffer.order(ByteOrder.BIG_ENDIAN);
        } else if (endian == LITTLE_ENDIAN) {
            buffer.order(ByteOrder.LITTLE_ENDIAN);
        } else {
            throw new IllegalArgumentException("Endian을 확인해주세요!");
        }
        buffer.putInt(value);
        System.out.println(Arrays.toString(buffer.array()));
    }

}
