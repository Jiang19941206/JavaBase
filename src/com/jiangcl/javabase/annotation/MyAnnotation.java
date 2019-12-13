package com.jiangcl.javabase.annotation;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.*;

/**
 * @author jiangcl
 * @date 2019/12/13
 * @desc
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({TYPE,FIELD,METHOD,PARAMETER})
public @interface MyAnnotation {
    String value() default "";
}
