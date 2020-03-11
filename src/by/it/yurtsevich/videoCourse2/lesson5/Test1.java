package by.it.yurtsevich.videoCourse2.lesson5;

import java.util.HashMap;
import java.util.Map;

public class Test1 {
    public static void main(String[] args) {
        // Создаем хешмеп
        Map<Integer, String> map = new HashMap<>();
        // заполняем меп (ключ = значение)
        map.put(1, "One");
        map.put(2, "Two");
        map.put(3, "Three");
        System.out.println(map);

        // Ключ три принимает новое значение(перезаписывается) и выводит его !ДУБЛИКАТОВ БЫТЬ НЕ МОЖЕТ
        map.put(3,"Другое значение");
        System.out.println(map);

        // Выводит желаемое значение метод гет указав его ключ
        System.out.println(map.get(1));

        // Прохождение по мепу с помощью цикла форич
        for (Map.Entry<Integer,String> entry: map.entrySet()){
            // Выводим на экран ключ + значение
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }

    }
}
