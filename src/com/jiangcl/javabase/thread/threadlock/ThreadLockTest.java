package com.jiangcl.javabase.thread.threadlock;

/**
 * @author jiangcl
 * @date 2019/12/6
 * @desc Lock锁解决线程安全问题
 */
public class ThreadLockTest {

    public static void main(String[] args) {
        TicketWindow w = new TicketWindow();

        Thread t1 = new Thread(w);
        Thread t2 = new Thread(w);
        Thread t3 = new Thread(w);

        t1.setName("窗口1");
        t2.setName("窗口2");
        t3.setName("窗口3");

        t1.start();
        t2.start();
        t3.start();
    }

}
