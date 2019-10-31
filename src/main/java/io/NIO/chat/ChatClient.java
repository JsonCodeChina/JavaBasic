package io.NIO.chat;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;

public class ChatClient {
    private SocketChannel socketChannel;
    private static final String ADDRESS = "127.0.0.1";
    private static final int PORT = 9999;
    private String userName;

    public ChatClient() throws IOException {
        socketChannel = SocketChannel.open(new InetSocketAddress(ADDRESS,PORT));
        socketChannel.configureBlocking(false);
        if(!socketChannel.isConnected()){
            while (!socketChannel.finishConnect()){
                System.out.println("Client客户端在连接过程中，我可以干点别的事情");
            }
        }
        userName = socketChannel.getLocalAddress().toString().substring(1);
        System.out.println("----------Client（"+userName+") is Ready-----------");
    }

    //向服务器端发送数据
    public void sendMessageToServer(String msg) throws IOException {
        if("bye".equalsIgnoreCase(msg)){
            socketChannel.close();
            return;
        }

        msg = userName + "说了：" + msg;

        socketChannel.write(ByteBuffer.wrap(msg.getBytes()));
    }

    //接受服务器的数据
    public void receiveMessageFromServer() throws IOException {
        ByteBuffer buffer = ByteBuffer.allocate(1024);
        int read = socketChannel.read(buffer);
        if(read>0){
            System.out.println(new String(buffer.array()).trim());
        }
    }


}
