package Thread.Basic;

public class ThreadEx03 extends Thread{

    public ThreadEx03(String name) {
        super(name);
    }

    @Override
    public void run() {
        for(int i = 10; i > -1; i--) {
            System.out.println(getName() + ": " + i);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
