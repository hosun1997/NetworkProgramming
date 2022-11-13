package Thread.Basic;

public class Main {
    public static void main(String[] args) {
        /* [예제1] */
//        ThreadEx01 threadEx01 = new ThreadEx01();
//        threadEx01.run();
//        threadEx01.start();

        /* 아래[예제3]과 비교 */
//        countDown("A1");
//        countDown("B1");
//        countDown("C1");

        /* [예제3] */
        ThreadEx03 a1 = new ThreadEx03("A1");
        ThreadEx03 b1 = new ThreadEx03("B1");
        ThreadEx03 c1 = new ThreadEx03("C1");

        a1.start();
        b1.start();
        c1.start();

    }

    public static void countDown(String name) {
        for(int i = 10; i > -1; i--) {
            System.out.println(name + ": " + i);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}

// https://kim-jong-hyun.tistory.com/101 참고
