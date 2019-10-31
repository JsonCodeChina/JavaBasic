package JUC.demoFromCSDN;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.TimeUnit;

public class Demo {

    public static void main(String[] args) {
        try {
            Thread threadTest = new Thread(){
                public void run(){
                    System.out.println("执行线程中方法");
                    try {
                        Thread.sleep(2000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            };
            threadTest.start();
            synchronized(threadTest){
                threadTest.wait();      //当线程终止的时候，会调用线程自身的notifyAll()方法
            }
            System.out.println("执行到了这里");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
