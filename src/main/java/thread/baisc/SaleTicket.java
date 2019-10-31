package thread.baisc;


import lombok.Data;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

@Data
class Ticket{
    private int ticketNum = 30;

    private Lock lock = new ReentrantLock();

    public  void sale(){
        lock.lock();
        try {

            while(ticketNum>0){
                System.out.println(Thread.currentThread().getName()+
                        " sell tickets, the tickets ="+this.ticketNum--);
            }

        }finally {
            lock.unlock();
        }
    }



}


/**
 * 三个售票员卖出30张票
 * 操作资源类  要求高内聚 低耦合
 */
public class SaleTicket {


    public static void main(String[] args) {

        Ticket ticket = new Ticket();

        for(int i = 1; i <= 10 ;i++)
        {
            new Thread(()->{
                while (true){
                    ticket.sale();
                }
            },String.valueOf(i)).start();
        }
    }
}
