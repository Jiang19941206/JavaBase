package com.jiangcl.javabase.factory.abstractfactory;

/**
 * @author jiangcl
 * @date 2019/12/4
 * @desc 定义一个小米手机类，实现手机产品接口
 */
public class XiaomiPhone implements PhoneIn {
    @Override
    public void produce() {
        System.out.println("你好，我是小米手机");
    }
}
