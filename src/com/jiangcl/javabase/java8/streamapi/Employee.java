package com.jiangcl.javabase.java8.streamapi;

import java.util.ArrayList;
import java.util.List;

/**
 * @author jiangcl
 * @date 2019/12/10
 * @desc 一个实体类
 */
public class Employee {
    private Integer id;

    private Integer age;

    private String name;

    public Employee(Integer id, Integer age, String name) {
        this.id = id;
        this.age = age;
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", age=" + age +
                ", name='" + name + '\'' +
                '}';
    }

    public static List<Employee> getEmployees(){
        List<Employee> employees = new ArrayList<>();
        employees.add(new Employee(1001,32,"tom"));
        employees.add(new Employee(1002,25,"jerry"));
        employees.add(new Employee(1003,27,"lucy"));
        employees.add(new Employee(1004,21,"stark"));
        employees.add(new Employee(1005,45,"jordan"));
        return employees;
    }
}
