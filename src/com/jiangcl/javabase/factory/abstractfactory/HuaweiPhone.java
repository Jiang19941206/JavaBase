package com.jiangcl.javabase.factory.abstractfactory;

/**
 * @author jiangcl
 * @date 2019/12/4
 * @desc 定义一个华为手机类，实现手机产品接口
 */
public class HuaweiPhone implements PhoneIn {
    @Override
    public void produce() {
        System.out.println("你好，我是华为手机");
    }
}
