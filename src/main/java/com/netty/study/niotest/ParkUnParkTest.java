package com.netty.study.niotest;

import io.netty.util.concurrent.DefaultThreadFactory;

import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.locks.LockSupport;

/**
 * @author ：fei
 * @date ：Created in 2019/8/16 0016 14:32
 */
public class ParkUnParkTest {
    public static void main(String[] args) {
        Thread t = Thread.currentThread();
        ScheduledThreadPoolExecutor scheduledThreadPoolExecutor =
                new ScheduledThreadPoolExecutor(1, new DefaultThreadFactory("singlePool"));
        scheduledThreadPoolExecutor.submit(() -> {
            try {
                Thread.sleep(2000);
            } catch (Exception e){
                e.printStackTrace();
            }
            //unblock线程t
            LockSupport.unpark(t);
            System.out.println("b");
            try {
                Thread.sleep(3000);
            } catch (Exception e) {
                e.printStackTrace();
            }
            System.out.println("d");
        });
        //park阻塞当前线程
        LockSupport.park();
        System.out.println("a");
        //shutdown和shutdownNow区别
        scheduledThreadPoolExecutor.shutdown();
        System.out.println("c");
    }
}
