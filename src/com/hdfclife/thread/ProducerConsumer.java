package com.hdfclife.thread;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;

public class ProducerConsumer {

    public static List<Integer> run()
            throws InterruptedException {

        ArrayBlockingQueue<Integer> queue =new ArrayBlockingQueue<>(2);

        List<Integer> result =new ArrayList<>();

        Thread producer =new Thread(() -> {

                    try {

                        queue.put(25000);
                        queue.put(18000);
                        queue.put(42000);

                    } catch (InterruptedException e) {

                        Thread.currentThread().interrupt();
                    }
                });

        Thread consumer = new Thread(() -> {

                    try {

                        result.add(queue.take());

                        result.add(queue.take());

                        result.add(queue.take());

                    } catch (InterruptedException e) {

                        Thread.currentThread().interrupt();
                    }
                });

        producer.start();

        consumer.start();

        producer.join();

        consumer.join();

        return result;
    }
}
