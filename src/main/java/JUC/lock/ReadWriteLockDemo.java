package JUC.lock;


import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantReadWriteLock;

class Mycache{

    private volatile Map<String,Object> map = new HashMap<>();
    private ReentrantReadWriteLock lock
            = new ReentrantReadWriteLock();

    public void put(String key, Object value){
        lock.writeLock().lock();
        try{
            System.out.println(Thread.currentThread().getName()+"\t write in key: "+key);

            try{TimeUnit.SECONDS.sleep(1);} catch (InterruptedException e){e.printStackTrace();}
            map.put(key,value);

            System.out.println(Thread.currentThread().getName()+"\t write in finish");
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            lock.writeLock().unlock();
        }



    }

    public void get(String key){
        lock.readLock().lock();
        try{
            System.out.println(Thread.currentThread().getName()+"\t get value");

            try{TimeUnit.SECONDS.sleep(1);} catch (InterruptedException e){e.printStackTrace();}
            Object result = map.get(key);
            System.out.println(Thread.currentThread().getName()+"\t get result: "+result);
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            lock.readLock().unlock();
        }

    }

}


public class ReadWriteLockDemo {

    public static void main(String[] args) {

        Mycache mycache = new Mycache();

        for(int i = 1; i <= 5 ;i++)
        {
            final int tempInt = i;
            new Thread(()->{
                mycache.put(tempInt+"",tempInt+"");
            },String.valueOf(i)).start();
        }

        for(int i = 1; i <= 5 ;i++)
        {
            final int tempInt = i;
            new Thread(()->{
                mycache.get(tempInt+"");
            },String.valueOf(i)).start();
        }
    }
}
