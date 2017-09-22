package org.cba.producerconsumer;

import java.util.concurrent.BlockingQueue;

/**
 * Created by adam on 9/22/2017.
 */
public class Producer implements Runnable {
    private BlockingQueue<Long> s1;
    private BlockingQueue<Long> s2;
    private Fibonacci fibonacci;

    public Producer(BlockingQueue<Long> s1, BlockingQueue<Long> s2, Fibonacci fibonacci) {
        this.s1 = s1;
        this.s2 = s2;
        this.fibonacci = fibonacci;
    }

    @Override
    public void run() {
        try {
            Long newNumber = s1.poll();
            while (newNumber != null) {
                Long newFibonacciNumber = fibonacci.fib(newNumber);
                s2.put(newFibonacciNumber);
                newNumber = s1.poll();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
