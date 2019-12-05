package com.jiangcl.javabase.staticp.singleton;

/**
 * @author jiangcl
 * @date 2019/12/5
 * @desc
 */
public class CodeBlock {
    private String name;

    private String age;

    public static String desc;

    static {
        System.out.println("这是静态代码块");
    }

    {
        System.out.println("这是非静态代码块");
    }
}
