package ss7_abstract_interface.bai2;

public class Main {
    public static void main(String[] args) {
        Colorable[] shapes = new Colorable[3];
        shapes[0] = new Square(3);
        shapes[1] = (Colorable) new Circle(5);
        shapes[2] = new Square(4);

        for (Colorable shape : shapes) {
            if (shape instanceof Square) {
                Square square = (Square) shape;
                System.out.println("Square Area: " + square.getArea());
                square.howToColor();
            } else {
                System.out.println("Circle Area: " + shape.getArea());
            }
            System.out.println();
        }
    }
}
