package com.jiangcl.javabase.thread.producer;

/**
 * @author jiangcl
 * @date 2019/12/9
 * @desc 消费者
 */
public class ConsumerThread implements Runnable {
    private Product product;

    public ConsumerThread(Product product){
        this.product = product;
    }

    @Override
    public void run() {
        System.out.println("开始消费");
        while (true){
            try {
                Thread.sleep(10l);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            product.consume();
        }
    }
}
