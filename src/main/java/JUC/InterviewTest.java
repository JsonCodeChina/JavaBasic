package JUC;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class Data2Print{

    private boolean flag = false; //false: num  true:letter

    private Lock lock = new ReentrantLock();
    private Condition condition = lock.newCondition();

    int num = 1;
    int letter = 65;

    boolean numflag = true;
    boolean letterflag = true;

    public void printNum() throws InterruptedException {

        if(num>=52){
            numflag = false;
            return;
        }

        lock.lock();
        try{

            while(flag){
                condition.await();
            }

            System.out.println(Thread.currentThread().getName()+":"+num);
            num++;
            System.out.println(Thread.currentThread().getName()+":"+num);
            num++;


            flag = true;
            condition.signalAll();
        }finally {
            lock.unlock();
        }

    }

    public void printLetter() throws InterruptedException {
        if(letter>=90){
            letterflag = false;
            return;
        }
        lock.lock();
        try{
            while(!flag){
                condition.await();
            }

            System.out.println(Thread.currentThread().getName()+":"+(char)letter);
            letter++;
            //print letter
            flag = false;
            condition.signalAll();
        }finally {
            lock.unlock();
        }

    }

}


//多线程练习：
//        * 1.开启一个线程打印1～52，开启另一个线程打印A～Z
//        * 打印方式：12A34B46C依次打印
public class InterviewTest {

    public static void main(String[] args) {
        Data2Print data2Print = new Data2Print();

        new Thread(()->{
           while(data2Print.numflag) {
               try {
                   data2Print.printNum();
               } catch (InterruptedException e) {
                   e.printStackTrace();
               }
           }

        },"a").start();

        new Thread(()->{
           while(data2Print.letterflag){
                try {
                    data2Print.printLetter();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        },"b").start();

    }
}
