package Thread.Basic;

public class ThreadEx01 extends Thread {

    @Override
    public void run() {
        for (int i = 10; i > -1; i--) {
            System.out.println("Thread name : " + Thread.currentThread().getName());
            System.out.println(i);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}
