package JUC.callable;

import java.util.concurrent.*;

public class ThreadPoolDemo {

    public static void main(String[] args) {
        ExecutorService service = Executors.newCachedThreadPool();
        Future<String> future = service.submit(new MyCallable());
        if(!future.isDone()){
            System.out.println("wait");
        }
        try {
            System.out.println(future.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }finally {
            service.shutdown();
        }

    }
}
