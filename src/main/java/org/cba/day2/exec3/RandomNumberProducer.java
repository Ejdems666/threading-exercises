package org.cba.day2.exec3;

import java.util.concurrent.ArrayBlockingQueue;


public class RandomNumberProducer implements Runnable{

    public static final int MAX_NUMBERS_TO_PRODUCE = 100;
    public static final int MAX_RANDOM = 100;

    ArrayBlockingQueue<Integer> numbersProduced;

    public RandomNumberProducer(ArrayBlockingQueue<Integer> numbersProduced) {
        this.numbersProduced = numbersProduced;
    }

    @Override
    public void run()
    {
        try {
            for (int i = 0; i < MAX_NUMBERS_TO_PRODUCE; i++)
            {
                int _rndInt = (int) (Math.random() * MAX_RANDOM + 1);
                numbersProduced.add(_rndInt);
            }
        }
        catch (Exception ex)
        {
            ex.printStackTrace();
        }
    }

    //By now, you should know how to produce random numbers, but if not, use/run this as a guide
    public static void main(String[] args) {
        int MAX_RAND = 2;
        for (int i = 0; i < 10; i++) {
            int random = (int) ((Math.random() * MAX_RAND+1));
            System.out.println(random);
        }
    }



}