package JUC.queue;


import java.util.concurrent.BlockingQueue;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.TimeUnit;

public class SynchronousQueueDemo {

    public static void main(String[] args) {
        BlockingQueue queue = new SynchronousQueue();

        new Thread(()->{
            try {
                System.out.println(Thread.currentThread().getName()+"\t put value 1");
                queue.put(1);
                System.out.println(Thread.currentThread().getName()+"\t put value 2");
                queue.put(2);
                System.out.println(Thread.currentThread().getName()+"\t put value 3");
                queue.put(3);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        },"a").start();

        new Thread(()->{
            try {
                try{TimeUnit.SECONDS.sleep(1);} catch (InterruptedException e){e.printStackTrace();}
                System.out.println(Thread.currentThread().getName()+"\t take value 1");
                queue.take();
                try{TimeUnit.SECONDS.sleep(1);} catch (InterruptedException e){e.printStackTrace();}
                System.out.println(Thread.currentThread().getName()+"\t take value 2");
                queue.take();
                try{TimeUnit.SECONDS.sleep(1);} catch (InterruptedException e){e.printStackTrace();}
                System.out.println(Thread.currentThread().getName()+"\t take value 3");
                queue.take();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        },"b").start();



//        for(int i = 1; i <= 5 ;i++)
//        {
//            final int tempInt = i;
//            new Thread(()->{
//                System.out.println(Thread.currentThread().getName()+"\t input value");
//                queue.offer(tempInt);
//            },String.valueOf(i)).start();
//        }
//
//        try{
//            TimeUnit.SECONDS.sleep(1);} catch (InterruptedException e){e.printStackTrace();}
//
//        for(int i = 1; i <= 5 ;i++)
//        {
//            new Thread(()->{
//                System.out.println(Thread.currentThread().getName()+"\t get value");
//                try {
//                    queue.take();
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//            },String.valueOf(i)).start();
//        }

    }
}
