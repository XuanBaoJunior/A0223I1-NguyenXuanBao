package ss4_oop;

public class Main3 {
    public static void main(String[] args) {
        Bai3 fan1 = new Bai3();
        fan1.setSpeed(Bai3.FAST);
        fan1.setRadius(10);
        fan1.setColor("yellow");
        fan1.setOn(true);

        Bai3 fan2 = new Bai3();
        fan2.setSpeed(Bai3.MEDIUM);
        fan2.setRadius(5);
        fan2.setColor("blue");
        fan2.setOn(false);

        System.out.println("Fan 1: " + fan1.toString());
        System.out.println("Fan 2: " + fan2.toString());
    }
}

