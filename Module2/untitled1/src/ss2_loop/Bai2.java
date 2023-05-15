package ss2_loop;

import java.util.Scanner;

public class Bai2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = 20;
        int status = 1;
        int num = 3;
        if (n > 1){
            System.out.println(n+ " Số nguyên tố đầu tiên là");
            System.out.println("2");
        }
        for (int i = 2; i <= n ; ){
            for (int j = 2; j <= Math.sqrt(num) ; j++) {
                if (num %j == 0){
                    status = 0;
                    break;
                }
            }
            if (status != 0){
                System.out.println(num);
                i++;
            }
            status = 1;
            num ++;
        }
    }
}
