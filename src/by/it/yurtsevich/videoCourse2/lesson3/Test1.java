package by.it.yurtsevich.videoCourse2.lesson3;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Test1 {
    public static void main(String[] args) {
        List<Integer> linkedList = new LinkedList<>();
        List<Integer> arrayList = new ArrayList<>();

        measureTime(linkedList);
        measureTime(arrayList);

    }
    private static void measureTime(List <Integer> list ){
       // ЛинкедЛист улобнее, если добавляешь элементы в начале(с заданного индекса), в противном случае (когда добавляю в конец
       // для быстродействия лучше использовать ЭрэйЛист

        // System.currentTimeMillis(); считаем в мили секундах выполнение программы, помещая программу между старт и енд
        long start = System.currentTimeMillis();

        for( int i =0; i< 100000; i++){
            list.add(0, i);
        }

        long end = System.currentTimeMillis();

        System.out.println(end - start);
    }
}
