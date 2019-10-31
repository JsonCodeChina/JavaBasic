package JUC.volatileDemo;


import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

class Mydata{

    volatile int num = 0;

    public  void  addTo60(){
        this.num = 60;
    }

    public  void addPlusplus(){
        num++;
    }

    AtomicInteger atomicInteger = new AtomicInteger();
    public void addAtmoic(){
        atomicInteger.getAndIncrement();
    }
}

/**
 * 验证volatile的可见性
 *  假如 int num = 0 ； 如果没有添加volatile关键字的修饰
 *
 * 验证volatile的原子性
 */
public class VolatileDemo {

    public static void main(String[] args) {

        Mydata mydata = new Mydata();

        for (int i = 1; i <= 20; i++) {
            new Thread(()->{
                for (int j = 1; j <= 1000; j++) {
                     mydata.addPlusplus();
                     mydata.addAtmoic();
                }
            },String.valueOf(i)).start();
        }

        while(Thread.activeCount()>2){
            Thread.yield();
        }

        System.out.println("1:"+mydata.num);
        System.out.println("2:"+mydata.atomicInteger);

    }

    private static void seeOK() {
        Mydata mydata = new Mydata();

        new Thread(()->{
            System.out.println(Thread.currentThread().getName()+"\t come in");

            try {
                TimeUnit.SECONDS.sleep(3);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            mydata.addTo60();

            System.out.println(Thread.currentThread().getName()+"\t update num value");

        },"thread a").start();

        while(mydata.num == 0){

        }

        System.out.println(Thread.currentThread().getName()+"\t mission is over");
    }

}
