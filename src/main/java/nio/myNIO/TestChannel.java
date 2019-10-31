package nio.myNIO;

import org.junit.jupiter.api.Test;

import java.io.*;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class TestChannel {

    @Test
    public void test1() throws IOException {
        FileInputStream fis = new FileInputStream("/Users/shenbo/IdeaProjects/JavaBasic/src/main/java/1.jpg");
        FileOutputStream fos = new FileOutputStream("2.jpg");

        FileChannel inChannel = fis.getChannel();
        FileChannel outChannel = fos.getChannel();

        ByteBuffer buf = ByteBuffer.allocate(1024);

        while(inChannel.read(buf)!=-1){
            buf.flip();
            outChannel.write(buf);
            buf.clear();
        }

        outChannel.close();
        inChannel.close();
        fos.close();
        fis.close();

    }
}
