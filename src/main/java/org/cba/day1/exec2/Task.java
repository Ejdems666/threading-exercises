package org.cba.day1.exec2;

/**
 * Created by adam on 9/22/2017.
 */
public class Task implements Runnable {

    private Even even;
    private String name;

    public Task(Even even, String name) {
        this.even = even;
        this.name = name;
    }

    @Override
    public void run() {
        for (int i = 0; i < 1e3; i++) {
            int next = even.next();
            if (next % 2 != 0) {
                System.out.println(name + " gets odd number:" + next);
            }
        }
    }
}