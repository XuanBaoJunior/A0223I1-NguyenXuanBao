package ss6_inheritance.demo;

public class Main {
    public static void main(String[] args) {
        demo demo = new demo(4,5);
        System.out.println("X,Y");
        demo.toString();

        demo1 demo1 = new demo1(6);
        System.out.println("X,Y,Z");
        demo1.toString();
    }
}
