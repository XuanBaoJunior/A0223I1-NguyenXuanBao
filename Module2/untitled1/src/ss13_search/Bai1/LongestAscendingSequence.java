package ss13_search.Bai1;

import java.util.Scanner;

public class LongestAscendingSequence {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhập vào một chuỗi bất kỳ: ");
        String inputString = scanner.nextLine();
        scanner.close();

        String sortedSubstring = getSortedSubstring(inputString);
        System.out.println("Chuỗi kí tự con tăng dần: " + sortedSubstring);
    }

    public static String getSortedSubstring(String inputString) {
        int maxLength = 0;
        String result = "";

        for (int i = 0; i < inputString.length(); i++) {
            for (int j = i; j < inputString.length(); j++) {
                String substring = inputString.substring(i, j + 1);
                String sortedSub = sortString(substring);

                if (sortedSub.compareTo(result) > 0 && substring.length() > maxLength) {
                    maxLength = substring.length();
                    result = sortedSub;
                }
            }
        }

        return result;
    }

    public static String sortString(String s) {
        char[] chars = s.toCharArray();
        java.util.Arrays.sort(chars);
        return new String(chars);
    }
}
