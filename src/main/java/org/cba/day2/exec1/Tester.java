package org.cba.day2.exec1;

public class Tester {

    public static void main(String[] args) {
        System.out.println("Available Processors: " + Runtime.getRuntime().availableProcessors());
        TagCounter tc1 = new TagCounter("http://www.fck.dk");
        TagCounter tc2= new TagCounter("http://www.google.com");
        TagCounter tc3= new TagCounter("http://politiken.dk/");

        System.out.println("Non-threaded execution:");
        long start = System.nanoTime();
        tc1.run();
        tc2.run();
        tc3.run();
        long end = System.nanoTime();
        System.out.println("Time Sequential: "+(end-start));


        System.out.println("Threaded execution:");
        long startThreaded = System.nanoTime();
        tc1.thread.start();
        tc2.thread.start();
        tc3.thread.start();
        long endThreaded = System.nanoTime();
        System.out.println("Time Sequential: "+(endThreaded-startThreaded));

    }
}
