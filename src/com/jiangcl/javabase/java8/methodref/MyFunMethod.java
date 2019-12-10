package com.jiangcl.javabase.java8.methodref;

/**
 * @author jiangcl
 * @date 2019/12/9
 * @desc 方法引用类（此处也模拟Java内置的4大核心函数式接口）
 */
public class MyFunMethod {

    private String desc;

    public MyFunMethod(){}

    public MyFunMethod(String desc){
        this.desc = desc;
    }

    /**
     * 消费型：Consumer<T>    void accept(T t);
     */
    public void acceptMethod(String s){
        System.out.println(s);
    }

    /**
     * 供给型：Supplier<T>    T get();
     * @return
     */
    public static String supplierMethod(){
        return "使用情景二实现供给型函数式接口";
    }

    /**
     * 函数型：Function<T,R>  R apply(T t);
     * @return
     */

    public Integer funMethod(String num){
        return Integer.parseInt(num);
    }

    /**
     * 函数型：Function<T,R>  R apply(T t);
     * @return
     */
    public String functionMethod(){
        return this.desc;
    }

    /**
     * 使用自定义的函数式接口实现方法引用情景三
     * @param obj
     * @return
     */
    public String myFunctionMethod(MyFunMethod obj){
        String strReturn = this.desc + "<<<<>>>>" + obj.desc;
        return strReturn;
    }

    public String getDesc() {
        return desc;
    }
}
