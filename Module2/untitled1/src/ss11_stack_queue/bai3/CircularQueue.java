package ss11_stack_queue.bai3;

public class CircularQueue {
        private Node front, rear;

        public CircularQueue() {
            front = null;
            rear = null;
        }

        public void enQueue(int value) {
            Node newNode = new Node();
            newNode.data = value;

            if (isEmpty()) {
                front = newNode;
                rear = newNode;
                newNode.next = front;
            } else {
                rear.next = newNode;
                newNode.next = front;
                rear = newNode;
            }
        }

        public int deQueue() {
            if (isEmpty()) {
                System.out.println("Queue is empty");
                return -1;
            }

            int removedValue = front.data;

            if (front == rear) {
                front = null;
                rear = null;
            } else {
                front = front.next;
                rear.next = front;
            }

            return removedValue;
        }

        public boolean isEmpty() {
            return front == null;
        }

        public void displayQueue() {
            if (isEmpty()) {
                System.out.println("Queue is empty");
                return;
            }

            Node current = front;
            System.out.print("Queue: ");
            do {
                System.out.print(current.data + " ");
                current = current.next;
            } while (current != front);
            System.out.println();
        }
    }

