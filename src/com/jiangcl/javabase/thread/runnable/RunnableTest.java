package com.jiangcl.javabase.thread.runnable;

/**
 * @author jiangcl
 * @date 2019/12/6
 * @desc
 */
public class RunnableTest {

    public static void main(String[] args) {
        //test1();
        test2();
        //sellTicket();
    }

    public static void sellTicket(){
        RunnableTicket ticket = new RunnableTicket();
        Thread w1 = new Thread(ticket);
        w1.setName("窗口1");
        Thread w2 = new Thread(ticket);
        w2.setName("窗口2");
        Thread w3 = new Thread(ticket);
        w3.setName("窗口3");

        w1.start();
        w2.start();
        w3.start();
    }

    public static void test1(){
        ThreadRunnable t = new ThreadRunnable();
        new Thread(t).start();
        new Thread(t).start();
    }

    /*
    * 使用匿名子类创建多线程（实现Runnable接口方式）
    * */
    public static void test2(){
        new Thread(new Runnable() {
            @Override
            public void run() {
                for(int i = 0;i < 100; i++){
                    if(i % 2 == 1){
                        System.out.println(Thread.currentThread().getName() + "***********：" + i);
                    }
                }
            }
        }).start();
    }
}
