package JUC.lock;


import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class ShareData{
    private int num = 1; //A 1 B 2 C 3
    private Lock lock = new ReentrantLock();
    private Condition c1 = lock.newCondition();
    private Condition c2 = lock.newCondition();
    private Condition c3 = lock.newCondition();

    public void print5(int totoalLoop) throws InterruptedException {
        lock.lock();
        try{
            //判断
            while(num!=1){
                c1.await();
            }
            //干活
            for (int i = 1 ; i <= 5 ; i++) {
                System.out.println(Thread.currentThread().getName()+"\t"+i+"\t totalLoop"+totoalLoop);
            }
            //通知
            num = 2;
            c2.signal();
        }finally {
            lock.unlock();
        }
    }

    public void print10(int totoalLoop) throws InterruptedException {
        lock.lock();
        try{
            //判断
            while(num!=2){
                c2.await();
            }
            //干活
            for (int i = 1 ; i <= 10 ; i++) {
                System.out.println(Thread.currentThread().getName()+"\t"+i+"\t totalLoop"+totoalLoop);
            }
            //通知
            num = 3;
            c3.signal();
        }finally {
            lock.unlock();
        }
    }

    public void print15(int totoalLoop) throws InterruptedException {
        lock.lock();
        try{
            //判断
            while(num!=3){
                c3.await();
            }
            //干活
            for (int i = 1 ; i <= 15 ; i++) {
                System.out.println(Thread.currentThread().getName()+"\t"+i+"\t totalLoop"+totoalLoop);
            }
            //通知
            num = 1;
            c1.signal();
        }finally {
            lock.unlock();
        }
    }

}



/**
 * @Description: 多线程之间按顺序调用，实现A->B->C				T1---T3
 * 三个线程启动，要求如下：
 *
 * AA打印5次，BB打印10次，CC打印15次
 * 接着
 * AA打印5次，BB打印10次，CC打印15次
 */
public class ThreadOrderAccess {

    public static void main(String[] args) {

        ShareData sd = new ShareData();

       new Thread(()->{
           for (int i = 1; i <=10 ; i++) {
               try {
                   sd.print5(i);
               } catch (InterruptedException e) {
                   e.printStackTrace();
               }
           }
           },"a").start();

        new Thread(()->{
            for (int i = 1; i <=10 ; i++) {
                try {
                    sd.print10(i);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        },"b").start();

        new Thread(()->{
            for (int i = 1; i <=10 ; i++) {
                try {
                    sd.print15(i);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        },"c").start();
    }
}
