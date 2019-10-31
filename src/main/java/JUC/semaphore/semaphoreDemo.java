package JUC.semaphore;

import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

public class semaphoreDemo {


    public static void main(String[] args) {

        Semaphore semaphore = new Semaphore(3);
        for(int i = 1; i <= 10 ;i++)
        {
            new Thread(()->{
                try {
                    semaphore.acquire();
                    System.out.println(Thread.currentThread().getName()+"\t 抢到车位");
                    try{TimeUnit.SECONDS.sleep(1);} catch (InterruptedException e){e.printStackTrace();}
                    System.out.println(Thread.currentThread().getName()+"\t 离开车位");

                } catch (InterruptedException e) {
                    e.printStackTrace();
                }finally {
                    semaphore.release();
                }

            },String.valueOf(i)).start();
        }
    }
}
