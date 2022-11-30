package Thread.ThreadGroup;

public class ThreadGroupEx01 {

    public static void main(String[] args) {
        Thread thread = Thread.currentThread();
        System.out.println(thread.getName());
        System.out.println();

        System.out.println("Thread Group: " + thread.getThreadGroup());
        System.out.println("Thread Group Parent: " + thread.getThreadGroup().getParent());
        System.out.println("Thread Group Priority : " + thread.getThreadGroup().getMaxPriority()); // 최소는 없다.
        System.out.println();

        thread.getThreadGroup().list();
    }

}
