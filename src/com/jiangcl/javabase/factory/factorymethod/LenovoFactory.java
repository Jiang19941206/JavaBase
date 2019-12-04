package com.jiangcl.javabase.factory.factorymethod;

/**
 * @author jiangcl
 * @date 2019/12/4
 * @desc 定义一个联想工厂，实现FactoryIn接口
 */
public class LenovoFactory implements FactoryIn {
    @Override
    public ComputerIn getComputer() {
        return new LenovoCom();
    }
}
