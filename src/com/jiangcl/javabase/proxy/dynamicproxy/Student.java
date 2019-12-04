package com.jiangcl.javabase.proxy.dynamicproxy;

/**
 * @author jiangcl
 * @date 2019/12/4
 * @description 被代理类
 */
public class Student implements Person,User {
    @Override
    public void showName(String name) {
        System.out.println("这是学生：" + name);
    }

    @Override
    public String getIdentity() {
        return "他的身份是学生";
    }

    @Override
    public String getPersonInfo(String personInfo) {
        return "这是 " + personInfo + " 的学生";
    }

    @Override
    public void showUserSex(String sex) {
        System.out.println("该用户性别为：" + sex);
    }
}
