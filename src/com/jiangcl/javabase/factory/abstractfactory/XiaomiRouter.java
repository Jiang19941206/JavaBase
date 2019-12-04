package com.jiangcl.javabase.factory.abstractfactory;

/**
 * @author jiangcl
 * @date 2019/12/4
 * @desc 定义一个小米路由器类，实现路由器产品接口
 */
public class XiaomiRouter implements RouterIn {
    @Override
    public void produce() {
        System.out.println("你好，我是小米路由器");
    }
}
