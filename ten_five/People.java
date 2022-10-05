package ten_five;

public class People {
    public static String name;
    public static int number;


    public People(String name, int number) {
        this.name = name;
        this.number = number;

    }

    @Override
    public String toString() {
        return "Person(" +
                "name=" + name + '\'' +
                ", number" + number +
                ')';
    }



}
