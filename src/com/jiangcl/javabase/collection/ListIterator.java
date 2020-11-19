package com.jiangcl.javabase.collection;

import org.junit.Test;

import java.util.List;
import java.util.ArrayList;
import java.util.Iterator;

/**
 * @author jiangcl
 * @date 2020/11/19
 * @desc list集合
 */
public class ListIterator {

    @Test
    public void test1(){
        List<String> strList = new ArrayList<>();
        strList.add("a");
        strList.add("b");
        strList.add("c");
        strList.add("d");

        System.out.println(strList.size());

        //使用迭代器可以在遍历中移除集合中的元素
        Iterator<String> it = strList.iterator();
        while (it.hasNext()){
            if(it.next().equals("a")){
                it.remove();
            }
        }

        System.out.println(strList.size());
    }
}
