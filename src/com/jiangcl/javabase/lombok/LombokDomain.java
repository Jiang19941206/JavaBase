package com.jiangcl.javabase.lombok;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * @author jiangcl
 * @date 2020/1/10
 * @desc 练习使用Lombok
 *          @NoArgsConstructor与@Builder不能共用
 */
@Data
@ToString
@Builder
public class LombokDomain {
    private String name;

    private Integer age;

    private String province;

    private String city;

    private long phone;
}
