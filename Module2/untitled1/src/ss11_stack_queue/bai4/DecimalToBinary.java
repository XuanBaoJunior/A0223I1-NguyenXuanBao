package ss11_stack_queue.bai4;

import java.util.Stack;

public class DecimalToBinary {
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        int n = 312;

        while (n != 0){
            stack.push(n % 2);
            n /= 2;
        }
        while (!stack.isEmpty()){
            System.out.print(stack.pop());
        }
    }
}
