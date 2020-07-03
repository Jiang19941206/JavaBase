package com.jiangcl.javabase.lombok;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author jiangcl
 * @date 2020/1/10
 * @desc lombok测试类
 */
public class LombokTest {

    @Test
    public void test1(){

    }

    @Test
    public void test2(){
        List<LombokDomain> lombokDomains = new ArrayList<>();


        /*lombokDomains = lombokDomains.stream().map(lombokDomain -> {
            lombokDomain.setCity("绵阳");
            return lombokDomain;
        }).collect(Collectors.toList());*/

        lombokDomains = lombokDomains.stream().map(LombokTest::getNewLombokDomain).collect(Collectors.toList());

        System.out.println(lombokDomains.toString());

    }

    public static LombokDomain getNewLombokDomain(LombokDomain lombokDomain){
        return lombokDomain;
    }
}
