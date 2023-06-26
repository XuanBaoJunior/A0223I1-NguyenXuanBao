package ss11_stack_queue.bai5;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Palindrome {
    public static boolean isPalindrome(String str) {
        String formattedStr = str.replaceAll("\\s+", "").toLowerCase();

        Stack<Character> stack = new Stack<>();
        Queue<Character> queue = new LinkedList<>();

        for (int i = 0; i < formattedStr.length(); i++) {
            char c = formattedStr.charAt(i);
            stack.push(c);
            queue.offer(c);
        }

        while (!stack.isEmpty()) {
            if (!stack.pop().equals(queue.poll())) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        String str = "Able was I ere I saw Elba";
        boolean isPalindrome = isPalindrome(str);
        System.out.println("String: " + str);
        System.out.println("Is Palindrome: " + isPalindrome);
    }
}

