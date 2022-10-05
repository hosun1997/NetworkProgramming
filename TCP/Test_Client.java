package TCP;


import java.io.*;
import java.net.Inet4Address;
import java.net.Socket;

public class Test_Client{
    // 서버로부터 이미지 파일을 하나 받아서 저장합니다.
    Socket client_socket;
    InputStream in;
    FileOutputStream result;

    public void clientStart() {
        try {
            // 서버로부터 이미지를 전송받은 후 파일로 저장합니다.

            File file = new File("C:/Users/user/Downloads/copy_photo.jpg");

            client_socket = new Socket(Inet4Address.getByName("localhost"), 3000); // Server의 Server Socket에 요청
            result = new FileOutputStream(file);
            in = client_socket.getInputStream();

            System.out.println("Downloading the file...");
            byte[] tmp = new byte[1024];
            int length = 0;
            while ((length=in.read(tmp))!=-1) {
                result.write(tmp,0,length);
            }
            System.out.println("Finish the Job!");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        Test_Client test_client= new Test_Client();
        test_client.clientStart();
        try {
            test_client.stopClient();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void stopClient() throws IOException {
        in.close();
        result.close();
        client_socket.close();
    }
}
