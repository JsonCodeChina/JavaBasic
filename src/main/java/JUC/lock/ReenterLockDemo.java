package JUC.lock;


import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class IPhone implements Runnable
{

    private Lock lock = new ReentrantLock();

    @Override
    public void run() {
            get();
    }

    public void get(){
//        lock.lock();
        lock.lock();
        try{
            System.out.println(Thread.currentThread().getName()+"\t invoke message");
            set();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            lock.unlock();
//            lock.unlock();
        }
    }

    public void set(){
        lock.lock();
        try{
            System.out.println(Thread.currentThread().getName()+"\t invoke ### email");
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            lock.unlock();
        }

    }

    public synchronized void sendMessage() throws Exception
    {
        System.out.println(Thread.currentThread().getName()+"\t invoke message");
        sendEmail();
    }

    public synchronized void sendEmail() throws Exception
    {
        System.out.println(Thread.currentThread().getName()+"\t invoke ### email");
    }


}


public class ReenterLockDemo {

    public static void main(String[] args) {
        IPhone iphone = new IPhone();

        new Thread(()->{
            try {
                iphone.sendMessage();
            } catch (Exception e) {
                e.printStackTrace();
            }
        },"a").start();

        new Thread(()->{
            try {
                iphone.sendMessage();
            } catch (Exception e) {
                e.printStackTrace();
            }
        },"b").start();

        try{TimeUnit.SECONDS.sleep(1);} catch (InterruptedException e){e.printStackTrace();}

        Thread t3 = new Thread(iphone,"t3");
        Thread t4 = new Thread(iphone,"t4");
        t3.start();
        t4.start();

    }
}
