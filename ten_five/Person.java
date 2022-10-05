package ten_five;

import java.io.Serializable;

public class Person extends Parent implements Serializable {
    public static String type = "A";
    public static String name;
    public static int number;

    public Person(String name, int number) {
        super("부모님...");
        this.name = name;
        this.number = number;
    }

    public static String getType() {
        return type;
    }

    public static void setType(String type) {
        Person.type = type;
    }

    public static String getName() {
        return name;
    }

    public static void setName(String name) {
        Person.name = name;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    @Override
    public String toString() {
        return "Person(" +
                "name=" + name + '\'' +
                ", number" + number +
                ')';
    }

    public void Hello(String person) {
        System.out.println("Hello" + person);
        System.out.println("I am" + name);
    }

}


// google stying