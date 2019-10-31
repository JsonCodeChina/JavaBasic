package jvm;

import java.lang.ref.Reference;

public class HelloGC {

    public static void main(String[] args) throws InterruptedException {
        System.out.println("helloGC");
        Thread.sleep(Integer.MAX_VALUE);


//        System.out.println(Runtime.getRuntime().totalMemory()/1024/1024);
//        System.out.println(Runtime.getRuntime().maxMemory()/1024/1024);
    }
}
