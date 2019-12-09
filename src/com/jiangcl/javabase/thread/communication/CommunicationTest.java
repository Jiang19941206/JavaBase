package com.jiangcl.javabase.thread.communication;

/**
 * @author jiangcl
 * @date 2019/12/9
 * @desc 线程通信
 */
public class CommunicationTest {

    public static void main(String[] args) {
        CommunicationThread communicationThread = new CommunicationThread();

        Thread t1 = new Thread(communicationThread);
        Thread t2 = new Thread(communicationThread);

        t1.setName("线程1");
        t2.setName("线程2");

        t1.start();
        t2.start();
    }
}
