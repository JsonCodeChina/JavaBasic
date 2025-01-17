package io.NIO.notblock;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;
import java.util.Date;
import java.util.Scanner;

public class Client {

    public static void main(String[] args) throws IOException {
        //1. 获取通道
        SocketChannel sc =
                SocketChannel.open(new InetSocketAddress("127.0.0.1",9999));

        //2. 切换非阻塞模式
        sc.configureBlocking(false);

        //3. 分配指定大小的缓冲区
        ByteBuffer buff = ByteBuffer.allocate(1024);

        //4. 发送数据给服务端
        Scanner scanner = new Scanner(System.in);

        while (scanner.hasNext()){
            String str = scanner.next();
            buff.put((new Date().toString() + "\n" + str).getBytes());
            buff.flip();
            sc.write(buff);
            buff.clear();
        }

        //5. 关闭通道
        sc.close();
    }
}
