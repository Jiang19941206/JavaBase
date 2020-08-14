package com.jiangcl.javabase.thread.threadpool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author jiangcl
 * @date 2020/8/14
 * @desc
 */
public class ThreadPoolOrder {
    /**
     * 当使用线程池的时候可能会出现主线程先于子线程执行完，导致子线程里面的逻辑无法执行。
     *  解决方案：等线程池中的所有子线程都未结束的时候，再执行主线程
     * @param args
     */
    public static void main(String[] args) {
        ExecutorService service = Executors.newFixedThreadPool(5);

        for (int i = 0;i < 5;i++){
            service.execute(new Runnable() {
                @Override
                public void run() {
                    for (int i = 0; i < 100;i++){
                        System.out.println(Thread.currentThread().getName() + "：" + i);
                    }
                }
            });
        }

        service.shutdown();
        //判断线程池中所有线程是否执行完成，若全部执行结束则继续执行主线程
        while (true){
            System.out.println(service.isTerminated());
            if(service.isTerminated()){
                break;
            }
            try {
                Thread.sleep(2000l);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
