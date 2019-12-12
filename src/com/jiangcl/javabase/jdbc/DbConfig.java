package com.jiangcl.javabase.jdbc;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * @author jiangcl
 * @date 2019/12/12
 * @desc
 */
public class DbConfig {
    public static String driver;

    public static String url;

    public static String userName;

    public static String password;

    static {
        try {
            InputStream in = ClassLoader.getSystemClassLoader().getResourceAsStream("db.properties");

            Properties pro = new Properties();
            pro.load(in);

            driver = (String) pro.get("driver");
            url = (String) pro.get("url");
            userName = (String) pro.get("userName");
            password = (String) pro.get("password");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
