package com.netty.study.bytebuf;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.util.CharsetUtil;

/**
 * @author ：fei
 * @date ：Created in 2019/8/14 0014 09:41
 */
public class ByteBufTest1 {
    public static void main(String[] args) {
        ByteBuf byteBuf = Unpooled.copiedBuffer("Hello, world!", CharsetUtil.UTF_8);
        if (byteBuf.hasArray()) {
            byte[] content = byteBuf.array();
            System.out.println(new String(content, CharsetUtil.UTF_8));
        }
    }
}
