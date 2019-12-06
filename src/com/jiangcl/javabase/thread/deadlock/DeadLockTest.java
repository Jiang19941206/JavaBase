package com.jiangcl.javabase.thread.deadlock;

import java.util.concurrent.locks.ReentrantLock;

/**
 * @author jiangcl
 * @date 2019/12/6
 * @desc 线程死锁举例
 */
public class DeadLockTest {

    public static void main(String[] args) {
        deadLochExmple();
    }

    /**
     * @desc 出现死锁的例子
     * @author jiangcl
     * @date 2019/12/6
     * @param
     * @return void
     */
    public static void deadLochExmple(){
        StringBuffer s1 = new StringBuffer();
        StringBuffer s2 = new StringBuffer();

        new Thread(){
            @Override
            public void run() {
                synchronized(s1){
                    s1.append("a");
                    s2.append("1");
                    System.out.println(s1.toString());
                    System.out.println(s2.toString());
                    try {
                        sleep(100l);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    synchronized(s2){
                        s1.append("b");
                        s2.append("2");
                        System.out.println(s1.toString());
                        System.out.println(s2.toString());
                    }
                }
            }
        }.start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized(s2){
                    s1.append("c");
                    s2.append("3");
                    System.out.println(s1.toString());
                    System.out.println(s2.toString());
                    synchronized(s1){
                        s1.append("d");
                        s2.append("4");
                        System.out.println(s1.toString());
                        System.out.println(s2.toString());
                    }
                }
            }
        }).start();
    }
}
