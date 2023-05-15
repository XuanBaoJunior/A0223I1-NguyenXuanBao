package com.company;

import java.util.Scanner;

public class Bai1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Xin mời nhập tên của bạn: ");
        String name = scanner.nextLine();

        System.out.println("Tên của bạn là: " + name);
    }
}
