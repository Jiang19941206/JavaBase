package com.jiangcl.javabase.java8.lambda;

import org.junit.Test;

import java.util.Comparator;
import java.util.function.Consumer;

/**
 * @author jiangcl
 * @date 2019/12/9
 * @desc java8之lambda表达式
 */
public class LambdaTest {

    //无参无返回值
    @Test
    public void test1(){
        Runnable r = new Runnable() {
            @Override
            public void run() {
                System.out.println("无参无返回值原表达式");
            }
        };
        r.run();
        System.out.println("**********************");
        //() -> System.out.println("无参无返回值lambda表达式")；相当于是Runnable接口的一个实例
        Runnable r1 = () -> {System.out.println("无参无返回值lambda表达式"); };
        //上面可以简化为：Runnable r1 = () -> System.out.println("无参无返回值lambda表达式");
        r1.run();
    }

    //有参数无返回值
    @Test
    public void test2(){
        Consumer<String> con = new Consumer<String>() {
            @Override
            public void accept(String s) {
                System.out.println(s);
            }
        };
        con.accept("有参数无返回值非原表达式");
        System.out.println("***************************");
        Consumer<String> con1 = (String s) -> {
            System.out.println(s);
        };
        con1.accept("有参数无返回值lambda表达式");
        System.out.println("***************************");
        /**
         * 数据类型可以省略，因为可有编译器推断得出，称为“类型推断”
         * 下面的例子中，泛型已经明确了数据类型，所以表达式中无序指定数据类型。
         */
        Consumer<String> con2 = (s) -> {
            System.out.println(s);
        };
        con2.accept("有参数无返回值lambda表达式，省略数据类型");
    }

    /**
     * 若lambda表达式只需要一个参数时，参数的小括号可以省略
     */
    @Test
    public void test3(){
        Consumer<String> con1 = (s) -> {
            System.out.println(s);
        };
        con1.accept("有参数无返回值lambda表达式，参数有括号");
        System.out.println("***************************");
        Consumer<String> con2 = s -> {
            System.out.println(s);
        };
        con2.accept("有参数无返回值lambda表达式，参数无括号");
    }

    //有参数有返回值
    @Test
    public void test4(){
        Comparator<Integer> com1 = (o1,o2) -> {
            System.out.println(o1);
            System.out.println(o1);
            return o1.compareTo(o2);
        };
        int i = com1.compare(23, 22);
        System.out.println(i);
    }

    //当lambda表达式只有一条语句时，可以省略return和大括号（当有return时，return和大括号要么都省略，要不都不省略）
    @Test
    public void test5(){
        //例1
        Comparator<Integer> com = (o1,o2) -> o1.compareTo(o2);
        System.out.println(com.compare(18,14));
        System.out.println("********************");
        //例2
        Consumer<String> con = s -> System.out.println(s);
        con.accept("这是一条语句");
    }
}
