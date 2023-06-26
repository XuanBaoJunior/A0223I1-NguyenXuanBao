package Demo;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Demo1 {
    public static void main(String[] args) {
        Map<Integer, String> stringMap = new HashMap<>();

        stringMap.put(1, "Nguyễn Văn A");
        stringMap.put(2, "Nguyễn Văn B");
        stringMap.put(3, "Nguyễn Văn X");
        stringMap.put(null, "Nguyễn Văn C");
        stringMap.put(null, "Nguyễn Văn D");
        stringMap.put(null, "Nguyễn Văn E");
        stringMap.put(null, "Nguyễn Văn F");
        stringMap.put(null, "Nguyễn Văn G");

        int[] arr = {10, 20, 30};
        for (int item : arr) {
            System.out.println(item);
        }

        for(Map.Entry<Integer, String> entry : stringMap.entrySet()){
            System.out.println(entry.getKey() + " - " + entry.getValue());
        }

        Set<Integer> integerSet = stringMap.keySet();
        System.out.println(integerSet);
        for (Integer key : integerSet) {
            System.out.println(stringMap.get(key));
        }

    }
}
