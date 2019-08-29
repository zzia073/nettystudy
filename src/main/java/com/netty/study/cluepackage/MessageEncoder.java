package com.netty.study.cluepackage;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToByteEncoder;

/**
 * @author ：fei
 * @date ：Created in 2019/8/29 0029 10:42
 */
public class MessageEncoder extends MessageToByteEncoder<RequestProtocol> {

    @Override
    protected void encode(ChannelHandlerContext ctx, RequestProtocol msg, ByteBuf out) throws Exception {
        System.out.println("MessageEncoder invoke encode!!!");
        if (msg.getLength() > msg.getData().length) {
            return;
        }
        if (out.maxWritableBytes() < msg.getData().length + 4){
            return;
        }
        out.writeInt(msg.getLength());
        out.writeBytes(msg.getData());
    }
}
