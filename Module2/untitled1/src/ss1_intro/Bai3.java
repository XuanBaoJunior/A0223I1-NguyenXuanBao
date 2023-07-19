package ss1_intro;

import java.util.Scanner;

public class Bai3 {
    public static void main(String[] args) {
        double vnd = 23000;
        double usd;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Mời bạn nhập số tiền USD: ");
        usd = scanner.nextDouble();
        double quydoi = usd * vnd;
        System.out.println("Thành tiền VND là: " + quydoi);
    }
}
