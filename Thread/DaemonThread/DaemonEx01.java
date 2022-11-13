package Thread.DaemonThread;

public class DaemonEx01 {
    public static void main(String[] args) {
        try {
            Thread notiThread = new Thread(new Notification(), "Noti Daemon Thread");
            notiThread.setDaemon(true); // 스레드가 켜지기 전에 데몬으로 설정해야 한다.
            notiThread.start();
            System.out.println("Current Thread: " + Thread.currentThread().getName());
            System.out.println("Daemon? : " + notiThread.isDaemon());
            Thread.currentThread().getThreadGroup().list();
            Thread.sleep(10 * 1000);
            System.out.println("Main Thread End!!");

        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // 메인 스레드가 종료된다고 프로세스가 종료되는 것은 아니다!!! -> 데몬 스레드로 설정 : 메인 스레드가 종료되면 나머지 스레드도 종료된다!
        // 데몬 스레드를 사용하는 이유에 대해 다시 한 번 정리

    }
}
