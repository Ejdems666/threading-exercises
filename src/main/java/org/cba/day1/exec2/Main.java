package org.cba.day1.exec2;

/**
 * Created by adam on 9/22/2017.
 */
public class Main {
    public static void main(String[] args) {
        Even even = new Even();
        Thread t1 = new Thread(new Task(even, "t1"));
        Thread t2 = new Thread(new Task(even, "t2"));
        t1.start();
        t2.start();
    }
}
