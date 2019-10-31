package io.NIO.itcast;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;

public class NIOClient {


    public static void main(String[] args) throws IOException {

        //获得客户端通道
        SocketChannel socketChannel =
                SocketChannel.open(new InetSocketAddress("127.0.0.1",9999));

        //设置为非阻塞模式
        socketChannel.configureBlocking(false);

        //获得缓存区
        ByteBuffer buff = ByteBuffer.allocate(1024);

        //判断是否连上服务器
        if(!socketChannel.isConnected()){
                while(!socketChannel.finishConnect()){
                    System.out.println("Client连接服务端的同时，我还可以处理一些其他的事情");
                }
        }

        //准备要发送的数据
        String msg = "hello, 我是客户端";

        buff.put(msg.getBytes());
        buff.flip();
        socketChannel.write(buff);

        //为了让客户端不停止
        System.in.read();

    }

}
