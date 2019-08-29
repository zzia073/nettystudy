package com.netty.study.cluepackage;

/**
 * @author ：fei
 * @date ：Created in 2019/8/29 0029 10:41
 */
public class RequestProtocol {
    private int length;
    private byte[] data;

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public byte[] getData() {
        return data;
    }

    public void setData(byte[] data) {
        this.data = data;
    }
}
