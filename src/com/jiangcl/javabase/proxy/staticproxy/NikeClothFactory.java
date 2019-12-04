package com.jiangcl.javabase.proxy.staticproxy;

/**
 * @author jiangcl
 * @date 2019/12/4
 * @description 被代理类
 */
public class NikeClothFactory implements ClothFactory {
    @Override
    public void produceCloth() {
        System.out.println("Nike工厂生产的服装");
    }
}
