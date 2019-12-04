package com.jiangcl.javabase.proxy.staticproxy;

/**
 * @author jiangcl
 * @date 2019/12/4
 * @description 代理类
 */
public class ProxyFactory implements ClothFactory {
    private ClothFactory clothFactory;//使用被代理类对象进行实例化

    public ProxyFactory(ClothFactory clothFactory){
        this.clothFactory = clothFactory;
    }

    /**
     * @description 通过代理类调用被代理类的方法实现代理
     * @author jiangcl
     * @date 2019/12/4
     * @param
     * @return void
     */
    @Override
    public void produceCloth() {
        System.out.println("代理工厂开始代理");
        clothFactory.produceCloth();//调用被代理类的方法
        System.out.println("代理工厂代理完成");
    }
}
