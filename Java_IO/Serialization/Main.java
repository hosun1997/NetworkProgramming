package Java_IO.Serialization;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.Base64;

public class Main {
    public static void main(String[] args) {

        File file = new File("Serialize.txt");

        Member member = new Member("Steve", "Steve@naver.com", 25);
        byte[] serializedMember = new byte[0];
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        try {
            ObjectOutputStream oos =  new ObjectOutputStream(baos);
            oos.writeObject(member); // serializeMember = 직렬화된 맴버 객체
            serializedMember = baos.toByteArray();

        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(Base64.getEncoder().encodeToString(serializedMember)); // 바이트 배열로 생성된 직렬화데이터를 base64로 변환

    }

}

//  <직렬화 사용 이유>
//  생성한 객체를 파일로 저장할 일이 있을 수도 있습니다.
//  저장한 객체를 읽을 일이 생길 수도 있습니다.
//  다른 서버에서 생성한 객체를 받을 일도 생길 수 있습니다.
//  -> 우리가 만든 클래스가 파일에 읽거나 쓸 수 있도록 하거나, 다른 서버로 보내거나 받을 수 있도록 하려면 반드시 이 인터페이스를 구현해야 합니다.


