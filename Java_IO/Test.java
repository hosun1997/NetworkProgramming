package Java_IO;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Arrays;

public class Test {
    public static void main(String[] args) {
        byte[] src = {1,2,3,4,5,6,7,8,9,10};
        byte[] dst;
        byte[] temp = new byte[4];

        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(src);
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();

        try{
            while(byteArrayInputStream.read(temp) > 0){
                byteArrayOutputStream.write(temp);
            }
        } catch (IOException e){
            e.printStackTrace();
        }

//        int len;
//        try{
//            while((len = byteArrayInputStream.read(temp)) > 0){
//                byteArrayOutputStream.write(temp, 0, len);
//            }
//        } catch (IOException e){
//            e.printStackTrace();
//        }


        dst = byteArrayOutputStream.toByteArray();

        System.out.println(Arrays.toString(dst));
    }
}
