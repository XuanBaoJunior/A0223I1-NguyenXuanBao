package ss7_abstract_interface.bai1;

import java.util.Random;

public class Main {
    public static void main(String[] args) {
        Random random = new Random();
        Resizeable[] shapes = new Resizeable[3];
        shapes[0] = new Circle(5);
        shapes[1] = new Rectangle(4, 6);
        shapes[2] = new Square(3);

        for (Resizeable shape : shapes) {
            double originalArea = shape.getArea();
            double resizePercent = random.nextInt(100) + 1;
            shape.resize(resizePercent);
            double newArea = shape.getArea();

            System.out.println("Original Area: " + originalArea);
            System.out.println("Resized Area (" + resizePercent + "% increase): " + newArea);
            System.out.println();
        }
    }
}
