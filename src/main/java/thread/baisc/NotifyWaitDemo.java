package thread.baisc;


import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class ShareData{
    private int num = 0;

    private Lock lock = new ReentrantLock();
    private Condition condition = lock.newCondition();

    public void increNum() throws InterruptedException {
        lock.lock();
        try {
            while(num!=0){
                condition.await();
            }

            ++num;

            System.out.println(Thread.currentThread().getName()+"\t"+num);
            condition.signalAll();
        }finally {
            lock.unlock();
        }
    }

    public void decreNum() throws InterruptedException {
        lock.lock();
        try {
            while(num ==0){
                condition.await();
            }

            --num;

            System.out.println(Thread.currentThread().getName()+"\t"+num);
            condition.signalAll();
        }finally {
            lock.unlock();
        }
    }

//    public synchronized void increNum() throws InterruptedException {
//        //1 先判断  2 干活 3 通知
//        while(num!=0){
//            this.wait();
//        }
//
//        ++num;
//
//        System.out.println(Thread.currentThread().getName()+"\t"+num);
//        this.notifyAll();
//    }
//
//    public synchronized void decreNum() throws InterruptedException {
//        while(num==0){
//            this.wait();
//        }
//
//        --num;
//        System.out.println(Thread.currentThread().getName()+"\t"+num);
//        this.notifyAll();
//    }
}

/**
 * 两个线程 可以操作初始值为零的一个变量
 * 一个线程对变量加1 一个线程对变量减1
 */
public class NotifyWaitDemo {



    public static void main(String[] args) {

        ShareData sd = new ShareData();

        new Thread(()->{
            for (int i = 0; i < 10; i++) {
                try {
                    sd.increNum();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            },"a").start();

        new Thread(()->{
            for (int i = 0; i < 10; i++) {
                try {
                    sd.decreNum();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        },"b").start();

//        new Thread(()->{
//            for (int i = 0; i < 10; i++) {
//                try {
//                    sd.increNum();
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//            }
//        },"c").start();
//
//        new Thread(()->{
//            for (int i = 0; i < 10; i++) {
//                try {
//                    sd.decreNum();
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//            }
//        },"d").start();
    }


}
