package com.jiangcl.javabase.thread.runnable;

/**
 * @author jiangcl
 * @date 2019/12/6
 * @desc 实现Runnable方式实现多线程
 */
public class ThreadRunnable implements Runnable {
    @Override
    public void run() {
        for(int i = 0; i < 100; i++){
            if(i % 2 == 0){
                System.out.println(Thread.currentThread().getName() + "************" + i);
            }
        }
    }
}
