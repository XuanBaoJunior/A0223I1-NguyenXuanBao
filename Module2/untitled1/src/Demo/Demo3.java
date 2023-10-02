package Demo;

import java.util.ArrayList;
import java.util.List;

public class Demo3 {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("Hello");
        list.add("a");
        list.add("b");

        list.stream().filter(e -> e.equals("Hello")).forEach(System.out::println);
    }
}
