package ten_five;

import java.io.*;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
//        saveObject();
//        loadObject();
        serialization();
        deSerializtion();
        serialization02();
        deSerializtion02();
    }

    public static void deSerializtion02() {

        try {
            FileInputStream fileIn = new FileInputStream("./MySerialObject02");
            ObjectInputStream objIn = new ObjectInputStream(fileIn);
            ArrayList<Person> savedList = (ArrayList<Person>) objIn.readObject();
            for(int i = 0; i< savedList.size(); i++) {
                System.out.println(savedList.get(i));
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }

    public static void deSerializtion() {

        try {
            FileInputStream fileIn = new FileInputStream("./MySerialObject");
            ObjectInputStream objIn = new ObjectInputStream(fileIn);
            Person a = (Person) objIn.readObject();
            System.out.println(a);
            Person b = (Person) objIn.readObject();
            System.out.println(b);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }

    public static void serialization02() {
        try {
            Person steve = new Person("steve", 100);
            Person tom = new Person("tom", 105);
            ArrayList<Person> persons = new ArrayList<>();
            persons.add(steve);
            persons.add(tom);
            FileOutputStream fileOut = new FileOutputStream("./MySerialObject02");
            ObjectOutputStream objOut = new ObjectOutputStream(fileOut);
            objOut.writeObject(persons);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    public static void serialization() {
        Person steve = new Person("steve", 100);
        Person tom = new Person("tom", 105);

        try {
            FileOutputStream fileOut = new FileOutputStream("./MySerialObject");
            ObjectOutputStream objOut = new ObjectOutputStream(fileOut);
            objOut.writeObject(steve);
            objOut.writeObject(tom);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static void loadObject() {
        try {
            FileInputStream fileIn = new FileInputStream("./MyObject.txt");
            DataInputStream dataIn = new DataInputStream(fileIn);
            int number = dataIn.readInt();
            String name = dataIn.readUTF();
            Person steve = new Person(name, number);

            number = dataIn.readInt();
            name = dataIn.readUTF();
            Person tom = new Person(name, number);

            System.out.println("Load Complete!");
            System.out.println(steve);
            System.out.println(tom);

//            System.out.println(dataIn.readInt());
//            System.out.println(dataIn.readUTF());
//            System.out.println(dataIn.readInt());
//            System.out.println(dataIn.readUTF());

//            byte[] data = fileIn.readNBytes(4);
//            System.out.println(Arrays.toString(data));
//            System.out.println(ByteBuffer.wrap(data).getInt());
//            byte[] name = new byte[10];
//            fileIn.read(name, 3, 7);
//            //            byte[] name = fileIn.readNBytes(4);
//            System.out.println(Arrays.toString(name));
//            System.out.println(new String(name));
//            System.out.println(Arrays.toString(fileIn.readNBytes(4)));
//            System.out.println(fileIn.readAllBytes().length);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    } // 헥사 파일에 저장한 것 불러오기

    public static void saveObject() {
        Person steve = new Person("Steve", 100);
        Person tom = new Person("Tom", 105);
//        System.out.println(steve);
//        System.out.println(tom);


        try {
            FileOutputStream fileOut = new FileOutputStream("./Myobject.txt");
            DataOutputStream dataOut = new DataOutputStream(fileOut);
            dataOut.writeUTF(steve.getName());
            dataOut.writeInt(steve.getNumber());                    // 읽어올 때 순서대로 읽어와야 하는 단점이 있다.
            dataOut.writeUTF(tom.getName());
            dataOut.writeInt(tom.getNumber());
            fileOut.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

}
