package com.jiangcl.javabase.thread.extendsp;

/**
 * @author jiangcl
 * @date 2019/12/6
 * @desc 多线程测试
 */
public class ThreadTest {

    public static void main(String[] args) {
        //threadExtends();
        //threadExtends1();
        sellTicket();
    }

    public static void sellTicket(){
        ExtendsTicket ticket1 = new ExtendsTicket();
        ExtendsTicket ticket2 = new ExtendsTicket();
        ExtendsTicket ticket3 = new ExtendsTicket();
        ticket1.setName("窗口1");
        ticket2.setName("窗口2");
        ticket3.setName("窗口3");
        ticket1.start();
        ticket2.start();
        ticket3.start();
    }

    //使用匿名子类创建并执行线程（继承Thread方式）
    public static void threadExtends1(){
        ThreadExtends t1 = new ThreadExtends();
        t1.setName("线程1");
        t1.start();
        //使用匿名子类创建并执行线程
        new Thread(){
            @Override
            public void run() {
                Thread.currentThread().setName("线程2");
                for(int i = 0;i < 100;i++){
                    if(i % 2 == 0){
                        System.out.println(Thread.currentThread().getName()+ "************" +i);
                    }
                    if(i == 20){
                        yield();//释放cpu对当前线程的执行权。
                    }
                    if(i == 50){
                        try {
                            /*
                            * 当在此处调用t1.join()时，当前线程会进入阻塞状。
                            * 当t1执行完过后再执行当前线程
                            * */
                            t1.join();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        }.start();
    }

    //使用常规方式创建线程
    public static void threadExtends(){
        ThreadExtends t1 = new ThreadExtends();
        t1.setName("线程1");
        ThreadExtends t2 = new ThreadExtends();
        t2.setName("线程2");
        //设置线程的优先级,
        t2.setPriority(Thread.MAX_PRIORITY);
        t1.start();
        t2.start();
    }
}
