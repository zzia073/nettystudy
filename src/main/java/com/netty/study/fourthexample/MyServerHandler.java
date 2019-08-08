package com.netty.study.fourthexample;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.handler.timeout.IdleStateEvent;

/**
 * @author ：fei
 * @date ：Created in 2019/8/8 0008 09:36
 */
public class MyServerHandler extends ChannelInboundHandlerAdapter {

    @Override
    public void userEventTriggered(ChannelHandlerContext ctx, Object evt) throws Exception {
        if (evt instanceof IdleStateEvent){
            IdleStateEvent event = (IdleStateEvent) evt;
            String idleState = null;
            switch (event.state()){
                case READER_IDLE:
                    idleState = "读空闲"; break;
                case WRITER_IDLE:
                    idleState = "写空闲"; break;
                case ALL_IDLE:
                    idleState = "读写空闲"; break;
                    default: break;
            }
            System.out.println(ctx.channel().remoteAddress() + "超时事件：" + idleState);
            ctx.channel().closeFuture();
        }
    }
}
