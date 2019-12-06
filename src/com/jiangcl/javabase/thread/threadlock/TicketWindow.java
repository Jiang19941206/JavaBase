package com.jiangcl.javabase.thread.threadlock;

import java.util.concurrent.locks.ReentrantLock;

/**
 * @author jiangcl
 * @date 2019/12/6
 * @desc 创建线程类
 */
public class TicketWindow implements Runnable {
    private int ticket = 100;

    //实例化ReentrantLock
    private ReentrantLock lock = new ReentrantLock();

    @Override
    public void run() {
        while (true){
            try {
                Thread.sleep(100l);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            /*lock.lock();
            if(ticket > 0){
                System.out.println(Thread.currentThread().getName() + "：售出的票号为：" + ticket);
                ticket--;
                lock.unlock();
            }else {
                lock.unlock();
                break;
            }*/
            //改进，使用try—catch—finally
            try {
                //加锁
                lock.lock();
                if(ticket > 0){
                    System.out.println(Thread.currentThread().getName() + "：售出的票号为：" + ticket);
                    ticket--;
                }else break;
            } catch (Exception e) {
                e.printStackTrace();
            }finally {
                //释放锁
                lock.unlock();
            }

        }
    }
}
