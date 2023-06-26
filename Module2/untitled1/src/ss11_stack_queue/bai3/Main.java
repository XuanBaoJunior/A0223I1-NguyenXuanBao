package ss11_stack_queue.bai3;

public class Main {
    public static void main(String[] args) {
        CircularQueue queue = new CircularQueue();

        queue.enQueue(10);
        queue.enQueue(20);
        queue.enQueue(30);
        queue.displayQueue();

        int removedValue = queue.deQueue();
        System.out.println("Xóa giá trị: " + removedValue);

        queue.displayQueue();
    }
}
