package io.NIO.block;



import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.SocketChannel;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class Client {

    public static void main(String[] args) throws  Exception{

        //获得通道
        SocketChannel sc =
                SocketChannel.open(new InetSocketAddress("127.0.0.1",9999));


        //从本地读取文件发送
        FileChannel fileChannel =
                FileChannel.open(Paths.get("s.txt"), StandardOpenOption.READ);

        //用缓冲区来读取数据
        ByteBuffer buff = ByteBuffer.allocate(1024);


        while(fileChannel.read(buff) != -1){
            buff.flip();
            sc.write(buff);
            buff.clear();
        }


        System.out.println("1");
        sc.shutdownOutput();
        System.out.println("2");

            int len = 0;
            while((len = sc.read(buff)) != -1){
                buff.flip();
                System.out.println(new String(buff.array(),0,len));
                buff.clear();
            }

            //关闭通道
            sc.close();
            fileChannel.close();




    }


}
