package ss3_array_method;

import java.util.Scanner;

public class Bai5 {
    public static void main(String[] args) {
        int m, n;
        Scanner scanner = new Scanner(System.in);

        System.out.print("Nhập vào số dòng của ma trận: ");
        m = scanner.nextInt();
        System.out.print("Nhập vào số cột của ma trận: ");
        n = scanner.nextInt();

        int A[][] = new int[m][n];

        System.out.print("Nhập các phần tử cho ma trận: ");
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print("A[" + i + "][" + j + "] = ");
                A[i][j] = scanner.nextInt();
            }
        }
        int min = A[0][0];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (min > A[i][j]){
                    min = A[i][j];
                }
            }
        }
        System.out.println("Phần tử bé nhất của ma trận là: " + min);
    }
}
