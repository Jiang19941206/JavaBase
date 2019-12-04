package com.jiangcl.javabase.reflect;

import java.util.Date;

/**
 * @author jiangcl
 * @date 2019/12/4
 * @desc 定义一个类
 */
public class Product {

    private int id;

    private String name;

    private Date date;

    //定义一个空参数的构造函数
    public Product(){}

    //定义一个公共的构造函数
    public Product(String name){
        this.name = name;
    }

    //定义一个私有的构造函数
    private Product(String name,int age){
        this.name = name;
        this.id = id;
    }

    public void showProduct(){
        System.out.println("这是空参数的公共方法");
    }

    public String showWithParam(String param){
        System.out.println("这是带有参数并且有返回值的公共方法");
        return param;
    }

    private String showPrivateMethod(String param){
        System.out.println("这是带有参数并且有返回值的私有方法");
        return param;
    }

    public static String showStaticMethod(String param){
        System.out.println("这是带有参数并且有返回值的静态方法");
        return param;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", date=" + date +
                '}';
    }
}
