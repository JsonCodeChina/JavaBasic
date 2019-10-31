package JUC.cas;


import java.util.concurrent.atomic.AtomicInteger;

/**
 * CAS : compare and set
 */
public class CASDemo {

    public static void main(String[] args) {
        AtomicInteger atomicInteger = new AtomicInteger(5);
        System.out.println(atomicInteger.compareAndSet(5,2019)+
                "\t current data:"+atomicInteger.get());

        System.out.println(atomicInteger.compareAndSet(2019,2018)+
                "\t current data:"+atomicInteger.get());

        atomicInteger.getAndIncrement();


    }
}
