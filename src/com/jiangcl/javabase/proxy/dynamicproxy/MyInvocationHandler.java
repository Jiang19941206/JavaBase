package com.jiangcl.javabase.proxy.dynamicproxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @author jiangcl
 * @date 2019/12/4
 * @description 执行代理类的方法
 */
public class MyInvocationHandler implements InvocationHandler {
    /**
     * 被代理的对象
     */
    private Object obj;

    public MyInvocationHandler(Object obj){
        this.obj = obj;
    }

    /**
     * 代理对象的执行方法，当调用代理类的方法时会进入此方法，通过此方法调用被代理类的方法
     * @param proxy
     * @param method
     * @param args
     * @return
     * @throws Throwable
     */
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        /*String name = method.getName();
        System.out.println("调用了方法：" + name);*/
        Object returnValue = method.invoke(obj, args);//调用被代理类的方法
        return returnValue;
    }
}
