package com.jiangcl.javabase.java8.functionin;

import org.junit.Test;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

/**
 * @author jiangcl
 * @date 2019/12/9
 * @desc 函数式接口测试
 */
public class FunctionInTest {

    /**
     * 练习
     * 自建函数式接口
     */
    @Test
    public void test1(){
        MyFunctionIn in1 = () -> System.out.println("这是我的第一个函数式接口");
        in1.send();
    }

    /**
     * 练习：
     * 消费型：Consumer<T>    void accept(T t);
     */
    @Test
    public void test2(){
        consumerFun("消费型函数式接口练习",s -> System.out.println(s));
    }

    public void consumerFun(String s,Consumer<String> consumer){
        consumer.accept(s);
    }

    /**
     * 练习
     * 供给型：Supplier<T>    T get();
     */
    @Test
    public void test3(){
        String s = supplier(() -> "供给型函数式接口练习");
        System.out.println(s);
    }

    public String supplier(Supplier<String> supplier){
        String strReturn = supplier.get();
        return strReturn;
    }

    /**
     * 练习
     * 函数型：Function<T,R>  R apply(T t);
     */
    @Test
    public void test4(){
        String s = function(50, i -> String.valueOf(i));
        System.out.println(s);
    }

    public String function(Integer s, Function<Integer,String> function){
        String strReturn = function.apply(s);
        return strReturn;
    }

    /**
     * 练习
     * 断定型：Predicate<T>   boolean test(T t);
     */
    @Test
    public void test5(){
        String sReturn = predicate("北京", s -> s.contains("京"));
        System.out.println(sReturn);
    }

    public String predicate(String s, Predicate<String> predicate){
        String strReturn = null;
        if(predicate.test(s)){
            strReturn = "TRUE";
        }else strReturn = "FALSE";
        return strReturn;
    }
}
