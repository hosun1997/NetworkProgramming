package Java_IO.Serialization;

import java.io.*;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Base64;

public class Main {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
//        saveObject();
//        loadObject();
//        serialization();
//        deserialization();
        serialization2();
    }

    public static void saveObject() {
        Member steve = new Member("Steve", 25);
        Member james = new Member("James", 30);
//        System.out.println(steve);
//        System.out.println(james);

        try {
            FileOutputStream fileOut = new FileOutputStream("./saveObject.txt");
            DataOutputStream dataOut = new DataOutputStream(fileOut);
            dataOut.writeUTF(steve.getName());
            dataOut.writeInt(steve.getAge());
            dataOut.writeUTF(james.getName());
            dataOut.writeInt(james.getAge());
            fileOut.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        // txt 파일을 읽었는데 이상한 값들이 있다. 왜 그럴까?

    }

    public static void loadObject() throws IOException {
        FileInputStream fileIn = new FileInputStream("./saveObject.txt");
        DataInputStream dataIn = new DataInputStream(fileIn);

        byte[] data = fileIn.readNBytes(4);
        System.out.println(Arrays.toString(data));
        System.out.println(ByteBuffer.wrap(data).getInt());
//        byte[] name = new byte[10];
//        fileIn.read(name, 3, 7);
        byte[] name = fileIn.readNBytes(4);
        fileIn.read(name, 0, 3);
        System.out.println(Arrays.toString(name));
        System.out.println(new String(name));
        System.out.println(Arrays.toString(fileIn.readNBytes(4)));
        System.out.println(fileIn.readAllBytes().length);


        /* 2번
        String name = dataIn.readUTF();
        int age = dataIn.readInt();
        Member steve = new Member(name, age);

        name = dataIn.readUTF();
        age = dataIn.readInt();
        Member james = new Member(name, age);

        System.out.println("Load Complete!!!");
        System.out.println(steve);
        System.out.println(james);
         */

        /* 1번
        System.out.println(dataIn.readUTF());
        System.out.println(dataIn.readInt());
        System.out.println(dataIn.readUTF());
        System.out.println(dataIn.readInt());
        */


    }

    public static void serialization() {
        Member steve = new Member("Steve", 25);
        Member james = new Member("James", 30);

        try {
            FileOutputStream fileOut = new FileOutputStream("./SerialObject.txt");
            ObjectOutputStream objOut = new ObjectOutputStream(fileOut);
            objOut.writeObject(steve);
            objOut.writeObject(james);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void deserialization() throws IOException, ClassNotFoundException {
        FileInputStream fileIn = new FileInputStream("./SerialObject.txt");
        ObjectInputStream objIn = new ObjectInputStream(fileIn);
        Member a = (Member) objIn.readObject();
        System.out.println(a);
        Member b = (Member) objIn.readObject();
        System.out.println(b);
    }

    public static void serialization2() throws IOException {
        Member steve = new Member("steve", 40);
        Member james = new Member("james", 35);
        ArrayList<Member> members = new ArrayList<>();
        members.add(steve);
        members.add(james);
        FileOutputStream fileOut = new FileOutputStream("./SerialObject2.txt");
        ObjectOutputStream objOut = new ObjectOutputStream(fileOut);
        objOut.writeObject(members);

    }

}


//  <직렬화 사용 이유>
//  생성한 객체를 파일로 저장할 일이 있을 수도 있습니다.
//  저장한 객체를 읽을 일이 생길 수도 있습니다.
//  다른 서버에서 생성한 객체를 받을 일도 생길 수 있습니다.
//  -> 우리가 만든 클래스가 파일에 읽거나 쓸 수 있도록 하거나, 다른 서버로 보내거나 받을 수 있도록 하려면 반드시 이 인터페이스를 구현해야 합니다.


