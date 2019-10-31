package io.NIO.block;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;



/*
 * 一、使用 NIO 完成网络通信的三个核心：
 *
 * 1. 通道（Channel）：负责连接
 *
 * 	   java.nio.channels.Channel 接口：
 * 			|--SelectableChannel
 * 				|--SocketChannel
 * 				|--ServerSocketChannel
 * 				|--DatagramChannel
 *
 * 				|--Pipe.SinkChannel
 * 				|--Pipe.SourceChannel
 *
 * 2. 缓冲区（Buffer）：负责数据的存取
 *
 * 3. 选择器（Selector）：是 SelectableChannel 的多路复用器。用于监控 SelectableChannel 的 IO 状况
 *
 */

public class Server {

    public static void main(String[] args) throws  Exception{


            ServerSocketChannel ssc = ServerSocketChannel.open();
            ssc.bind(new InetSocketAddress(9999));

            FileChannel fileChannel =
                    FileChannel.open(Paths.get("1.txt"),
                            StandardOpenOption.WRITE, StandardOpenOption.CREATE);
            SocketChannel sc = ssc.accept();

            ByteBuffer buff = ByteBuffer.allocate(1024);

            while(sc.read(buff)!=-1){
                buff.flip();
                fileChannel.write(buff);
                buff.clear();
            }

            buff.put("服务器端接受数据成功".getBytes());
            buff.flip();
            sc.write(buff);


            ssc.close();
            sc.close();
            fileChannel.close();

    }
}
