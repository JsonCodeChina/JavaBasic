package io.NIO.chat;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.Set;

public class ChatServer {

    private ServerSocketChannel serverSocketChannel;
    private static final int PORT = 9999;
    private Selector selector;

    public ChatServer() throws IOException {
        try {
            serverSocketChannel = ServerSocketChannel.open();
            serverSocketChannel.bind(new InetSocketAddress(PORT));

            serverSocketChannel.configureBlocking(false);

            selector = Selector.open();

            serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);
            
            printInfo("Chat Server is Ready.........");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void start() throws IOException {
        while (true){
            int select = selector.select(2000);
            if (select == 0) {
                System.out.println("Server:没有客户端找我， 我就干别的事情");
                continue;
            }
            Set<SelectionKey> selectionKeys = selector.selectedKeys();
            Iterator<SelectionKey> iterator = selectionKeys.iterator();

            while(iterator.hasNext()){
                SelectionKey selectionKey = iterator.next();
                if(selectionKey.isAcceptable()){
                    SocketChannel sc = serverSocketChannel.accept();
                    sc.configureBlocking(false);
                    sc.register(selector,SelectionKey.OP_READ);
                    System.out.println(sc.getRemoteAddress().toString().substring(1)+"：上线了");
                }else if(selectionKey.isReadable()){
                    SocketChannel channel = (SocketChannel) selectionKey.channel();
                    ByteBuffer buffer = ByteBuffer.allocate(1024);
                    int count = channel.read(buffer);
                    if(count>0){
                        printInfo(new String(buffer.array()));
                        //服务器进行广播
                        System.out.println("服务器端广播消息到其他通道.........");
                        for(SelectionKey key:selector.keys()){
                            Channel channel1 = key.channel();//获得客户端通道
                            //判断客户端通道
                            if(channel1 instanceof SocketChannel && channel1 != channel){

                                ((SocketChannel) channel1).
                                        write(ByteBuffer.wrap(new String(buffer.array()).getBytes()));
                            }

                        }

                    }

                }
                iterator.remove();
            }


        }

    }

    private void printInfo(String s) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        System.out.println("[" + sdf.format(new Date()) + "] -> " + s);
    }

    public static void main(String[] args) throws IOException {
        new ChatServer().start();
    }
}
