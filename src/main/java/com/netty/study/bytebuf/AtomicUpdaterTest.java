package com.netty.study.bytebuf;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;

/**
 * @author ：fei
 * @date ：Created in 2019/8/14 0014 14:06
 */
public class AtomicUpdaterTest {
    public static void main(String[] args) {
        Student s = new Student();
        for (int i = 0; i < 10; i++) {
            new Thread(() -> {
                AtomicIntegerFieldUpdater<Student> updater = AtomicIntegerFieldUpdater.newUpdater(Student.class, "age");
                int in = updater.addAndGet(s,1);
                System.out.println(in);

            }).start();
        }

    }
}
class Student {
    volatile int age = 1;
}
