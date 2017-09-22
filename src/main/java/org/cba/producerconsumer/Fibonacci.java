package org.cba.producerconsumer;

/**
 * Created by adam on 9/22/2017.
 */
public class Fibonacci {
    public long fib(long n) {
        if (n == 0 || n == 1) {
            return n;
        } else {
            return fib(n - 1) + fib(n - 2);
        }
    }
}
