package com.jiangcl.javabase.factory.factorymethod;

/**
 * @author jiangcl
 * @date 2019/12/4
 * @desc 定义一个华为工厂工厂，实现FactoryIn接口
 */
public class HuaweiFactory implements FactoryIn {
    @Override
    public ComputerIn getComputer() {
        return new HuaweiCom();
    }
}
