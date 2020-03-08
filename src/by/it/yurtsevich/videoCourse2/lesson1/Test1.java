package by.it.yurtsevich.videoCourse2.lesson1;

import java.util.ArrayList;

public class Test1 {
    public static void main(String[] args) {
        ArrayList<Integer> arrayList = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            // Метод эдд
            arrayList.add(i);
        }
        System.out.println(arrayList);
        // Метод гет, получаем элемент по индексу
        System.out.println(arrayList.get(1));
        System.out.println(arrayList.get(9));

        // Метод сайз показывает размер листа
        for (int i = 0; i < arrayList.size(); i++) {
            System.out.print(arrayList.get(i));
        }
        System.out.println();
        for (Integer x : arrayList) {
            System.out.print(x);
        }
        // Метод рему удаляет элемент листа, ввожу индекс
        arrayList.remove(5);
        System.out.println(arrayList);

    }
}
