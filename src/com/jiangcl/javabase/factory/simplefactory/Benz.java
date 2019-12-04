package com.jiangcl.javabase.factory.simplefactory;

/**
 * @author jiangcl
 * @date 2019/12/4
 * @desc 定义一个类并实现接口
 */
public class Benz implements Car {
    /**
     * @desc 重写produce方法
     * @author jiangcl
     * @date 2019/12/4
     * @param
     * @return void
     */
    @Override
    public void produce() {
        System.out.println("你好，我是奔驰");
    }
}
