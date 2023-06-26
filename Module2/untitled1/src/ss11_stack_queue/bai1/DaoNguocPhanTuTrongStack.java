package ss11_stack_queue.bai1;

import java.util.Stack;

public class DaoNguocPhanTuTrongStack {
    public static void reverseArray(int[] array) {
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < array.length; i++) {
            stack.push(array[i]);
        }

        for (int i = 0; i < array.length; i++) {
            array[i] = stack.pop();
        }
    }

    public static void main(String[] args) {
        int[] array = {1, 2, 3, 4, 5};

        System.out.println("Mang ban dau:");
        printArray(array);

        reverseArray(array);

        System.out.println("Mang sau khi dao nguoc:");
        printArray(array);
    }

    public static void printArray(int[] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println();
    }
}

