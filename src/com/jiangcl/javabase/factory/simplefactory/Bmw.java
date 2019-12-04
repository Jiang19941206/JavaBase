package com.jiangcl.javabase.factory.simplefactory;

/**
 * @author jiangcl
 * @date 2019/12/4
 * @desc 定义一个类并实现接口
 */
public class Bmw implements Car {
    @Override
    public void produce() {
        System.out.println("你好，我是宝马");
    }
}
