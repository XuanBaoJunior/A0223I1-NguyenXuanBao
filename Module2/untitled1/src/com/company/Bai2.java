package com.company;

import java.util.Scanner;

public class Bai2 {
    public static void main(String[] args) {
                Scanner scanner = new Scanner(System.in);

                System.out.println("Mời bạn nhập vào số: ");
                int number = scanner.nextInt();

                if (number == 0) {
                    System.out.println("zero");
                    return;
                }

                if (number < 0) {
                    System.out.println("minus ");
                    number = Math.abs(number);
                }

                String words = "";

                String[] units = { "", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine", "ten",
                        "eleven", "twelve", "thirteen", "fourteen", "fifteen", "sixteen", "seventeen", "eighteen",
                        "nineteen" };

                String[] tens = { "", "", "twenty", "thirty", "forty", "fifty", "sixty", "seventy", "eighty", "ninety" };

                if (number < 20) {
                    words = units[number];
                } else if (number < 100) {
                    words = tens[number / 10] + " " + units[number % 10];
                } else {
                    words = units[number / 100] + " hundred ";
                    if (number % 100 != 0) {
                        words += "and ";
                    }
                    words += tens[(number % 100) / 10] + " " + units[number % 10];
                }

                System.out.println(words);
            }
        }
