package com.jiangcl.javabase.thread.extendsp;

/**
 * @author jiangcl
 * @date 2019/12/6
 * @desc 继承方式实现多线程
 */
public class ThreadExtends extends Thread {

    @Override
    public void run() {
        for(int i = 0;i < 100;i++){
            if(i % 2 == 0){
                System.out.println(Thread.currentThread().getName()+ "************" +i);
            }
        }
    }
}
