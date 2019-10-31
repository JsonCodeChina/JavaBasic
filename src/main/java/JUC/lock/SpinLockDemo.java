package JUC.lock;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

public class SpinLockDemo {

    AtomicReference<Thread> atomicReference =
            new AtomicReference<>();

    public void myLock(){
        Thread thread = Thread.currentThread();
        System.out.println(Thread.currentThread().getName()+"\t come in");
        while(!atomicReference.compareAndSet(null,thread)){

        }
    }

    public void myUnLock(){
        Thread thread = Thread.currentThread();
        atomicReference.compareAndSet(thread,null);
        System.out.println(Thread.currentThread().getName()+"\t come out");

    }

    public static void main(String[] args) {

        SpinLockDemo spinLockDemo = new SpinLockDemo();

        new Thread(()->{
                spinLockDemo.myLock();
                     System.out.println(Thread.currentThread().getName()+"\t executing...");
                     try{TimeUnit.SECONDS.sleep(5);} catch (InterruptedException e){e.printStackTrace();}
                spinLockDemo.myUnLock();
            },"a").start();

        try{TimeUnit.SECONDS.sleep(1);} catch (InterruptedException e){e.printStackTrace();}

        new Thread(()->{
            spinLockDemo.myLock();
            System.out.println(Thread.currentThread().getName()+"\t executing...");
            try{TimeUnit.SECONDS.sleep(1);} catch (InterruptedException e){e.printStackTrace();}
            spinLockDemo.myUnLock();
        },"b").start();

    }
}
