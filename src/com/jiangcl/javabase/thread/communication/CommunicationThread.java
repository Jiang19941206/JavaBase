package com.jiangcl.javabase.thread.communication;

/**
 * @author jiangcl
 * @date 2019/12/9
 * @desc 线程通信
 */
public class CommunicationThread implements Runnable {
    private int i = 1;

    @Override
    public void run() {
        while (true){
            synchronized(this){
                notify();//唤醒处于wait状态的线程，若有多个线程处于wait状态时可以使用notifyAll()
                if(i <= 100){
                    System.out.println(Thread.currentThread().getName() + "：" + i);
                    i++;
                    try {
                        wait();//是线程进入阻塞状态
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }else break;
            }
        }
    }
}
