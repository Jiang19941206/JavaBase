package com.jiangcl.javabase.staticp.singleton;

/**
 * @author jiangcl
 * @date 2019/12/5
 * @desc 单例模式之懒汉模式
 */
public class LazySingleton {

    //将构造方法声明为private
    private LazySingleton(){}

    //声明类的对象，不初始化
    private static LazySingleton instance = null;

    /*
    *对外提供获取对象的方法
    * 由于懒汉模式存在线程不安全问题，所以加上synchronized关键字
     */
    public static LazySingleton getInstance(){
        //第一重判断是为了防止当已经有对象存在时，进入同步代码块中的判断。
            if(instance == null){
                synchronized (LazySingleton.class){
                    if(instance == null){
                        instance = new LazySingleton();
                    }
                }
            }
        return instance;
    }
}
