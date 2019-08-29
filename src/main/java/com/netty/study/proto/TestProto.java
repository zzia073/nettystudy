package com.netty.study.proto;

import com.google.protobuf.InvalidProtocolBufferException;

/**
 * @author ：fei
 * @date ：Created in 2019/8/8 0008 15:52
 */
public class TestProto {
    public static void main(String[] args) throws InvalidProtocolBufferException {
        AddressBookProto.Person person = AddressBookProto.Person.newBuilder()
                .setName("张小三").setAge(18).setEmail("222@qq.com").build();
        byte[] person2ByteArray = person.toByteArray();
        AddressBookProto.Person person1 = AddressBookProto.Person.parseFrom(person2ByteArray);
        System.out.println(person1.getName());
        System.out.println(person1.getAge());
        System.out.println(person1.getEmail());
    }
}
