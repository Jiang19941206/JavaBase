package com.jiangcl.javabase.factory.abstractfactory;

/**
 * @author jiangcl
 * @date 2019/12/4
 * @desc 定义一个小米工厂类，实现工厂接口
 */
public class XiaomiFactory implements FactoryIn {
    @Override
    public PhoneIn getPhone() {
        return new XiaomiPhone();
    }

    @Override
    public RouterIn getRouter() {
        return new XiaomiRouter();
    }
}
