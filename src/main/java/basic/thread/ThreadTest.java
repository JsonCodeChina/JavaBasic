package basic.thread;

public class ThreadTest {

    public static void attack(){
        System.out.println("fight");
        System.out.println("current thread is:"+Thread.currentThread().getName());
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("awake");
    }

    public static void main(String[] args) throws InterruptedException {
        Thread t = new Thread(){
            public void run(){
                attack();
            }
        };
        System.out.println("current thread is:"+Thread.currentThread().getName());
        t.start();
        t.join();
        t.start();
        System.out.println("hhh");

    }
}
