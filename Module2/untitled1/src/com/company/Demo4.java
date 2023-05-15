package com.company;

import java.util.Scanner;

public class Demo4 {
    public static void main(String[] args) {
        System.out.println("Trình giải phương trình tuyến tính");
        System.out.println("Cho một phương trình là 'a * x + b = c', vui lòng nhập các hằng số:");
        Scanner scanner = new Scanner(System.in);
        System.out.println("a: ");
        double a = scanner.nextDouble();

        System.out.println("b: ");
        double b = scanner.nextDouble();

        System.out.println("c: ");
        double c = scanner.nextDouble();

        if (a != 0){
            double answer = (c - b) / a;
            System.out.printf("Equation pass with x = %f\n", answer);
        }else {
            if (b == c){
                System.out.print("The solution is all x");
            }else {
                System.out.print("No solution");
            }
        }
    }
}
