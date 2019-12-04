package com.jiangcl.javabase.proxy.staticproxy;

import org.junit.Test;

/**
 * @author jiangcl
 * @date 2019/12/4
 * @description 静态代理
 */
public class StaticProxy {

    @Test
    public void test1(){
        //创建被代理类的对象
        NikeClothFactory nikeClothFactory = new NikeClothFactory();
        //创建代理类的对象
        ProxyFactory proxyFactory = new ProxyFactory(nikeClothFactory);
        proxyFactory.produceCloth();
    }
}
