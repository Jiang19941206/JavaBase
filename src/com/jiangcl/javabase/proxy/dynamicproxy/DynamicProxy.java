package com.jiangcl.javabase.proxy.dynamicproxy;

import com.jiangcl.javabase.proxy.staticproxy.ClothFactory;
import com.jiangcl.javabase.proxy.staticproxy.NikeClothFactory;
import org.junit.Test;

/**
 * @author jiangcl
 * @date 2019/12/4
 * @description 动态代理测试
 *  步骤一：创建代理对象
 *  步骤二：通过调用代理对象方法调用被代理对象的方法
 */
public class DynamicProxy {

    @Test
    public void test1(){
        //创建被代理类的对象
        Student student = new Student();
        //创建被代理类的对象，生成的proxyObj与被代理对象student实现的是同一个接口
        Person proxyObj = (Person) ProxyFactory.proxyFactory(student);
        String identity = proxyObj.getIdentity();
        System.out.println(identity);
        String personInfo = proxyObj.getPersonInfo("三年级");
        System.out.println(personInfo);
        proxyObj.showName("张三");
        System.out.println("********************************");
        NikeClothFactory nikeClothFactory = new NikeClothFactory();
        ClothFactory clothFactory = (ClothFactory) ProxyFactory.proxyFactory(nikeClothFactory);
        clothFactory.produceCloth();
        System.out.println("********************************");
        //当被代理对象实现了多个接口时，需要调哪个接口的方法创建的代理对象就为哪个接口的实例
        User user = (User) ProxyFactory.proxyFactory(student);
        user.showUserSex("男");
    }
}
