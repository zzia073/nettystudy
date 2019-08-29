package com.netty.study.cluepackage;

import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.util.concurrent.EventExecutorGroup;

import java.util.concurrent.Executors;

/**
 * @author ：fei
 * @date ：Created in 2019/8/29 0029 10:49
 */
public class ServerHandler extends SimpleChannelInboundHandler<RequestProtocol> {
    int count;
    @Override
    protected void channelRead0(ChannelHandlerContext ctx, RequestProtocol msg) throws Exception {
        //处理客户端发来的消息
        System.out.println("客户端消息长度：" + msg.getLength() + "，消息内容：" + new String(msg.getData(),"UTF-8"));
        System.out.println("count:" + count);
        //此处不用线程处理将造成io阻塞导致服务器端这个循环执行完之后才会调用下次channelRead0方法
        Executors.newSingleThreadExecutor().submit(() ->{

            if (count ++ == 0) {
                //通道激活给客户端发送消息
                for (int i = 0; i < 100; i++) {

                    RequestProtocol protocol = new RequestProtocol();
                    String msg1 = "server send msg";
                    protocol.setLength(msg1.length());
                    protocol.setData(msg1.getBytes());
                    ctx.writeAndFlush(protocol);
                    //此处不休眠将造成客户端消息拥堵读写越界
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });
    }

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        System.out.println("client connected");
        RequestProtocol protocol = new RequestProtocol();
        String msg = "trigger send msg";
        protocol.setLength(msg.length());
        protocol.setData(msg.getBytes());
        ctx.writeAndFlush(protocol);
    }
}
