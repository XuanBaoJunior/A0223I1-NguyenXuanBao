package ss10_dsa.bai2;

public class MyLinkedListTest {
    public static void main(String[] args) {
        MyLinkedList<Integer> myList = new MyLinkedList<>();

        myList.addLast(1);
        myList.addLast(2);
        myList.addLast(3);
        myList.addLast(4);
        myList.addLast(5);

        System.out.println("Original list:");
        myList.printList();

        System.out.println("Size: " + myList.size());

        myList.remove(2);

        System.out.println("List after removing element at index 2:");
        myList.printList();

        System.out.println("Size: " + myList.size());

        System.out.println("Element at index 1: " + myList.get(1));

        System.out.println("Index of element 4: " + myList.indexOf(4));

        System.out.println("List contains element 3: " + myList.contains(3));

        MyLinkedList<Integer> clonedList = myList.clone();

        System.out.println("Cloned list:");
        clonedList.printList();
    }
}

