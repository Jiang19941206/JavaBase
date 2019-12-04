package com.jiangcl.javabase.factory.abstractfactory;

import org.junit.Test;

/**
 * @author jiangcl
 * @date 2019/12/4
 * @desc 抽象工厂
 */
public class AbstractFactory {
    @Test
    public void test1(){
        //获取小米工厂
        FactoryIn xiaomiFactory = new XiaomiFactory();
        //获取手机工厂
        PhoneIn xiaomiFactoryPhone = xiaomiFactory.getPhone();
        //获取路由器工厂
        RouterIn xiaomiFactoryRouter = xiaomiFactory.getRouter();
        //使用小米的手机工厂生产小米手机
        xiaomiFactoryPhone.produce();
        //使用小米的路由器工厂生产小米路由器
        xiaomiFactoryRouter.produce();

        FactoryIn huaweiFactory = new HuaweiFactory();
        RouterIn huaweiFactoryRouter = huaweiFactory.getRouter();
        PhoneIn huaweiFactoryPhone = huaweiFactory.getPhone();

        huaweiFactoryRouter.produce();
        huaweiFactoryPhone.produce();
    }
}
