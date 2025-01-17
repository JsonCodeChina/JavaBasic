package io.NIO.notblock;

import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.*;
import java.util.Iterator;

public class Server {

    public static void main(String[] args) throws Exception {
        //1. 获取通道
        ServerSocketChannel ssc = ServerSocketChannel.open();
        //2. 切换非阻塞模式
        ssc.configureBlocking(false);
        //3. 绑定连接
        ssc.bind(new InetSocketAddress(9999));
        //4. 获取选择器
        Selector selector = Selector.open();
        //5. 将通道注册到选择器上, 并且指定“监听接收事件”
        ssc.register(selector, SelectionKey.OP_ACCEPT);

        //6. 轮询式的获取选择器上已经“准备就绪”的事件
        while(selector.select()>0){
            //7. 获取当前选择器中所有注册的“选择键(已就绪的监听事件)”
            Iterator<SelectionKey> it = selector.selectedKeys().iterator();

            while(it.hasNext()){
                //8. 获取准备“就绪”的是事件
                SelectionKey sk = it.next();

                //9. 判断具体是什么事件准备就绪
                if(sk.isAcceptable()){
                    //10. 若“接收就绪”，获取客户端连接
                    SocketChannel sc = ssc.accept();

                    //11. 切换非阻塞模式
                    sc.configureBlocking(false);

                    //12. 将该通道注册到选择器上
                    sc.register(selector,SelectionKey.OP_READ);
                }else if(sk.isReadable()){
                    //13. 获取当前选择器上“读就绪”状态的通道
                    SocketChannel sc = (SocketChannel)sk.channel();

                    //14. 读取数据
                    ByteBuffer buf = ByteBuffer.allocate(1024);

                    int len = 0;
                    while((len = sc.read(buf)) > 0 ){
                        buf.flip();
                        System.out.println(new String(buf.array(), 0, len));
                        buf.clear();
                    }
                }

                //15. 取消选择键 SelectionKey
                it.remove();
            }


        }

    }
}
