package com.jiangcl.javabase.java8.streamapi;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * @author jiangcl
 * @date 2019/12/10
 * @desc stream api测试（创建stream）
 */
public class StreamApiCreate {

    /**
     * 方式一
     * 通过集合实例化Stream
     */
    @Test
    public void test1(){
        List<String> ls1 = Collections.synchronizedList(new ArrayList<>());
        List<String> ls2 = new CopyOnWriteArrayList<>();
        List<String> strs = new ArrayList<>();
        //顺序流
        Stream<String> stream = strs.stream();
        //并行流
        Stream<String> parallelStream = strs.parallelStream();
        stream.forEach(s -> System.out.println(s));
    }

    /**
     * 方式二
     * 通过数组实例化Stream
     */
    @Test
    public void test2(){
        int[] is = new int[]{1,2,3,4,5};
        //返回类型根据数据类型决定
        IntStream stream = Arrays.stream(is);
        stream.forEach(i -> System.out.println(i));
    }

    /**
     * 方式三
     * 通过stream的of()方法创建
     */
    @Test
    public void test3(){
        Stream<Integer> stream = Stream.of(1, 2, 3, 4, 5);
    }

    /**
     * 方式四
     * 创建无限流（造数据）
     */
    @Test
    public void test4(){
        //迭代流
        Stream.iterate(0, v -> v + 2).limit(10).forEach(i -> System.out.println(i));
        //生成流
        Stream.generate(Math::random).limit(10).forEach(System.out::println);
    }
}
