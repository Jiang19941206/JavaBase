package com.jiangcl.javabase.thread.extendsp;

/**
 * @author jiangcl
 * @date 2019/12/6
 * @desc 继承方式实现多窗口买票（使用同步方法解决线程安全问题）
 */
public class ExtendsTicket extends Thread {
    /*
    * 由于继承方式如果要创建多个线程的话需要创建多个对象
    * 所以需要将变量声明为静态的，使得所有对象共用此变量
    * */
    private static int ticket = 100;

    private static boolean flag = true;

    @Override
    public void run() {
        /*
        * 由于继承方式如果要创建多个线程的话需要创建多个对象
        * 所以当需要创建多个线程时，使用代码块时不能使用this充当synchronized(this){}同步锁
        * 但是可以使用当前类充当同步锁synchronized(ExtendsTicket.class){}
        *
        *       while (true){
                    synchronized (ExtendsTicket.class){
                        if(ticket > 0){
                            System.out.println(Thread.currentThread().getName() + "：售出的票号为：" + ticket);
                            ticket--;
                        }else break;
                    }
                }
        *
        * */
        while (flag){
            try {
                sleep(1000l);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            sellTicket();
        }
    }

    /**
     * @desc 由于继承方式创建多个线程会创建多个对象，
     *       所以使用同步方法时需要将方法声明为static。
     * @author jiangcl
     * @date 2019/12/6
     * @param
     * @return boolean
     */
    private static synchronized boolean sellTicket(){
        if(ticket > 0){
            System.out.println(Thread.currentThread().getName() + "：售出的票号为：" + ticket);
            ticket--;
        }else {
            flag = false;
        }
        return flag;
    }
}
