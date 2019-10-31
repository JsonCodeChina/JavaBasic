package thread.cast;


import java.util.LinkedList;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class Bucket{

    private LinkedList<String> bucket = new LinkedList<>();
    private Lock lock = new ReentrantLock();
    private Condition putCondition = lock.newCondition();
    private Condition takeConition = lock.newCondition();

    public void put(){
        lock.lock();
        try{

            while(bucket.size()>=10){
                putCondition.await();
            }
            bucket.add("fruit");
            System.out.println("农名伯伯 现在放入一个水果，篮子里有："+bucket.size()+"个水果");
            takeConition.signal();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            lock.unlock();
        }

    }

    public void take(){
        lock.lock();
        try{
            while(bucket.size()<=0){
                takeConition.await();
            }
            bucket.remove("fruit");
            System.out.println("小孩子 现在吃一个水果，篮子里有："+bucket.size()+"个水果");
            putCondition.signal();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }


}


//实现农夫采摘水果放到筐里，小孩从筐里拿水果吃，农夫是一个线程，小孩是一个线程，水果筐放满了，农夫停；水果筐空了，小孩停
public class Demo3 {
    public static void main(String[] args) {
        Bucket bucket = new Bucket();

        new Thread(()->{
                while (true){

                    bucket.put();
                }
            },"a").start();

        try{TimeUnit.SECONDS.sleep(1);} catch (InterruptedException e){e.printStackTrace();}

        new Thread(()->{
            while (true){

                bucket.take();
            }
        },"b").start();


    }

}
