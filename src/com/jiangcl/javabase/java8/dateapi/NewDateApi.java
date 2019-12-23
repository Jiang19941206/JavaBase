package com.jiangcl.javabase.java8.dateapi;

import org.junit.Test;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.util.concurrent.TimeUnit;

/**
 * @author jiangcl
 * @date 2019/12/23
 * @desc Java8日期API
 */
public class NewDateApi {

    @Test
    public void test1(){
        LocalDate localDate = LocalDate.now();
        System.out.println(localDate);
        System.out.println();

        LocalTime localTime = LocalTime.now();
        System.out.println(localTime);
        System.out.println();

        LocalDateTime localDateTime = LocalDateTime.now();
        System.out.println(localDateTime);
        long l = localDateTime.toInstant(ZoneOffset.of("+8")).toEpochMilli();
        System.out.println(l);
        LocalDateTime localDateTime2 =LocalDateTime.ofEpochSecond(l/1000,0,ZoneOffset.ofHours(8));
        System.out.println(localDateTime2);
        System.out.println();

        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String format = dateTimeFormatter.format(localDateTime);
        System.out.println(format);
        System.out.println();

        Instant instant = Instant.now().plusMillis(TimeUnit.HOURS.toMillis(8));
        long milli = Instant.now().toEpochMilli();
        System.out.println(instant);
        System.out.println(milli);
        System.out.println(System.currentTimeMillis());
        System.out.println();
    }
}
