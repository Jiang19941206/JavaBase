package com.jiangcl.javabase.thread.threadpool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author jiangcl
 * @date 2019/12/9
 * @desc 线程池测试
 */
public class ThreadPoolTest {

    public static void main(String[] args) {
        //创建指定线程数量的线程池
        ExecutorService service = Executors.newFixedThreadPool(10);
        //执行指定的线程操作，需要提供实现Runnable或者Callable接口实现类的对象
        /*service.submit()适用于实现Callable接口的线程
        service.execute()适用于实现Runnable接口的线程*/
        service.execute(new Runnable() {
            @Override
            public void run() {
                for(int i = 0 ;i < 100; i++){
                    if(i % 2 == 0){
                        System.out.println(Thread.currentThread().getName() + "："+i);
                    }
                }
            }
        });
        service.execute(new Thread(){
            @Override
            public void run() {
                for(int i = 0 ;i < 100; i++){
                    if(i % 2 != 0){
                        System.out.println(Thread.currentThread().getName() + "："+i);
                    }
                }
            }
        });
        //关闭线程池
        service.shutdown();
    }
}
