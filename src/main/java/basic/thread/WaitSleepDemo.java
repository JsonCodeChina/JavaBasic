package basic.thread;

public class WaitSleepDemo {

    public void ss(){
        synchronized(this){

        }
    }


    public static void main(String[] args) {
        final Object lock = new Object();
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("thread a is waiting to get lock");
                synchronized (lock){
                    try {
                        System.out.println("thread a get lock");
                        Thread.sleep(20);
                        System.out.println("thread a do wait method");
                        lock.wait();
                        System.out.println("thread a is done");
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                }
            }
        }).start();


        try {
            Thread.sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("thread B is waiting to get lock");
                synchronized (lock){

                    try {
                        System.out.println("thread B get lock");
                        System.out.println("thread B is sleeping");
                        Thread.sleep(10);
                        System.out.println("thread b is done");
                        lock.notify();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                }
            }
        }).start();




    }
}
