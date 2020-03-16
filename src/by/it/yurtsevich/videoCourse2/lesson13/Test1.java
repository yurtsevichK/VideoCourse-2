package by.it.yurtsevich.videoCourse2.lesson13;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;

public class Test1 {
    public static void main(String[] args) {
        Person person1 = new Person(1);
        Person person2 = new Person(2);
        Person person3 = new Person(3);
        Person person4 = new Person(4);

        Queue<Person> people = new ArrayBlockingQueue<Person>(3);

        // Кто первый к очереди подошел тот первый из нее и вышел
        // 3 <- 4 <- 2 <- 1

        // Метод ремув удаляет первый элемент в очереди (ид 3)
        //System.out.println(people.remove());

        // Метод пик показывает первого в очереди не удаляя его
        System.out.println(people.peek());


        // Метод оффер добавляет в очередь как и метод ЭДД, разница в том, что метод оффер не выдает исключение
        System.out.println(people.offer(person3));
        System.out.println(people.offer(person4));
        System.out.println(people.offer(person2));
        System.out.println(people.offer(person1));

        // Метод полл работает как рему,но он как и оффер не выдает исключение
    }
}

class Person {
    private int id;

    public Person(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                '}';
    }
}