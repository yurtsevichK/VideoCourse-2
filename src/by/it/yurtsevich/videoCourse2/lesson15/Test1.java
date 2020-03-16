package by.it.yurtsevich.videoCourse2.lesson15;

import java.util.ArrayList;
import java.util.Iterator;

public class Test1 {
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(10);
        list.add(13);
        list.add(15);

        Iterator<Integer> iterator = list.iterator();

        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }

        for(int x :list){
            System.out.println(x);
        }
    }
}
