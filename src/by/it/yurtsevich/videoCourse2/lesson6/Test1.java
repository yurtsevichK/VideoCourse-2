package by.it.yurtsevich.videoCourse2.lesson6;

import java.util.HashMap;
import java.util.Map;

public class Test1 {
    public static void main(String[] args) {
        Map<String, String> translations = new HashMap<>();
        translations.put("кошка", "cat");
        translations.put("собака", "dog");
        translations.put("слон", "elephant");

        for (Map.Entry<String, String> entry: translations.entrySet()){
            System.out.println(entry.getKey()+ ": " + entry.getValue());
        }
    }
}
