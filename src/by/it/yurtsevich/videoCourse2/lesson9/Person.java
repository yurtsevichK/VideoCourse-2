package by.it.yurtsevich.videoCourse2.lesson9;


public class Person {
    private int id;
    private String name;

    public Person(int id, String name) {
        this.id = id;
        this.name = name;

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Person person = (Person) o;

        if (id != person.id) return false;
        return name != null ? name.equals(person.name) : person.name == null;
    }
    // object -> int
    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        return result;
    }
    /*
        Контаркт hashcode() equals()

        1) У двух вызываемых обьектов вызываем метод хешкод
        если хэши разные, то значит два обьекта точно разные.

        2) Если хэши оказались одинаковые, мы точно не знаем, реально одинаковые обьекты
        или случилась колизия, в этом случаи мы проверяем иквелс.

        3)Метод иквелс выдает нам точный ответ одинаковые эти обьекты или нет
    */
}