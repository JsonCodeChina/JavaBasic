package thread.cast;


import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class  Print{

    private int num = 0; //0 -> 1 // 1 -> 2

    private Lock lock = new ReentrantLock();
    private Condition condition = lock.newCondition();

    public void print1(){
        lock.lock();
        try{
            while(num!=0){
                condition.await();
            }
            num++;
            System.out.println("1");
            condition.signal();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            lock.unlock();
        }

    }

    public void print2(){
        lock.lock();
        try{
            while(num==0){
                condition.await();
            }
            num--;
            System.out.println("2");
            condition.signal();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }
}



//需求：一个线程输出10次1，一个线程输出10次2，要求交替输出，例如：1 2 1 2 1 2 ..........
public class Demo1 {

    public static void main(String[] args) {

        Print print = new Print();

        new Thread(()->{
            for (int i = 0; i < 10; i++) {
                print.print1();
            }
            },"a").start();


        new Thread(()->{
            for (int i = 0; i < 10; i++) {
                print.print2();
            }
            },"b").start();
    }
}

