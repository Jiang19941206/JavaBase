package com.jiangcl.javabase.factory.abstractfactory;

/**
 * @author jiangcl
 * @date 2019/12/4
 * @desc 定义一个华为工厂，实现工厂接口
 */
public class HuaweiFactory implements FactoryIn {
    @Override
    public PhoneIn getPhone() {
        return new HuaweiPhone();
    }

    @Override
    public RouterIn getRouter() {
        return new HuaweiRouter();
    }
}
