package Thread.lifeCycle.sleep;

class PlusPrintOperation implements Runnable {

    @Override
    public void run() {
        for (int i = 0; i < 200; i++) {
            System.out.println("+");
        }
        System.out.println("PlusPrintOperation Thread 종료");
    }
}
