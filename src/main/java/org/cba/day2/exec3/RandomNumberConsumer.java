package org.cba.day2.exec3;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;

public class RandomNumberConsumer implements Runnable {

    ArrayBlockingQueue<Integer> numbersProduced;

    public RandomNumberConsumer(ArrayBlockingQueue<Integer> numbersProduced) {
        this.numbersProduced = numbersProduced;
    }
    //Should eventually hold the sum of all random number consumed
    int sumTotal = 0;
    List<Integer> below50 = new ArrayList();
    List<Integer> aboveOr50 = new ArrayList();

    @Override
    public void run()
    {
        for (int i = 0; i < 400; i++) {
            try
            {
                int _int = numbersProduced.take();
                if (_int < 50)
                {
                    below50.add(_int);
                }
                else if (_int >= 50)
                {
                    aboveOr50.add(_int);
                }
                sumTotal += _int;
            }
            catch (InterruptedException e)
            {
                e.printStackTrace();
            }
        }
    }


    public int getSumTotal() {
        return sumTotal;
    }

    public List<Integer> getBelow50() {
        return below50;
    }

    public List<Integer> getAboveOr50() {
        return aboveOr50;
    }

}