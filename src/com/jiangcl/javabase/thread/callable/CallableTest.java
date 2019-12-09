package com.jiangcl.javabase.thread.callable;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * @author jiangcl
 * @date 2019/12/9
 * @desc 实现Callable方式创建多线程
 */
public class CallableTest {

    public static void main(String[] args) {
        //创建Callable实现类的对象
        CallableThread callableThread = new CallableThread();
        //创建FutureTask对象
        FutureTask<Integer> futureTask = new FutureTask<>(callableThread);
        //创建一个thread对象
        new Thread(futureTask).start();

        //使用此方法可以获取线程返回的执行结果
        try {
            Integer sum = futureTask.get();
            System.out.println("总和为：" + sum);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }
}
