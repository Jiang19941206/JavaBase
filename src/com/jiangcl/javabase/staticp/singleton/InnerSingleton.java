package com.jiangcl.javabase.staticp.singleton;

/**
 * @author jiangcl
 * @date 2019/12/5
 * @desc 内部类实现单例模式
 */
public class InnerSingleton {
    //将构造器声明为私有
    private InnerSingleton(){}

    //将内部类定义为私有
    private static class InstanceClass{
        //定义一个外部类类型的参数，并进行实例化
        public static final InnerSingleton instance = new InnerSingleton();
    }

    //对外提供获取对象的方法
    public static InnerSingleton getInstance(){
        return InstanceClass.instance;
    }
}
