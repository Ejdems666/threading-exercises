package org.cba.day1.exec2;

/**
 * Created by adam on 9/22/2017.
 */
public class Even {
    private int n = 0;

    public synchronized int next() {
        n++;
        n++;
        return n;
    }
}

