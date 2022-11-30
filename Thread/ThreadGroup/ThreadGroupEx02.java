package Thread.ThreadGroup;

public class ThreadGroupEx02 {

    public static void main(String[] args) {
        ThreadGroup timer = new ThreadGroup("Timer");
//        System.out.println(timer.getMaxPriority());
        ThreadGroup suwon = new ThreadGroup(timer, "Suwon Timer");
        suwon.setMaxPriority(1);
        ThreadGroup jeju = new ThreadGroup(timer, "Jeju Timer");  // 부모 스레드의 maxpriority가 10이면 자식 스레드도 그 영향을 받는다.
        jeju.setMaxPriority(10);

        Thread suwonCountDown = new Thread(suwon, new GroupCountDown(), "Suwon CountDown");
        Thread jejuCountDown = new Thread(jeju, new GroupCountDown(), "Jeju CountDown");

        suwonCountDown.start();
//        try {
//            suwonCountDown.join();
//        } catch (InterruptedException e) {
//            throw new RuntimeException(e);
//        } // Join 으로 원하는 대로 출력 -> 근데 이러면 스레드 쓰는 의미가 없음.
        jejuCountDown.start();

    }

}
