package ss1_intro;

import java.util.Scanner;

public class Bai2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhập số cần đọc: ");
        int number = scanner.nextInt();

        if (number < 0 || number > 999) {
            System.out.println("out of ability");
        } else {
            System.out.println("Số đọc thành chữ: " + convertNumberToWords(number));
        }

        scanner.close();
    }

    public static String convertNumberToWords(int number) {
        if (number == 0) {
            return "zero";
        } else if (number < 10) {
            return readSingleDigit(number);
        } else if (number < 20) {
            return readTwoDigitsLessThanTwenty(number);
        } else if (number < 100) {
            int tens = number / 10;
            int ones = number % 10;
            return readTens(tens) + " " + readSingleDigit(ones);
        } else {
            int hundreds = number / 100;
            int remainingTwoDigits = number % 100;
            return readSingleDigit(hundreds) + " hundred and " + convertNumberToWords(remainingTwoDigits);
        }
    }

    public static String readSingleDigit(int num) {
        switch (num) {
            case 1:
                return "one";
            case 2:
                return "two";
            case 3:
                return "three";
            case 4:
                return "four";
            case 5:
                return "five";
            case 6:
                return "six";
            case 7:
                return "seven";
            case 8:
                return "eight";
            case 9:
                return "nine";
            default:
                return "";
        }
    }

    public static String readTwoDigitsLessThanTwenty(int num) {
        switch (num) {
            case 10:
                return "ten";
            case 11:
                return "eleven";
            case 12:
                return "twelve";
            case 13:
                return "thirteen";
            case 14:
                return "fourteen";
            case 15:
                return "fifteen";
            case 16:
                return "sixteen";
            case 17:
                return "seventeen";
            case 18:
                return "eighteen";
            case 19:
                return "nineteen";
            default:
                return "";
        }
    }

    public static String readTens(int num) {
        switch (num) {
            case 2:
                return "twenty";
            case 3:
                return "thirty";
            case 4:
                return "forty";
            case 5:
                return "fifty";
            case 6:
                return "sixty";
            case 7:
                return "seventy";
            case 8:
                return "eighty";
            case 9:
                return "ninety";
            default:
                return "";
        }
    }
}

