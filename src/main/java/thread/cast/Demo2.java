package thread.cast;


import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class Ticket{

    private int num = 100;
    private Lock lock = new ReentrantLock();

    public void sell(){
    lock.lock();
    try{
        while(num>0){
            System.out.println(Thread.currentThread().getName()+"卖票，还有:"+num+" 张票！");
            num--;
        }
    }catch (Exception e){
        e.printStackTrace();
    }finally { lock.unlock();
    }

    }

}

//卖20张票
public class Demo2 {
    public static void main(String[] args) {
        Ticket ticket = new Ticket();
        for(int i = 1; i <= 10 ;i++)
        {
            new Thread(()->{
                ticket.sell();
                try{TimeUnit.SECONDS.sleep(1);} catch (InterruptedException e){e.printStackTrace();}
            },String.valueOf(i)).start();
        }

    }
}
