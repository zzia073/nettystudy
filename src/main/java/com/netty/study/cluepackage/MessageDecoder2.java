package com.netty.study.cluepackage;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.ByteToMessageDecoder;

import java.util.List;

/**
 * @author ：fei
 * @date ：Created in 2019/8/29 0029 10:42
 */
public class MessageDecoder2 extends ByteToMessageDecoder {
    @Override
    protected void decode(ChannelHandlerContext ctx, ByteBuf in, List<Object> out) throws Exception {
        System.out.println("decode");
        if (in.readableBytes() < 4){
            return;
        }

        int length = in.readInt();
        RequestProtocol protocol = new RequestProtocol();
        protocol.setLength(length);
        System.out.println(protocol.getLength() + "::::" + in.readableBytes());
//        byte[] bytes = new byte[in.readableBytes()];
        byte[] bytes = new byte[protocol.getLength()];
        in.readBytes(bytes);
        protocol.setData(bytes);
        out.add(protocol);
    }
}
