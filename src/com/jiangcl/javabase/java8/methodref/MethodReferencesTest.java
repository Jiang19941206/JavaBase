package com.jiangcl.javabase.java8.methodref;

import org.junit.Test;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

/**
 * @author jiangcl
 * @date 2019/12/9
 * @desc 方法引用测试
 */
public class MethodReferencesTest {

    /**
     * 情景一
     * 对象 :: 非静态方法
     */
    @Test
    public void test1(){
        MyFunMethod myFunMethod = new MyFunMethod();
        Consumer<String> consumer = myFunMethod::acceptMethod;
        consumer.accept("使用情景一实现消费型函数式接口");
    }

    /**
     * 情景一
     * 对象 :: 非静态方法
     */
    @Test
    public void test(){
        MyFunMethod myFunMethod = new MyFunMethod();
        Function<String,Integer> fun = myFunMethod::funMethod;
        Integer apply = fun.apply("10");
        System.out.println(apply);
    }

    /**
     * 情景二
     * 类 :: 静态方法
     */
    @Test
    public void test2(){
        Supplier<String> supplier = MyFunMethod::supplierMethod;
        System.out.println(supplier.get());
    }

    /**
     * 情景三
     * 类 :: 非静态方法
     * 此方法是将类的对象作为参数传入，然后通过这个实例调用此类的方法
     */
    @Test
    public void test3(){
        MyFunMethod myFunMethod = new MyFunMethod("使用情景三实现函数型函数式接口");
        Function<MyFunMethod,String> function = MyFunMethod::functionMethod;
        String s = function.apply(myFunMethod);
        System.out.println(s);
    }

    /**
     * 情景三
     * 使用自定义函数式接口模拟
     */
    @Test
    public void test4(){
        MyFunMethod myFunMethod1 = new MyFunMethod("构造器1");
        MyFunMethod myFunMethod2 = new MyFunMethod("构造器2");
        FunctionMethodIn<MyFunMethod> fun = MyFunMethod::myFunctionMethod;
        String s = fun.method(myFunMethod1, myFunMethod2);
        System.out.println(s);
    }
}
