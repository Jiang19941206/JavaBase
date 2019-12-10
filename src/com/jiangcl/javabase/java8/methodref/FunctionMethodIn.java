package com.jiangcl.javabase.java8.methodref;

/**
 * @author jiangcl
 * @date 2019/12/9
 * @desc 自定义方法引用的函数式接口
 */
@FunctionalInterface
public interface FunctionMethodIn<T> {
    String method(T t1 ,T t2);
}
