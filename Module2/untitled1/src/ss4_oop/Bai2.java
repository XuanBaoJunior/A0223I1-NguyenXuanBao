package ss4_oop;


public class Bai2 {
    private long startTime;
    private long endTime;

    public Bai2() {
        startTime = System.currentTimeMillis();
    }

    public long getStartTime() {

        return startTime;
    }

    public long getEndTime() {

        return endTime;
    }

    public void start() {

        startTime = System.currentTimeMillis();
    }

    public void stop() {

        endTime = System.currentTimeMillis();
    }

    public long getElapsedTime() {
        if (endTime == 0) {
            return System.currentTimeMillis() - startTime;
        }
        return endTime - startTime;
    }
}

