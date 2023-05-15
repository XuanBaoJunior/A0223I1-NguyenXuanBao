package com.company;

import java.util.Scanner;

public class Bai3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double vnd = 23000;
        double usd;
        System.out.println("Mời bạn nhập vào số tiền: ");
        usd = scanner.nextDouble();

        double doi = usd * 23000;

        System.out.println("Giá trị VND: " + doi);

    }
}
