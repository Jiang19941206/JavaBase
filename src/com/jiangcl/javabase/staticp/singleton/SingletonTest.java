package com.jiangcl.javabase.staticp.singleton;

import org.junit.Test;

/**
 * @author jiangcl
 * @date 2019/12/5
 * @desc 单例模式
 *        单例模式就是采取一定的方法，保证在整个系统中，对某个类只存在一个对象实例
 *        要是实现单例模式，需要将类的构造方法声明为private，防止外部创建此类的对象
 *        然后在类的内部创建该类的对象，并提供一个静态方法，返回创建的对象
 */
public class SingletonTest {

    /**
     * @desc 单例模式测试
     * @author jiangcl
     * @date 2019/12/5
     * @param
     * @return void
     */
    @Test
    public void test1(){
        //饿汉式
        HungrySingleton instance1 = HungrySingleton.getInstance();
        HungrySingleton instance2 = HungrySingleton.getInstance();
        System.out.println(instance1 == instance2);
        //懒汉式
        LazySingleton lazySingleton1 = LazySingleton.getInstance();
        LazySingleton lazySingleton2 = LazySingleton.getInstance();
        System.out.println(lazySingleton1 == lazySingleton2);
        //内部类实现
        InnerSingleton innerInstance1 = InnerSingleton.getInstance();
        InnerSingleton innerInstance2= InnerSingleton.getInstance();
        System.out.println(innerInstance1 == innerInstance2);
    }

    @Test
    public void test2(){
        //String desc = CodeBlock.desc;
        CodeBlock c1 = new CodeBlock();
        CodeBlock c2 = new CodeBlock();
    }
}
