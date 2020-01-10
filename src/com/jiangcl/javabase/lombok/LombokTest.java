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
        LombokDomain domain = LombokDomain.builder().name("张三")
                                                    .age(21)
                                                    .province("四川")
                                                    .city("成都")
                                                    .phone(13509807869l)
                                                    .build();
        System.out.println(domain);
    }

    @Test
    public void test2(){
        List<LombokDomain> lombokDomains = new ArrayList<>();
        LombokDomain domain1 = new LombokDomain("zhangsan",21,"四川","成都",123l);
        LombokDomain domain2 = new LombokDomain("lisi",21,"四川","成都",123l);
        LombokDomain domain3 = new LombokDomain("wanguw",21,"四川","成都",123l);
        LombokDomain domain4 = new LombokDomain("zhaoliu",21,"四川","成都",123l);
        lombokDomains.add(domain1);
        lombokDomains.add(domain2);
        lombokDomains.add(domain3);
        lombokDomains.add(domain4);

        /*lombokDomains = lombokDomains.stream().map(lombokDomain -> {
            lombokDomain.setCity("绵阳");
            return lombokDomain;
        }).collect(Collectors.toList());*/

        lombokDomains = lombokDomains.stream().map(LombokTest::getNewLombokDomain).collect(Collectors.toList());

        System.out.println(lombokDomains.toString());

    }

    public static LombokDomain getNewLombokDomain(LombokDomain lombokDomain){
        lombokDomain.setCity("绵阳");
        return lombokDomain;
    }
}
