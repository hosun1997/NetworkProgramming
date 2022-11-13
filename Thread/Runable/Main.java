package Thread.Runable;

public class Main {
    public static void main(String[] args) {
        Thread a1 = new Thread(new CountDown());
        Thread b1 = new Thread(new CountDown());
        Thread c1 = new Thread(new CountDown()); // 이름을 주지 않으면 자동으로 부여해서 사용


//        Thread a1 = new Thread(new CountDown(), "A1");
//        Thread b1 = new Thread(new CountDown(), "B1");
//        Thread c1 = new Thread(new CountDown(), "C1");
        a1.start();
        b1.start();
        c1.start(); // 동시에 작업이 실행된다! 각각 실행됨
    }
}
// https://hyeo-noo.tistory.com/293