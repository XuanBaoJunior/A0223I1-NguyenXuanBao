package ss13_search.Bai3;

import java.util.Scanner;

public class LongestConsecutiveSequence {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Nhập một chuỗi ký tự: ");
        String inputString = scanner.nextLine();

        String result = longestConsecutiveSequence(inputString);
        System.out.println("Chuỗi được sắp xếp có độ dài lớn nhất: " + result);
    }
    public static String longestConsecutiveSequence(String s){
        StringBuilder currentSubstring = new StringBuilder();
        String longestConsecutiveSequence = "";
        for (int i = 0; i < s.length(); i++){
            char currentChar = s.charAt(i);
            if (currentSubstring.length() == 0 || currentChar >= currentSubstring.charAt(currentSubstring.length() - 1)) {
                currentSubstring.append(currentChar);
            }else {
                if (currentSubstring.length() > longestConsecutiveSequence.length()){
                    longestConsecutiveSequence = currentSubstring.toString();
                }
                currentSubstring = new StringBuilder(String.valueOf(currentChar));
            }
        }if (currentSubstring.length() > longestConsecutiveSequence.length()){
            longestConsecutiveSequence = currentSubstring.toString();
        }
        return longestConsecutiveSequence;
    }
}
