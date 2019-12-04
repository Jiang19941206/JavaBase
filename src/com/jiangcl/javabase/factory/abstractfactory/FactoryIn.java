package com.jiangcl.javabase.factory.abstractfactory;

/**
 * @author jiangcl
 * @date 2019/12/4
 * @desc 定义一个工厂接口
 */
public interface FactoryIn {
    /**
     * @desc 生产手机产品
     * @author jiangcl
     * @date 2019/12/4
     * @param
     * @return com.jiangcl.javabase.factory.abstractfactory.PhoneIn
     */
    PhoneIn getPhone();

    /**
     * @desc 生产路由器产品
     * @author jiangcl
     * @date 2019/12/4
     * @param
     * @return com.jiangcl.javabase.factory.abstractfactory.RouterIn
     */
    RouterIn getRouter();
}
