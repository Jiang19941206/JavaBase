package com.jiangcl.javabase.thread.producer;

/**
 * @author jiangcl
 * @date 2019/12/9
 * @desc 建一个商品类
 */
public class Product {
    private int count  = 0;//商品数量

    /**
     * @desc 生产产品
     * @author jiangcl
     * @date 2019/12/9
     * @param
     * @return void
     */
    public synchronized void produce(){
            if(count < 20){
                count++;
                System.out.println(Thread.currentThread().getName() + "生产第：" + count + "个产品");
                notify();//当产品生产完成过后就唤醒消费者线程
            }else {
                try {
                    wait();//当产品生产数量达到最大值时，暂停生产
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
    }

    /**
     * @desc 消费产品
     * @author jiangcl
     * @date 2019/12/9
     * @param
     * @return void
     */
    public synchronized void consume(){
            if(count > 0){
                System.out.println(Thread.currentThread().getName() + "消费第：" + count +"个产品");
                count--;
                notify();//当有产品被消费后唤醒生产者线程
            }else{
                try {
                    wait();//当没有产品可消费时，暂停消费
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
    }
}
