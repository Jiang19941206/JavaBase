package com.jiangcl.javabase.thread.producer;

/**
 * @author jiangcl
 * @date 2019/12/9
 * @desc 生产者
 */
public class ProducerThread implements Runnable {
    private Product product;

    public ProducerThread(Product product){
        this.product = product;
    }

    @Override
    public void run() {
        System.out.println("开始生产");
        while (true){
            try {
                Thread.sleep(10l);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            product.produce();
        }
    }
}
