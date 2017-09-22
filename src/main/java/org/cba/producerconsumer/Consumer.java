package org.cba.producerconsumer;

import java.util.concurrent.BlockingQueue;

/**
 * Created by adam on 9/22/2017.
 */
public class Consumer implements Runnable{
    private BlockingQueue<Long> s2;
    private Long sum = 0L;

    public Consumer(BlockingQueue<Long> s2) {
        this.s2 = s2;
    }

    @Override
    public void run() {
        try {
            while (true) {
                Long nextNumber = s2.take();
                sum += nextNumber;
                System.out.println(nextNumber);
            }
        } catch (InterruptedException e) {
            return;
        }
    }
}
