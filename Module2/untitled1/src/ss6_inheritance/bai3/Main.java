package ss6_inheritance.bai3;

public class Main {
    public static void main(String[] args) {
        Point point = new Point(2, 3);
        System.out.println(point);

        point.setX(5);
        point.setY(7);
        System.out.println(point);

        MoveablePoint moveablePoint = new MoveablePoint(1, 2, 0.5, 0.5);
        System.out.println(moveablePoint);

        moveablePoint.move();
        System.out.println(moveablePoint);
    }
}
