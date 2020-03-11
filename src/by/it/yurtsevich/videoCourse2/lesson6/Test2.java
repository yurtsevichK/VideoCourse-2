package by.it.yurtsevich.videoCourse2.lesson6;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;

public class Test2 {
    public static void main(String[] args) {
        Map<Integer, String> hashMap = new HashMap<>(); // внутри не гарантируется никакого порядка
        Map<Integer, String> linkedHashMap = new LinkedHashMap<>(); // гарантируется порядок( в каком были добавлены, в таком и получены )
        Map<Integer, String> treeMap = new TreeMap<>(); // гарантируется сортировка по ключу

        mapTest(hashMap);
        mapTest(linkedHashMap);
        mapTest(treeMap);
    }

    public static void mapTest(Map<Integer, String> map) {
        map.put(39, "Petya");
        map.put(19, "Lena");
        map.put(329, "Vasya");
        map.put(349, "Grusha");
        map.put(300, "Misha");

        for (Map.Entry<Integer, String> entry : map.entrySet()) {
            System.out.println(entry.getKey() + ":" + entry.getValue());
        }
    }
}
