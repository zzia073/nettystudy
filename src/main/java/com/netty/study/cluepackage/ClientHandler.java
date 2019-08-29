package com.netty.study.cluepackage;

import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.util.concurrent.EventExecutorGroup;

/**
 * @author ：fei
 * @date ：Created in 2019/8/29 0029 10:57
 */
public class ClientHandler extends SimpleChannelInboundHandler<RequestProtocol> {
    @Override
    protected void channelRead0(ChannelHandlerContext ctx, RequestProtocol msg) throws Exception {
        ctx.writeAndFlush(msg);
        System.out.println("客户端收到消息长度：" + msg.getLength() + "，消息内容：" + new String(msg.getData(),"UTF-8"));
    }
}
