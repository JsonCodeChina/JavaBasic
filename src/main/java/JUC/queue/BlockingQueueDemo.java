package JUC.queue;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;

public class BlockingQueueDemo {

    public static void main(String[] args) throws InterruptedException {
        BlockingQueue queue = new ArrayBlockingQueue(3);

//        System.out.println(queue.add("1"));
//        System.out.println(queue.add("2"));
//        System.out.println(queue.add("3"));
//
//        System.out.println(queue.element());
//
//        System.out.println(queue.remove());
//        System.out.println(queue.remove());
//        System.out.println(queue.remove());

//        System.out.println(queue.offer("1"));
//        System.out.println(queue.offer("2"));
//        System.out.println(queue.offer("3"));
//        System.out.println(queue.offer("4"));

//        System.out.println(queue.peek());

//        System.out.println(queue.poll());
//        System.out.println(queue.poll());
//        System.out.println(queue.poll());
//        System.out.println(queue.poll());

//        queue.put("1");
//        queue.put("2");
//        queue.put("3");
//        queue.put("4");
//
//        System.out.println(queue.take());
//        System.out.println(queue.take());
//        System.out.println(queue.take());



        new Thread(()->{
            try {
                System.out.println(Thread.currentThread().getName()+"\t 放入队列");
                System.out.println(queue.offer("1", 1L, TimeUnit.SECONDS));
                System.out.println(queue.offer("2", 1L, TimeUnit.SECONDS));
                System.out.println(queue.offer("3", 1L, TimeUnit.SECONDS));
                System.out.println(queue.offer("4", 5L, TimeUnit.SECONDS));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            },"a").start();

        try{TimeUnit.SECONDS.sleep(1);} catch (InterruptedException e){e.printStackTrace();}
        new Thread(()->{
            System.out.println(Thread.currentThread().getName()+"\t 从队列中取元素");
            System.out.println(queue.poll());
            },"b").start();



    }

}
