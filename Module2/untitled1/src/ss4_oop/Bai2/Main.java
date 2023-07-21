package ss4_oop.Bai2;

import ss4_oop.Bai2.Bai2;

public class Main {
    public static void main(String[] args) {
        Bai2 stopwatch = new Bai2();

        stopwatch.start();

        for (int i = 0; i < 1000000000; i++) {
        }

        stopwatch.stop();

        long elapsedTime = stopwatch.getElapsedTime();
        System.out.println("Elapsed Time: " + elapsedTime + " milliseconds");
    }
}

