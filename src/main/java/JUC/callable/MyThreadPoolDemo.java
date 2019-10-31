package JUC.callable;

import java.util.concurrent.*;

public class MyThreadPoolDemo {

    public static void main(String[] args) {
        ExecutorService executorService =
                new ThreadPoolExecutor(
                        2,5,
                        1L,TimeUnit.SECONDS,
                        new LinkedBlockingDeque<Runnable>(3),
                        Executors.defaultThreadFactory(),
                        new ThreadPoolExecutor.DiscardPolicy());

        try {
            for (int i = 1 ; i <= 10 ; i++) {
                executorService.execute(()->{
                    System.out.println(Thread.currentThread().getName()+"\t 办理业务");
                });
            }

        }catch(Exception e){
            e.printStackTrace();
        }finally {
            executorService.shutdown();
        }

    }

    private static void typeOFThreadPool() {
        System.out.println(Runtime.getRuntime().availableProcessors());


        //固定线程数的池子  一个池子有5个处理线程
        ExecutorService threadpool1 = Executors.newFixedThreadPool(5);

        //单线程池子
        ExecutorService threadpool2 = Executors.newSingleThreadExecutor();

        //一池N个处理线程
        ExecutorService threadpool3 = Executors.newCachedThreadPool();

        //模拟10个用户来办理业务 每个用户就是一个来自外部的请求线程
//        try {
//            for (int i = 1 ; i <= 10 ; i++) {
//
//                threadpool3.execute(()->{
//                    System.out.println(Thread.currentThread().getName()+"\t 办理业务");
//                });
//
//
//            }
//
//        }catch(Exception e){
//            e.printStackTrace();
//        }finally {
//            threadpool3.shutdown();
//        }
    }
}
