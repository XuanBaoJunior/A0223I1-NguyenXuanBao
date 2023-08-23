package ss17_exception;

import java.util.Scanner;

public class IllegalTriangleException extends Exception {
    public IllegalTriangleException(String message) {
        super(message);
    }
}
class TriangleApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
            System.out.print("Enter the length of side 1: ");
            double side1 = scanner.nextDouble();
            System.out.print("Enter the length of side 2: ");
            double side2 = scanner.nextDouble();
            System.out.print("Enter the length of side 3: ");
            double side3 = scanner.nextDouble();

            checkTriangleValidity(side1, side2, side3);
            System.out.println("Triangle is valid.");
        } catch (IllegalTriangleException e) {
            System.out.println("Error: " + e.getMessage());
        } catch (java.util.InputMismatchException e) {
            System.out.println("Error: Invalid input. Please enter a valid number.");
        }
    }

    public static void checkTriangleValidity(double side1, double side2, double side3) throws IllegalTriangleException {
        if (side1 <= 0 || side2 <= 0 || side3 <= 0) {
            throw new IllegalTriangleException("Sides must be positive values.");
        }

        if (side1 + side2 <= side3 || side2 + side3 <= side1 || side1 + side3 <= side2) {
            throw new IllegalTriangleException("Triangle inequality violated: Sum of any two sides must be greater than the third side.");
        }
    }
}
