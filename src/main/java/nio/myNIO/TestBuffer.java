package nio.myNIO;


import org.junit.jupiter.api.Test;

import java.nio.ByteBuffer;

/**
 * 缓冲区：在java nio 中负责数据的存储
 * 缓存区就是数组 用于存储不同的数据类型的数据  除去boolean
 *  byte
 *  char
 *  short
 *  long
 *  double
 *  float
 *  int
 *       allocate()获取缓存区
 */

public class TestBuffer {


    @Test
    public void test3(){
        ByteBuffer buf = ByteBuffer.allocateDirect(11);
        System.out.println(buf.isDirect());
    }

    @Test
    public void test2(){
        ByteBuffer buf = ByteBuffer.allocate(1024);
        String str = "shenbo";
        buf.put(str.getBytes());

        buf.flip();
        byte[] dst = new byte[buf.limit()];
        buf.get(dst,0,2);
        System.out.println(new String(dst,0,2));

        System.out.println(buf.position());
        System.out.println(buf.limit());
        System.out.println(buf.capacity());

        buf.mark();
        buf.get(dst,2,2);
        System.out.println(new String(dst,2,2));
        System.out.println(buf.position());
        System.out.println(buf.limit());
        System.out.println(buf.capacity());

        buf.reset();

        System.out.println(buf.position());
        System.out.println(buf.limit());
        System.out.println(buf.capacity());

        if(buf.hasRemaining()){
            System.out.println(buf.remaining());
        }

    }

    @Test
    public void test1(){
        ByteBuffer buf = ByteBuffer.allocate(1024);

        System.out.println("====allocate()====");
        System.out.println(buf.position());
        System.out.println(buf.limit());
        System.out.println(buf.capacity());

        System.out.println("====put()====");
        String str = "abcde";
        buf.put(str.getBytes());
        System.out.println(buf.position());
        System.out.println(buf.limit());
        System.out.println(buf.capacity());

        System.out.println("====flip()====");
        buf.flip();
        System.out.println(buf.position());
        System.out.println(buf.limit());
        System.out.println(buf.capacity());

        System.out.println("====get()====");
        byte[] dst = new byte[buf.limit()];
        buf.get(dst);
        System.out.println(new String(dst,0,dst.length));

        System.out.println(buf.position());
        System.out.println(buf.limit());
        System.out.println(buf.capacity());

        System.out.println("====rewind()====");
        buf.rewind();//可重复读数据
        System.out.println(buf.position());
        System.out.println(buf.limit());
        System.out.println(buf.capacity());

//        System.out.println("====clear()====");
//        buf.clear(); //但是里面的数据并没有被清空，处于被遗忘状态
//        System.out.println(buf.position());
//        System.out.println(buf.limit());
//        System.out.println(buf.capacity());

        System.out.println("====compact()====");
        buf.compact(); //但是里面的数据并没有被清空，处于被遗忘状态
        System.out.println(buf.position());
        System.out.println(buf.limit());
        System.out.println(buf.capacity());

//        System.out.println((char)buf.get());
    }

}
