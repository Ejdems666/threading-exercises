package org.cba.exec1.tasks;

/**
 * Created by adam on 18/09/2017.
 */
public class Task1 implements Runnable {
    @Override
    public void run() {
        long sum = 0;
        int max = 1000000;
        int min = 1;
        for (int i = min; i <= max; i++) {
            sum += i;
        }
        System.out.println("Task1: Sum of all numbers between " + min + " and " + max + " is: " + sum);
    }
}
