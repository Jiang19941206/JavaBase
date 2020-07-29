package com.jiangcl.javabase.network.keyboard;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/** 键盘输入
 * @author jiangcl
 * @date 2020/7/29
 * @desc
 */
public class DemoClass {
    public static void main(String[] args) throws Exception{
        System.out.println("程序启动");
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = br.readLine()) != null){
            if("886".equals(line)){
                break;
            }
            System.out.println(line);
        }
    }
}
