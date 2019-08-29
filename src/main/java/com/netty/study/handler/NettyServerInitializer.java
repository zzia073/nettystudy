package com.netty.study.handler;

import io.netty.channel.ChannelInitializer;
import io.netty.channel.socket.ServerSocketChannel;

/**
 * @author ：fei
 * @date ：Created in 2019/8/16 0016 09:14
 */
public class NettyServerInitializer extends ChannelInitializer<ServerSocketChannel> {
    @Override
    protected void initChannel(ServerSocketChannel ch) throws Exception {
        ch.pipeline().addLast();
    }
}
