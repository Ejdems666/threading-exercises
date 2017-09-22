package org.cba.day1.exec1;

import org.cba.day1.exec1.tasks.Task1;
import org.cba.day1.exec1.tasks.Task2;
import org.cba.day1.exec1.tasks.Task3;

/**
 * Created by adam on 18/09/2017.
 */
public class Main {
    public static void main(String[] args) {
        Thread t1 = new Thread(new Task1());
        Thread t2 = new Thread(new Task2());
        Task3 task3 = new Task3();
        Thread t3 = new Thread(task3);

        t1.start();
        t2.start();
        t3.start();

        try {
            Thread.sleep(10000);
            task3.setTerminate(true);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
