package com.jiangcl.javabase.java8.streamapi;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

/**
 * @author jiangcl
 * @date 2019/12/10
 * @desc stream的中间操作测试
 */
public class StreamApiOperation {

    /**
     * 筛选与切片
     */
    @Test
    public void test1(){
        List<String> strs = new ArrayList<>();
        strs.add("a");
        strs.add("abd");
        strs.add("as");
        strs.add("fdfgdf");
        strs.add("etrherh");
        //filter(Predicate<T> predicate) 从流中过滤某些数据（过滤掉不符合条件的数据）
        strs.stream().filter(s -> !s.contains("a")).forEach(s -> System.out.println(s));
        System.out.println("******************");
        //limit(n) 截断流，使元素不超过指定数量
        strs.stream().limit(3).forEach(s -> System.out.println(s));
        System.out.println("******************");
        //skip(n) 调过元素，返回一个扔掉n个元素的流，若流中元素不足n个，则返回一个空流，与limit(n)互补
        strs.stream().skip(3).forEach(s -> System.out.println(s));
        System.out.println("******************");
        //distinct 筛选，通过流所生成元素的hashCode()和equals()去除重复元素
        strs.add("a");
        strs.add("a");
        strs.add("adddddd");
        strs.stream().distinct().forEach(s -> System.out.println(s));
    }

    /**
     * 映射
     * map(Function fun)接收一个函数作为参数，将元素转换成其他形式或提取信息
     *                  该函数会被应用到每个元素上，并将其映射成一个新的元素
     */
    @Test
    public void test2(){
        //例1，将集合中的字幕转换为大写
        List<String> strs = new ArrayList<>();

        strs.add("java");
        strs.add("php");
        strs.add("python");
        strs.add("go");
        strs.add("android");
        strs.stream().map(s -> s.toUpperCase()).forEach(s -> System.out.println(s));
        System.out.println("******************");
        //例2，将集合中元素长度大于3的转为大写
        strs.stream().filter(s -> s.length()>3).map(s -> s.toUpperCase()).forEach(s -> System.out.println(s));
    }

    /**
     * flatMap(Function f) 接收一个函数作为参数，将流中的每个值都换成另一个流，然后把所有的流连成一个流
     */
    @Test
    public void test3(){
        List<String> chars = new ArrayList<>();

        chars.add("java");
        chars.add("php");
        //第一种写法
        chars.stream().flatMap(s -> {List<Character> cs = new ArrayList<>();
            for (char c : s.toCharArray()) {
                cs.add(c);
            }
            return cs.stream();}).forEach(s -> System.out.println(s));
        System.out.println("******************************");
        //第二种写法
        chars.stream().flatMap(StreamApiOperation::fromStringToStream).forEach(s -> System.out.println(s));
    }

    /**
     * stream.map()和stream.flatMap()的区别
     * 相当于是List.add()和List.addAll的区别
     * 前者是将整个流作为元素添加到原来的流中
     * 后者是将得到的流中的每个元素添加到原来的流中
     */
    @Test
    public void test4(){
        List<String> chars = new ArrayList<>();

        chars.add("java");
        chars.add("php");
        //使用map,此时得到的是一个流类型的流
        Stream<Stream<Character>> mapStream = chars.stream().map(StreamApiOperation::fromStringToStream);
        mapStream.forEach(s->{s.forEach(a -> System.out.println(a));});
        System.out.println("******************");
        //使用flatMap，此时得到的是一个Character类型的流
        Stream<Character> flatMapStream = chars.stream().flatMap(StreamApiOperation::fromStringToStream);
        flatMapStream.forEach(s -> System.out.println(s));
    }

    public static Stream<Character> fromStringToStream(String str){
        List<Character> cs = new ArrayList<>();
        for (char c : str.toCharArray()) {
            cs.add(c);
        }
        return cs.stream();
    }

    /**
     * 排序
     */
    @Test
    public void test5(){
        //自然排序
        List<Integer> ins = new ArrayList<>();
        ins.add(123);
        ins.add(23);
        ins.add(32);
        ins.add(432);
        ins.add(23);
        ins.add(54);
        ins.stream().sorted().forEach(System.out::println);
        System.out.println("********************");
        //定制排序
        ins.stream().sorted((o1,o2)->o1.compareTo(o2)).forEach(i -> System.out.println(i));
        System.out.println("*********************");
        //对对象进行定制排序
        List<Employee> employees = new ArrayList<>();
        employees.add(new Employee(1001,21,"张三"));
        employees.add(new Employee(1002,25,"李四"));
        employees.add(new Employee(1003,32,"王五"));
        employees.add(new Employee(1004,27,"赵六"));
        employees.add(new Employee(1005,25,"曾七"));
        employees.stream().sorted((o1,o2) -> {
            if(o1.getAge() != o2.getAge()){
                return o1.getAge().compareTo(o2.getAge());
            }
            return o1.getId().compareTo(o2.getId());
        }).forEach(e -> System.out.println(e));
    }
}
