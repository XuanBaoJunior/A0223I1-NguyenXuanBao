package ss11_stack_queue.bai2;

import java.util.Map;
import java.util.TreeMap;

public class DemLanXuatHien {
    public static void countWords(String text) {
        String cleanedText = text.toLowerCase().replaceAll("[^a-zA-Z ]", "");

        String[] words = cleanedText.split("\\s+");

        Map<String, Integer> wordCounts = new TreeMap<>();

        for (String word : words) {
            if (wordCounts.containsKey(word)) {
                wordCounts.put(word, wordCounts.get(word) + 1);
            } else {
                wordCounts.put(word, 1);
            }
        }

        for (Map.Entry<String, Integer> entry : wordCounts.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }

    public static void main(String[] args) {
        String text = "Hello Codegym Hello Codegym";

        System.out.println("Số lần xuất hiện:");
        countWords(text);
    }
}

