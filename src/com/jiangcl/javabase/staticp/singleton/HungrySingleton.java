package com.jiangcl.javabase.staticp.singleton;

/**
 * @author jiangcl
 * @date 2019/12/5
 * @desc 单例模式之饿汉模式
 */
public class HungrySingleton {

    //将构造器声明为私有
    private HungrySingleton(){}

    //创建类的对象
    private static HungrySingleton instance = new HungrySingleton();

    //对外提供获取对象的方法
    public static HungrySingleton getInstance(){
        return instance;
    }
}
