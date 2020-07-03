package com.jiangcl.javabase.java8.streamapi;

import org.junit.Test;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author jiangcl
 * @date 2019/12/10
 * @desc stream终止操作测试
 */
public class StreamApiTermination {

    /**
     * 匹配与查找
     */
    @Test
    public void test1(){
        List<Employee> employees = Employee.getEmployees();
        //1、allMatch(Predicate<? super T> predicate)判断是否所有元素都匹配相应条件（全部满足则返回true）
                //练习：是否所有employee的年龄都大于25
        boolean b = employees.stream().allMatch(employee -> employee.getAge() > 25);
        System.out.println(b);
        System.out.println("****************");
        //2、anyMatch(Predicate<? super T> predicate)判断是否有元素满足相应条件（其中有一个满足则返回true）
                //练习：是否有employee的年龄小于30
        boolean b1 = employees.stream().anyMatch(employee -> employee.getAge() < 30);
        System.out.println(b1);
        System.out.println("****************");
        //3、noneMatch(Predicate<? super T> predicate)判断是否所有元素都不满足相应条件（所有元素都不满足则返回true）
                //练习：是否没有年龄大于50的employee
        boolean b2 = employees.stream().noneMatch(employee -> employee.getAge() > 50);
        System.out.println(b2);
        System.out.println("****************");
        //4、findFirst()返回第一个元素
                //练习：返回年龄最小的employee
        Optional<Employee> first = employees.stream().sorted((e1,e2) -> e1.getAge().compareTo(e2.getAge())).findFirst();
        System.out.println(first);
        System.out.println("****************");
        //5、findAny()取stream当中的任意一个元素
        Optional<Employee> any = employees.stream().findAny();
        System.out.println(any);
        System.out.println("****************");
        //6、count()返回stream中元素的个数
                //练习：返回年龄大于25的employee个数
        long count = employees.stream().filter(employee -> employee.getAge() > 25).count();
        System.out.println(count);
        System.out.println("****************");
        //7、max()返回指定指标最大的元素
                //练习：返回年龄最大的employee
        Optional<Employee> max = employees.stream().max((e1, e2) -> e1.getAge().compareTo(e2.getAge()));
        System.out.println(max);
        //8、min()返回指定指标最小的元素
                //练习：返回年龄最小的employee的年龄
        Optional<Integer> min = employees.stream().map(employee -> employee.getAge()).min((o1, o2) -> o1.compareTo(o2));
        System.out.println(min);
    }

    /**
     * 归约
     */
    @Test
    public void test2(){
        List<Employee> employees = Employee.getEmployees();
        //reduce(T identity, BinaryOperator<T> accumulator) 可以将流中的元素反复结合起来，得到一个值。返回T
            //练习：计算1-10的自然数之和
        List<Integer> is = Arrays.asList(1,2,3,4,5,6,7,8,9,10);
        //identity：初始值。lambda表达式写法
        Integer reduce = is.stream().reduce(0, (i1,i2)->Integer.sum(i1,i2));
        //方法引用的写法
        Integer reduce1 = is.stream().reduce(0, Integer::sum);
        System.out.println(reduce);
        System.out.println(reduce1);
        System.out.println("*****************");
        //reduce(BinaryOperator<T> accumulator)可以将流中的元素反复结合起来，得到一个值。返回Optional<T>
            //练习：获取集合中所有员工的年龄总和
        Optional<Integer> reduce2 = employees.stream().map(employee -> employee.getAge()).reduce(Integer::sum);
        System.out.println(reduce2);
    }

    /**
     * 收集
     */
    @Test
    public void test3(){
        /**
         * collect(Collector c) 将流转换为其他形式，接收一个Collector接口的实现，用于给stream中的元素做汇总的方法
         * 可以收集成一个List或Set或Map
         */
                //练习：找出年龄大于25的员工，并返回一个List
        List<Employee> employees = Employee.getEmployees();
        List<Employee> list = employees.stream().filter(employee -> employee.getAge() > 25).collect(Collectors.toList());
        list.forEach(employee -> System.out.println(employee));
        System.out.println("****************");
                //练习：找出年龄小于等于25的员工，并返回一个Set
        Set<Employee> set = employees.stream().filter(employee -> employee.getAge() <= 25).collect(Collectors.toSet());
        set.forEach(employee -> System.out.println(employee));
        System.out.println("****************");
                //练习：找出年龄大于25的员工，并返回一个Map
        Map<String, Employee> employeeMap = employees.stream().filter(employee -> employee.getAge() > 25).collect(Collectors.toMap(employee -> employee.getId().toString(), employee -> employee));
        for (String s : employeeMap.keySet()) {
            System.out.println(s);
            System.out.println(employeeMap.get(s));
        }
    }

    @Test
    public void test4(){

        List<Employee> employees = Employee.getEmployees();
        employees = employees.stream().sorted(Employee::compare).collect(Collectors.toList());
        System.out.println(employees);
    }
}
