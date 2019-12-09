package com.jiangcl.javabase.thread.producer;

/**
 * @author jiangcl
 * @date 2019/12/9
 * @desc 多线程练习，生产者消费者
 */
public class ProducerTest {

    public static void main(String[] args) {
        Product product = new Product();

        ProducerThread producer = new ProducerThread(product);
        ConsumerThread consumer = new ConsumerThread(product);

        Thread producerT = new Thread(producer);
        Thread consumerT = new Thread(consumer);

        producerT.setName("生产者");
        consumerT.setName("消费者");

        producerT.start();
        consumerT.start();
    }
}
