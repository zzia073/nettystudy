package com.netty.study.niotest;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.channels.*;
import java.util.Set;

/**
 * @author ：fei
 * @date ：Created in 2019/8/12 0012 08:45
 */
public class NioServer {
    public static void main(String[] args) throws Exception {
        //Reactor 中的 handle 资源即channel 产生事件的根本，文件描述符或句柄
        ServerSocketChannel channel = ServerSocketChannel.open();
        channel.bind(new InetSocketAddress(8899)).configureBlocking(false);
        //同步事件分离器（synchronous event demultiplexer）
        Selector selector = Selector.open();
        channel.register(selector, SelectionKey.OP_ACCEPT);
        while (true) {
            selector.select();
            Set<SelectionKey> selectionKeys = selector.selectedKeys();
            //该循环是初始化分发器的功能，定义一些事件应该在什么情况下被触发，用来注册移除调度事件处理器
            selectionKeys.forEach(selectionKey -> {
                try {
                    //
                    if (selectionKey.isAcceptable()) {
                        //回调 事件处理 Event Handler
                        acceptInvoke(selectionKey);
                    }
                }catch (Exception e){
                    e.printStackTrace();
                }
            });
            selectionKeys.clear();
        }
    }
    //Concrete Event Handler
    private static void acceptInvoke(SelectionKey selectionKey) throws IOException, InterruptedException {
        ServerSocketChannel serverSocketChannel = (ServerSocketChannel) selectionKey.channel();
        SocketChannel socketChannel = serverSocketChannel.accept();
        System.out.println(socketChannel.getRemoteAddress());
        Thread.sleep(5000);
    }
}
