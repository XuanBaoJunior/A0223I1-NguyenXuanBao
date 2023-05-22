package ss3_array_method;

import java.util.Scanner;

public class Bai7 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n;
        int sum = 0;
        System.out.println("Nhập vào bậc của ma trận: ");
        n = scanner.nextInt();
        int A[][] = new int[n][n];
        System.out.println("Nhập các phần tử cho ma trận: ");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print("A[" + i + "][" + i + "] = ");
                A[i][j] = scanner.nextInt();
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i == j){
                    sum += A[i][j];
                }
            }
        }
        System.out.println("Tổng: " + sum);
    }
}
