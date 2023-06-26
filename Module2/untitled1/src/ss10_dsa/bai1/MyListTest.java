package ss10_dsa.bai1;

public class MyListTest {
    public static void main(String[] args) {
        MyList<String> myList = new MyList<>();

        myList.add("Apple");
        myList.add("Banana");
        myList.add("Orange");
        myList.add("Mango");

        System.out.println("Size: " + myList.size());

        System.out.println("Is empty? " + myList.isEmpty());

        System.out.println("Contains 'Apple'? " + myList.contains("Apple"));

        System.out.println("Element at index 2: " + myList.get(2));

        myList.set(0, "Cherry");
        System.out.println("Updated element at index 0: " + myList.get(0));

        myList.remove("Banana");

        for (int i = 0; i < myList.size(); i++) {
            System.out.println("Element at index " + i + ": " + myList.get(i));
        }

        myList.clear();
        System.out.println("Size after clearing: " + myList.size());
    }
}

