package Thread.DaemonThread;

public class Notification implements Runnable{

    @Override
    public void run() {
        while (true) {
            int message = (int) (Math.random() * 10) + 1;
            try {
                System.out.println("Message Count: " + message);
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        } // ctrl + alt + t 단축키 개꿀
    }
}
