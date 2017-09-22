package org.cba.exec1.tasks;

/**
 * Created by adam on 18/09/2017.
 */
public class Task3 implements Runnable {
    private volatile boolean terminate = false;

    @Override
    public void run() {
        for (int i = 10; ; i++) {
            if (terminate) {
                return;
            }
            System.out.println("Task 3: " + i);
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void setTerminate(boolean terminate) {
        this.terminate = terminate;
    }
}
