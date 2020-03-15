package by.it.yurtsevich.videoCourse2.lesson11;

import java.util.*;

public class Test1 {
    public static void main(String[] args) {
        List<Person> people = new ArrayList<>();
        people.add(new Person(2, "Jon"));
        people.add(new Person(1, "Bob"));
        people.add(new Person(3, "Frank"));

        Collections.sort(people, new Comparator<Person>() {
            @Override
            public int compare(Person person, Person t1) {
                if (person.getId() > t1.getId()) {
                    return 1;
                } else if (person.getId() < t1.getId()) {
                    return -1;
                } else {
                    return 0;
                }
            }
        });
        System.out.println(people);

        List<String> animals = new LinkedList<>();
        animals.add("Monkey");
        animals.add("Dog");
        animals.add("Cat");
        animals.add("Frog");

        // Метод сорт, сортирует листы согласно порядку, который определен обьектами этого листа
        // в данном случае просто по алфавиту !!!ЛЕКСИГОГРАФИЧЕСКИ
        // !! ЕСЛИ вставляем СВОЙ КОМПАРАТОР лексикографический не учитывается вообще
        Collections.sort(animals, new StringLenghtComporator());
        System.out.println(animals);

        List<Integer> numbers = new LinkedList<>();
        numbers.add(3311);
        numbers.add(34231);
        numbers.add(1321);
        numbers.add(1223);

        // Отсортировали цифры в обычном возростающем порядке ( по умолчанию)
        Collections.sort(numbers, new BackWordsIntegerComparator());
        System.out.println(numbers);

    }
}

/*
       o1 > o2 => 1
       o1 < o2 => -1
       o1 = o2 => 0

       compare (1, 2) => -1
       compare (2, 1) => 1
       compare (1, 1) => 0
       */
class StringLenghtComporator implements Comparator<String> {
    @Override
    public int compare(String o1, String o2) {
        if (o1.length() > o2.length()) {
            return 1;
        } else if (o1.length() < o2.length()) {
            return -1;
        } else {
            return 0;
        }
    }
}

class BackWordsIntegerComparator implements Comparator<Integer> {
    @Override
    public int compare(Integer integer, Integer t1) {
        if (integer > t1) {
            return -1;
        } else if (integer < t1) {
            return 1;
        } else {
            return 0;
        }
    }
}

class Person {
    private int id;
    private String name;

    public int getId() {
        return id;
    }

    public Person(int id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}