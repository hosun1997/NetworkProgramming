import java.io.FileInputStream;
import java.io.FileOutputStream;

public class filetest {
    public static void main(String[] args) {
        // pc의 파일 내용 읽어오기
        // 바이트 단위로 복사해서 붙여넣기

        try {
            FileInputStream in = new FileInputStream("/Users/user/Downloads/emblem_01_old1.png");
            FileOutputStream out = new FileOutputStream("/Users/user/Downloads/emblem_01_old2.png");
            int data = 0;
            System.out.println("File Copy Start");
            // 파일이 크면 while문에서 블록되면서 막힘.
            while ((data = in.read()) != -1) {
                System.out.println(data);
                out.write(data);
            }
            System.out.println("File Copy End");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
