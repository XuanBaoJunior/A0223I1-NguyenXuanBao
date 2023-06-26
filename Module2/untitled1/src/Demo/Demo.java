package Demo;

import java.util.*;

public class Demo {
    public static void main(String[] args) {
        Map<Integer, String> stringMap = new TreeMap<>(Collections.reverseOrder());

        stringMap.put(1, "Nguyễn Văn A");
        stringMap.put(2, "Nguyễn Văn B");
        stringMap.put(-50, "Nguyễn Văn X");
        stringMap.put(80, "Nguyễn Văn X");
        stringMap.put(80, "Nguyễn Văn 80");
        stringMap.put(100, "Nguyễn Văn X");
        stringMap.put(-20, "Nguyễn Văn X");
        stringMap.put(60, "Nguyễn Văn X");
        stringMap.put(90, "Nguyễn Văn X");
        stringMap.put(0, "Nguyễn Văn X");

        Set<Integer> integerSet = stringMap.keySet();
        for (Integer key : integerSet) {
            System.out.println(key + " - " + stringMap.get(key));
        }
    }
}
