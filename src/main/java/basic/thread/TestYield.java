package basic.thread;

public class TestYield {


    public static void main(String[] args) {
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                for(int i = 0; i<10;i++){
                    System.out.println(Thread.currentThread().getName()+i);
                    if(i==5){
                        Thread.yield();
                    }
                }
            }
        };

        Thread t1 = new Thread(runnable,"a");
        Thread t2 = new Thread(runnable,"b");
        t1.start();
        t2.start();
    }

}
