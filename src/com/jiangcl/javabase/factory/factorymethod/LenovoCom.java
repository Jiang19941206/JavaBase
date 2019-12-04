package com.jiangcl.javabase.factory.factorymethod;

/**
 * @author jiangcl
 * @date 2019/12/4
 * @desc 定义一个联想电脑类，并实现接口
 */
public class LenovoCom implements ComputerIn {
    @Override
    public void produce() {
        System.out.println("你好我是联想电脑");
    }
}
