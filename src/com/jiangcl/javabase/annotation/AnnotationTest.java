package com.jiangcl.javabase.annotation;

import org.junit.Test;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * @author jiangcl
 * @date 2019/12/13
 * @desc 自定义注解练习
 */
public class AnnotationTest {

    /**
     * 获取类的注解信息
     * @throws Exception
     */
    @Test
    public void test1() throws Exception {
        Class clazz = Person.class;
        //获取类上面的注解
        MyAnnotation annotation = (MyAnnotation) clazz.getAnnotation(MyAnnotation.class);
        String value = annotation.value();
        System.out.println(value);
    }

    /**
     * 获取方法上的注解信息
     */
    @Test
    public void test2() throws Exception {
        Class clazz = Person.class;
        Person person = (Person) clazz.newInstance();
        //获取方法（以一个方法为例）
        Method method = clazz.getDeclaredMethod("getName",String.class);

        MyAnnotation annotation = method.getAnnotation(MyAnnotation.class);
        String personName = annotation.value();

        //将注解的值作为此方法的返回值
        if(!method.isAccessible()){
            method.setAccessible(true);
        }
        Object str = method.invoke(person,personName);
        System.out.println(str);
    }

    /**
     * 获取属性上的注解信息
     */
    @Test
    public void test3() throws Exception {
        Class clazz = Person.class;
        Person person = (Person) clazz.newInstance();

        //获取字段
        Field field = clazz.getDeclaredFields()[0];

        //获取注解信息
        MyAnnotation annotation = field.getAnnotation(MyAnnotation.class);
        String value = annotation.value();

        if(!field.isAccessible()){
            field.setAccessible(true);
        }
        field.set(person,value);

        System.out.println(person);
    }
}
