package com.jiangcl.javabase.factory.factorymethod;

import org.junit.Test;

/**
 * @author jiangcl
 * @date 2019/12/4
 * @desc 工厂方法模式
 */
public class FactoryMethod {
    @Test
    public void test1() throws Exception{
        //通过反射动态获取工厂对象
        FactoryIn huaweiFactory = (FactoryIn) Class.forName("com.jiangcl.javabase.factory.factorymethod.HuaweiFactory").newInstance();
        FactoryIn lenovoFactory = (FactoryIn) Class.forName("com.jiangcl.javabase.factory.factorymethod.LenovoFactory").newInstance();
        //通过工厂获取对象
        ComputerIn huaweiFactoryComputer = huaweiFactory.getComputer();
        ComputerIn lenovoFactoryComputer = lenovoFactory.getComputer();
        //执行方法
        huaweiFactoryComputer.produce();
        lenovoFactoryComputer.produce();
    }
}
