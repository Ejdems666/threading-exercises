package org.cba.day1.exec1.tasks;

/**
 * Created by adam on 18/09/2017.
 */
public class Task2 implements Runnable{
    @Override
    public void run() {
        for (int i = 1; i <= 5; i++) {
            System.out.println("Task2: "+i);
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
