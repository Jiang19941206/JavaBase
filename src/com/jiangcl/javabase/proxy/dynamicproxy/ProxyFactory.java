package com.jiangcl.javabase.proxy.dynamicproxy;

import java.lang.reflect.Proxy;

/**
 * @author jiangcl
 * @date 2019/12/4
 * @description 创建代理对象
 */
public class ProxyFactory {

    /**
     * @description 创建代理对象
     * @author jiangcl
     * @date 2019/12/4
     * @param obj 被代理对象
     * @return java.lang.Object
     */
    public static Object proxyFactory(Object obj){
        MyInvocationHandler handler = new MyInvocationHandler(obj);
        return Proxy.newProxyInstance(obj.getClass().getClassLoader(),obj.getClass().getInterfaces(),handler);
    }
}
