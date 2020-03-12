package by.it.yurtsevich.videoCourse2.lesson8;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Test1 {
    public static void main(String[] args) {
        Map<Person, String> map = new HashMap<>();
        Set<Person> set = new HashSet<>();

        Person person1 = new Person(1, "Katya");
        Person person4 = new Person(1, "Katya");
        Person person2 = new Person(2, "Misha");
        Person person3 = new Person(2, "Misha");

        map.put(person1, "123");
        map.put(person2, "123");
        map.put(person3, "123");
        map.put(person4, "123");

        set.add(person1);
        set.add(person2);
        set.add(person3);
        set.add(person4);

        System.out.println(map);
        System.out.println(set);

    }
}
class Person{
    private int id;
    private String name;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Person person = (Person) o;

        if (id != person.id) return false;
        return name != null ? name.equals(person.name) : person.name == null;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        return result;
    }
}
