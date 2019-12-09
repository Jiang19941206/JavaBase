package com.jiangcl.javabase.thread.callable;

import java.util.concurrent.Callable;

/**
 * @author jiangcl
 * @date 2019/12/9
 * @desc
 */
public class CallableThread implements Callable<Integer> {
    @Override
    public Integer call() throws Exception {
        int sum = 0;
        for(int i = 1;i <= 100;i++){
            if(i % 2 == 0){
                System.out.println(i);
                sum += i;
            }
        }
        return sum;
    }
}
