package io.NIO.itcast;


import com.sun.org.apache.bcel.internal.generic.Select;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.*;
import java.util.Iterator;
import java.util.Set;

public class NIOService {
    public static void main(String[] args) throws IOException {
        //获得通道
        ServerSocketChannel ssc = ServerSocketChannel.open();
        ssc.bind(new InetSocketAddress("127.0.0.1",9999));

        //设置为非阻塞模式
        ssc.configureBlocking(false);

        //获得一个选择器
        Selector selector = Selector.open();

        //将选择器注册到通道上
        ssc.register(selector, SelectionKey.OP_ACCEPT);


        while(true){
            //返回客户端的个数
            int select = selector.select(2000);

            if(select ==0){
                System.out.println("Server：没有客户端来连接我，我没事干，就可以在这里做点想做的事情了");
                continue;
            }

            //获得通道里面的事件
            Set<SelectionKey> selectionKeys = selector.selectedKeys();
            Iterator<SelectionKey> iterator = selectionKeys.iterator();
            while (iterator.hasNext()){
                //判断通道里面的事件
                SelectionKey selectionKey = iterator.next();

                if(selectionKey.isAcceptable()){
                    System.out.println("on accept");
                    //获得客户端
                    SocketChannel sc = ssc.accept();

                    //设置为非阻塞
                    sc.configureBlocking(false);

                    //将客户端注册到选择器上
                    sc.register(selector,SelectionKey.OP_READ, ByteBuffer.allocate(1024));
                }else if(selectionKey.isReadable()){
                    System.out.println("on read");
                    SocketChannel channel = (SocketChannel) selectionKey.channel();
                    ByteBuffer buffer = (ByteBuffer) selectionKey.attachment();
                    channel.read(buffer);
                    System.out.println("客户端发来的数据:"+new String(buffer.array()));
                }

                //移除已经遍历好的插件
                iterator.remove();
            }


        }



    }
}
