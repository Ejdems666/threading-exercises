package org.cba.producerconsumer;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 * Created by adam on 9/22/2017.
 */
public class Main {

    private static Fibonacci fibonacci;

    public static void main(String[] args) throws InterruptedException {
        fibonacci = new Fibonacci();
        processQueue(1);
        processQueue(2);
        processQueue(3);
        processQueue(4);
    }

    private static void processQueue(int numberOfThreads) throws InterruptedException {
        long startTime = System.nanoTime();
        System.out.println("Processing Queue with " + numberOfThreads + " thread/s");
        BlockingQueue<Long> s1 = new ArrayBlockingQueue<>(9);
        s1.add(4L);
        s1.add(5L);
        s1.add(8L);
        s1.add(12L);
        s1.add(21L);
        s1.add(22L);
        s1.add(34L);
        s1.add(35L);
        s1.add(40L);
        BlockingQueue<Long> s2 = new ArrayBlockingQueue<>(s1.size());
        List<Thread> producerThreads = new ArrayList<>(numberOfThreads);
        for (int i = 0; i < numberOfThreads; i++) {
            producerThreads.add(new Thread(new Producer(s1, s2, fibonacci)));
            producerThreads.get(i).start();
        }
        Consumer consumer = new Consumer(s2);
        Thread consumerThread = new Thread(consumer);
        consumerThread.start();
        for (Thread producerThread : producerThreads) {
            producerThread.join();
        }
        consumerThread.interrupt();
        long stopTime = System.nanoTime();
        System.out.println("Execution finished in : " + (stopTime - startTime) / 1000000 + " milliseconds\n");
    }
}
