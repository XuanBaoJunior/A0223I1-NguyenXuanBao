package ss3_array_method;

import java.util.Scanner;

public class Bai8 {
    public static void main(String[] args) {
        String str = "Hello, World!";

        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhập ký tự cần đếm: ");
        char character = scanner.next().charAt(0);

        int count = 0;

        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == character) {
                count++;
            }
        }

        System.out.println("Số lần xuất hiện của ký tự '" + character + "' trong chuỗi là: " + count);
    }
}

