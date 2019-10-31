package JUC.callable;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;

class MyThread implements Callable<Integer>
{

    @Override
    public Integer call() throws Exception {
        System.out.println(Thread.currentThread().getName()+"\t***** come in callable");
        try{
            TimeUnit.SECONDS.sleep(2);} catch (InterruptedException e){e.printStackTrace();}
        return 1024;
    }
}


public class CallableDemo {

    public static void main(String[] args) throws ExecutionException, InterruptedException {

        FutureTask<Integer> futureTask = new FutureTask<>(new MyThread());
        FutureTask<Integer> futureTask2 = new FutureTask<>(new MyThread());
        new Thread(futureTask,"aaa").start();

        new Thread(futureTask,"bbb").start();

//        Thread t2 = new Thread(futureTask,"bbb").start();




        int result01 = 100;
//        while(!futureTask.isDone()){
//
//        }

        System.out.println(Thread.currentThread().getName()+"\t main thread ***");
        //要求获得callable线程的计算结果，如果没有计算完成就去要求，会导致阻塞
        int result02 = futureTask.get();
        System.out.println(result01+result02);




    }
}
