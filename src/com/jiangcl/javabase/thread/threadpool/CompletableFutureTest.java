package com.jiangcl.javabase.thread.threadpool;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * @author jiangcl
 * @date 2020/9/30
 * @desc
 *      使用线程池执行有返回值的线程
 *      CompletableFuture.supplyAsync(()->{return obj;},pool).whenComplete((r,e)->{});
 */
public class CompletableFutureTest {

    public static void main(String[] args) {
        ExecutorService pool = Executors.newFixedThreadPool(8);
        System.out.println("主线程开始执行......");
        CompletableFuture<String> f1 =  CompletableFuture.supplyAsync(()->{
            System.out.println("f1开始执行......");
            return "a";
        },pool).whenComplete((r,e)->{
            /**
             *  r是上一步的执行结果
             *  e是上一步执行时出现的异常
             *  可在whenComplete中，按自己需求处理这两个参数
             */
            System.out.println("f1的结果是：" + r);
            System.out.println(e);
        });
        CompletableFuture<Integer> f2 =  CompletableFuture.supplyAsync(()->{
            System.out.println("f2开始执行......");
            return 100;
        },pool).whenComplete((r,e)->{
            System.out.println("f2的结果是：" + r);
            System.out.println(e);
        });
        CompletableFuture<Integer> f3 =  CompletableFuture.supplyAsync(()->{
            System.out.println("f3开始执行......");
            int i = 1/0;
            return 100;
        },pool).whenComplete((r,e)->{
            System.out.println("f3的结果是：" + r);
            System.out.println(e);
        });
        /**
         * allOf(CompletableFuture...)
         * 使用此方法可以阻塞线程
         */
        //CompletableFuture.allOf(f1,f2,f3);
        pool.shutdown();
        System.out.println("主线程执行结束......");

    }
}
