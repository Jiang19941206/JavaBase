package com.jiangcl.javabase.thread.threadpool;

import java.util.concurrent.*;

/**
 * @author jiangcl
 * @date 2020/9/30
 * @desc
 *      使用线程池执行有返回值的线程
 *      CompletableFuture.supplyAsync(()->{return obj;},pool).whenComplete((r,e)->{});
 */
public class CompletableFutureTest {

    public static void main(String[] args) throws Exception {
        ExecutorService pool = Executors.newFixedThreadPool(8);
        System.out.println("主线程开始执行......");

        /*System.out.println(method1(pool));
        System.out.println(method2(pool));
        System.out.println(method3(pool));*/

        CompletableFuture<String> f1 =  CompletableFuture.supplyAsync(()->{
            System.out.println("f1开始执行......");
            try {
                TimeUnit.SECONDS.sleep(3);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
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

        CompletableFuture<String> f3 =  CompletableFuture.supplyAsync(()->{
            System.out.println("f3开始执行......");
            //int i = 1/0;
            return "f3 result";
        },pool).whenComplete((r,e)->{
            System.out.println("f3的结果是：" + r);
            System.out.println(e);
        });
        /**
         * 使用此方法阻塞此次执行，等待所有线程完成后再执行后面的逻辑
         */
        CompletableFuture<Void> allOf = CompletableFuture.allOf(f1, f2, f3);
        allOf.join();
        
        System.out.println("主线程执行结束......");

    }

    public static String method1(ExecutorService pool) throws ExecutionException, InterruptedException {

        //String result = f1.get();
        return "";
    }

    public static Integer method2(ExecutorService pool) throws ExecutionException, InterruptedException {
        CompletableFuture<Integer> f2 =  CompletableFuture.supplyAsync(()->{
            System.out.println("f2开始执行......");
            return 100;
        },pool).whenComplete((r,e)->{
            System.out.println("f2的结果是：" + r);
            System.out.println(e);
        });
        return f2.get();
    }

    public static String method3(ExecutorService pool) throws ExecutionException, InterruptedException {
        CompletableFuture<String> f3 =  CompletableFuture.supplyAsync(()->{
            System.out.println("f3开始执行......");
            //int i = 1/0;
            return "f3 result";
        },pool).whenComplete((r,e)->{
            System.out.println("f3的结果是：" + r);
            System.out.println(e);
        });
        return f3.get();
    }
}
