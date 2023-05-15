package ss2_loop;

import java.util.Scanner;

public class Bai3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = 100;
        System.out.println("Các số nguyên tố nhỏ hơn 100 là: ");
        for (int i = 1; i < n; i++) {
            int dem = 0;
            for (int j = 1; j <= i; j++) {
                if (i % j == 0) {
                    dem++;
                }
            }
            if (dem==2){
                System.out.println(" "+i);
            }
        }
    }
}
