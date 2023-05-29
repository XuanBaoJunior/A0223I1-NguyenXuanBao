package ss3_array_method;

import java.util.Scanner;
public class Bai6 {
        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);

            System.out.print("Nhập số hàng của mảng: ");
            int rows = scanner.nextInt();
            System.out.print("Nhập số cột của mảng: ");
            int columns = scanner.nextInt();

            double[][] arr = new double[rows][columns];

            System.out.println("Nhập các giá trị của mảng:");
            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < columns; j++) {
                    System.out.print("arr[" + i + "][" + j + "] = ");
                    arr[i][j] = scanner.nextDouble();
                }
            }

            System.out.print("Nhập số cột bạn muốn tính tổng: ");
            int columnIndex = scanner.nextInt();

            double sum = 0;
            for (int i = 0; i < rows; i++) {
                sum += arr[i][columnIndex];
            }

            System.out.println("Tổng của cột " + columnIndex + " là: " + sum);

            scanner.close();
        }
    }
