package com.jiangcl.javabase.annotation;

/**
 * @author jiangcl
 * @date 2019/12/13
 * @desc
 */
@MyAnnotation("我是修饰的类")
public class Person {
    @MyAnnotation("张三")
    private String name;

    @MyAnnotation("张三")
    public String getName(String name){
        System.out.println("*************getName************");
        return name;
    }

    public String getPersonName(@MyAnnotation("李四") String name){
        return name;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                '}';
    }
}
