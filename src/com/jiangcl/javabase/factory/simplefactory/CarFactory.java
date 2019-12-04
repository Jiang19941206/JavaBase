package com.jiangcl.javabase.factory.simplefactory;

/**
 * @author jiangcl
 * @date 2019/12/4
 * @desc 创建一个工厂
 */
public class CarFactory {

    /**
     * @desc 创建一个生成实例的方法
     * @author jiangcl
     * @date 2019/12/4
     * @param carType
     * @return com.jiangcl.javabase.factory.simplefactory.Car
     */
    public static Car getCar(CarType carType){
        switch (carType){
            case BENZ:
                return new Benz();
            case BMW:
                return new Bmw();
                default:
                    return null;
        }
    }
}
