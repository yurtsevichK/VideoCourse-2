package by.it.yurtsevich.videoCourse2.lesson7;

import java.util.HashSet;
import java.util.Set;

public class Test2 {
    public static void main(String[] args) {
        Set<Integer> set1 = new HashSet<>();
        set1.add(1);
        set1.add(2);
        set1.add(3);
        set1.add(4);
        set1.add(5);

        Set<Integer> set2 = new HashSet<>();
        set2.add(2);
        set2.add(3);
        set2.add(4);
        set2.add(5);
        set2.add(6);
        set2.add(7);

        // union - обьединение множеств
        Set<Integer> union = new HashSet<>(set1);
        // Method addall add all elements
        union.addAll(set2);
        System.out.println(union);

        // intersection - пересечение множеств
        Set <Integer> intersection = new HashSet<>(set1);
        // Method retainall показывает пересекаемые значения
        intersection.retainAll(set2);
        System.out.println(intersection);

        //difference - разность множеств
        Set <Integer> difference = new HashSet<>(set1);
        // Method removeall удаляет повторяющиеся элементы из сета установленного в самом начале (сет1)
        difference.removeAll(set2);
        System.out.println(difference);
    }
}
