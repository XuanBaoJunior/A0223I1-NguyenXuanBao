package ss6_inheritance.bai1;

public class CircleTest {
    public static void main(String[] args) {
        Circle circle = new Circle(5.0, "Red");
        System.out.println(circle);
        System.out.println("Radius: " + circle.getRadius());
        System.out.println("Color: " + circle.getColor());
        System.out.println("Area: " + circle.getArea());

        circle.setRadius(7.5);
        circle.setColor("Blue");
        System.out.println(circle);
        System.out.println("Radius: " + circle.getRadius());
        System.out.println("Color: " + circle.getColor());
        System.out.println("Area: " + circle.getArea());
    }
}


