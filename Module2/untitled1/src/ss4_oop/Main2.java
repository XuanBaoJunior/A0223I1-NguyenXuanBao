package ss4_oop;

public class Main2 {
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

