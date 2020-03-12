package by.it.yurtsevich.videoCourse2.lesson7;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.TreeSet;

public class Test1 {
    public static void main(String[] args) {
        // создаются и сортируются так же как и мепы
        Set<String> hashSet = new HashSet<>();
        Set<String> linkedHashSet = new LinkedHashSet<>();
        Set<String> treeSet = new TreeSet<>();

        //!! удобно редактировать несколько строк shift + alt и выбираю строки
        linkedHashSet.add("vitya");
        linkedHashSet.add("petya");
        linkedHashSet.add("pasha");
        linkedHashSet.add("masha");
        linkedHashSet.add("katya");

        treeSet.add("vitya");
        treeSet.add("petya");
        treeSet.add("pasha");
        treeSet.add("masha");
        treeSet.add("katya");

        hashSet.add("vitya");
        hashSet.add("petya");
        hashSet.add("pasha");
        hashSet.add("masha");
        hashSet.add("katya");


        System.out.println(linkedHashSet);
        System.out.println(treeSet);

        // Перебираю через цикл форич
        for(String name : hashSet){
            System.out.println(name);
        }
        // Метод контейнспроверяет есть ли искомое значение, возвращает тру или фолс
        System.out.println(hashSet.contains("masha"));
        System.out.println(hashSet.contains("glasha"));


    }
}
