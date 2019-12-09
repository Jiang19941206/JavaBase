package com.jiangcl.javabase.thread.runnable;

/**
 * @author jiangcl
 * @date 2019/12/6
 * @desc 实现接口方式实现多窗口买票（使用同步代码块解决线程安全问题）
 */
public class RunnableTicket implements Runnable {
    //实现Runnable接口方式要创建多个线程的话只需创建一个对象，所以此变量不用声明为静态变量
    private int ticket = 100;

    @Override
    public void run() {
        while (true){
            synchronized (this){
                if(ticket > 0){
                    System.out.println(Thread.currentThread().getName() + "：售出的票号为：" + ticket);
                    ticket--;
                }else break;
            }
        }
    }
}
