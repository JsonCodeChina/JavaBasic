package JUC.queue;


import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class ShareData {


    private volatile boolean FLAG = true;
    private AtomicInteger num = new AtomicInteger();

    BlockingQueue<String> queue = null;

    public ShareData(BlockingQueue<String> queue) {
        this.queue = queue;
        System.out.println(queue.getClass().getName());
    }

    public void produce() throws InterruptedException {
        String data = null;
        boolean result;
        while(FLAG){
            data = num.incrementAndGet()+"";
            result = queue.offer(data,2l, TimeUnit.SECONDS);
            if(result){
                System.out.println(Thread.currentThread().getName()+"\t成功放入数据:"+data);
            }else{
                System.out.println(Thread.currentThread().getName()+"\t放入数据失败:"+data);
            }
            try{TimeUnit.SECONDS.sleep(1);} catch (InterruptedException e){e.printStackTrace();}
        }
    }

    public void consume() throws InterruptedException {
        String result = null;
        while(FLAG){
            result = queue.poll(2l,TimeUnit.SECONDS);
            if(result ==null ||result.equals("")){
                FLAG = false;
                System.out.println(Thread.currentThread().getName()+"\t没有取到数据,退出");
                return;
            }
            System.out.println(Thread.currentThread().getName()+"\t取到数据:"+result);
        }
    }


}

public class ProdCon_BlockQueueDemo {

    public static void main(String[] args) {

        ShareData shareData = new ShareData(new ArrayBlockingQueue<String>(3));

        new Thread(()->{
            System.out.println(Thread.currentThread().getName()+"生产线程启动");
            try {
                shareData.produce();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        },"a").start();

        new Thread(()->{
            System.out.println(Thread.currentThread().getName()+"消费线程启动");
            try {
                shareData.consume();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        },"b").start();

    }
}
