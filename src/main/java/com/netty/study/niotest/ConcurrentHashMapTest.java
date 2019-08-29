package com.netty.study.niotest;

import io.netty.util.Constant;
import io.netty.util.ConstantPool;

import java.util.concurrent.ConcurrentHashMap;

/**
 * @author ：fei
 * @date ：Created in 2019/8/12 0012 15:32
 */
public class ConcurrentHashMapTest {
    public static void main(String[] args) {
        ConstantPool constantPool = new ConstantPool() {
            @Override
            protected Constant newConstant(int id, String name) {
                return newConstant(id, name);
            }
        };
        Constant feifei = constantPool.valueOf("feifei");
        System.out.println(feifei);
    }
}
