package com.jiangcl.javabase.factory.simplefactory;

import org.junit.Test;

/**
 * @author jiangcl
 * @date 2019/12/4
 * @desc 简单工厂模式
 */
public class FactoryTest {

    /**
     * @desc 简单工厂
     * @author jiangcl
     * @date 2019/12/4
     * @param
     * @return void
     */
    @Test
    public void test1(){
        Car car = CarFactory.getCar(CarType.BMW);
        car.produce();

        Car car1 = CarFactory.getCar(CarType.BENZ);
        car1.produce();
    }
}
