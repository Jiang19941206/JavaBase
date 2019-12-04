package com.jiangcl.javabase.reflect;

import org.junit.Test;

import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;

/**
 * @author jiangcl
 * @date 2019/12/4
 * @desc Java反射机制
 */
public class ReflectTest {

    /**
     * @desc 通过反射创建对象
     * @author jiangcl
     * @date 2019/12/4
     * @param
     * @return void
     */
    @Test
    public void test1() throws Exception{
        Class clazz = Class.forName("com.jiangcl.javabase.reflect.Product");//方式一
        //clazz = Product.class; 方式二
        //通过空参的public构造器创建对象
        Product product1 = (Product)clazz.newInstance();
        System.out.println(product1);
        System.out.println("***********************************************");
        //通过含有参数的public构造器创建对象
        Constructor constructor = clazz.getConstructor(String.class);
        Product product2 = (Product) constructor.newInstance("笔记本电脑");
        System.out.println(product2);
        System.out.println("***********************************************");
        //通过私有的构造器创建对象
        Constructor constructor1 = clazz.getDeclaredConstructor(String.class, int.class);
        //对私有的方法，参数进行操作时这个需要设为true，否则会报IllegalAccessException异常
        constructor1.setAccessible(true);
        Product product3 = (Product) constructor1.newInstance("游戏本", 2);
        System.out.println(product3);
        System.out.println("***********************************************");
        //通过带泛型的Class创建对象
        Class<Product> clazz1 =  Product.class;
        Product product4 = clazz1.newInstance();
        System.out.println(product4);
    }

    /**
     * @desc 通过反射操作类的属性
     * @author jiangcl
     * @date 2019/12/4
     * @param
     * @return void
     */
    @Test
    public void test2() throws Exception {
        Class<Product> clazz = Product.class;
        Product product = clazz.newInstance();
        /**
         * 获取类的所有属性
         * 由于一般类的属性都是private修饰的，所以需要用getDeclaredFields方法获取
         * 如果属性是public修饰的则可以用getFields方法获取
         */
        Field[] fields = clazz.getDeclaredFields();
        for (Field field : fields) {
            String name = field.getName();//获取属性名字
            Class<?> type = field.getType();//获取属性类型
            System.out.println(name);
            System.out.println(type);
        }
        System.out.println("***************************************************");
        /**
         * 获取指定的属性
         */
        Field name = clazz.getDeclaredField("name");
        //要想对私有方法
        name.setAccessible(true);
        name.set(product,"钢板");
        System.out.println(product);
    }

    /**
     * @desc 通过反射操作类的方法
     * @author jiangcl
     * @date 2019/12/4
     * @param
     * @return void
     */
    @Test
    public void test3() throws Exception {
        Class<Product> clazz = Product.class;
        Product product = clazz.newInstance();
        /**
         *  获取所有方法
         */
        Method[] methods = clazz.getDeclaredMethods();
        for (Method method : methods) {
            String name = method.getName();
            //因为一个方法可能有多个参数，所以参数名字和参数类型都为数组
            Parameter[] parameters = method.getParameters();
            Class<?>[] types = method.getParameterTypes();
            /*System.out.println(name);
            System.out.println(parameters);
            System.out.println(types);*/
        }

        /**
         * 获取指定方法
         */
        //获取无参的公共方法
        Method showProduct = clazz.getMethod("showProduct");
        showProduct.invoke(product);//执行方法
        System.out.println("*****************************************");
        //带有参数并且有返回值的公共方法
        Method showWithParam = clazz.getMethod("showWithParam", String.class);
        String param1 = (String) showWithParam.invoke(product, "showWithParam");
        System.out.println(param1);
        /*
        * 带有参数并且有返回值的私有方法
        * 获取私有方法用getDeclaredMethod方法
        * 如果要调用私有方法需要将Accessible设置为true
        * */
        Method showPrivateMethod = clazz.getDeclaredMethod("showPrivateMethod", String.class);
        showPrivateMethod.setAccessible(true);
        String param2 = (String) showPrivateMethod.invoke(product, "showPrivateMethod");
        System.out.println(param2);
        //带有参数并且有返回值的静态方法
        Method showStaticMethod = clazz.getMethod("showStaticMethod", String.class);
        //调用静态方法时参数obj可以传null
        String param3 = (String) showStaticMethod.invoke(null,"showStaticMethod");
        System.out.println(param3);
    }

    /**
     * @desc 通过反射获取类的父类，实现的接口，注解等
     *        此处只把方法列出来，并未做具体测试
     * @author jiangcl
     * @date 2019/12/4
     * @param
     * @return void
     */
    @Test
    public void test4(){
        Class<Product> clazz = Product.class;
        //获取父类
        Class<? super Product> superclass = clazz.getSuperclass();
        //获取实现的接口,因为一个类可以实现多个接口，所以返回值为数组
        Class<?>[] interfaces = clazz.getInterfaces();
        //获取注解,因为一个类可以有多个注解，所有返回值为数组
        Annotation[] annotations = clazz.getAnnotations();
    }
}
