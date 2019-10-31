package jvm.exception;

import java.nio.ByteBuffer;
import java.util.concurrent.TimeUnit;

public class DirectBufferMemoryDemo {

    public static void main(String[] args) {
        System.out.println("配置的maxDirectMemory"+(sun.misc.VM.maxDirectMemory()/(double)1024/1024)+"MB");

        try{TimeUnit.SECONDS.sleep(3);} catch (InterruptedException e){e.printStackTrace();}

        //-XX:MaxDirectMemorySize=5m 我们配置为5mb，但是实际使用6mb 故意破坏
        ByteBuffer bb = ByteBuffer.allocateDirect(6*1024*1024);

    }
}
