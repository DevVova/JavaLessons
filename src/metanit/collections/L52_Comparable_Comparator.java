package metanit.collections;

import org.jetbrains.annotations.NotNull;

import java.util.*;

/**
 * Для того чтобы объекты любого класса можно было сравнить и сортировать, они должны применять
 * интерфейс Comparable<E>. При применении интерфейса он типизируется текущим классом.
 * <p></p>
 * Однако перед нами может возникнуть проблема, что если разработчик не реализовал в своем классе,
 * который мы хотим использовать, интерфейс Comparable, либо реализовал, но нас не устраивает его
 * функциональность, и мы хотим ее переопределить? На этот случай есть еще более гибкий способ,
 * предполагающий применение интерфейса Comparator<E>.
 * Интерфейс Comparator содержит ряд методов, ключевым из которых является метод compare().
 * Метод compare также возвращает числовое значение - если оно отрицательное, то объект a
 * предшествует объекту b, иначе - наоборот. А если метод возвращает ноль, то объекты равны.
 * Для применения интерфейса нам вначале надо создать класс компаратора, который реализует этот интерфейс.
 */
public class L52_Comparable_Comparator {
    public static void main(String[] args) {
        NavigableSet<Person> people = new TreeSet<>();
        people.add(new Person("Sam", 22));
        people.addAll(Arrays.asList(new Person("Ted", 31), new Person("Vova", 46)));
        people.add(new Person("Fillip", 36));
        for (Person p : people) {
            System.out.print(p.name() + " ");
        }
        System.out.println();

        Comparator<Person> comparatorPeople = new PersonComparator();
        NavigableSet<Person> people2 = new TreeSet<>(comparatorPeople);
        people2.addAll(people);
        for (Person p : people2) {
            System.out.print(p.name() + " ");
        }
        System.out.println();
        people2.add(new Person("Den", 46));

        //Ниже пример создания цепочки, когда сначала сравнивают возраст, а потом имя.
        Comparator<Person> pComp = new PersonAgeComparator().thenComparing(new PersonNameComparator());
        SortedSet<Person> personSortedSet = new TreeSet<>(pComp);
        personSortedSet.addAll(people2);
        personSortedSet.add(new Person("Sam", 23));//Добавил ещё Сэма, но с другим возрастом.
        for (Person p : personSortedSet) {
            System.out.print(p.name() + " ");
        }
        System.out.println();
    }
}

record Person(String name, int age) implements Comparable<Person> {

    //Ниже переопределённый метод, который записывает в набор имена в зависимости от длины имени, если же длина одинаковая, то сначала будет записано имя первое в алфавитном порядке.
    @Override
    public int compareTo(@NotNull Person p) {
        int differenceBetweenName = name.length() - p.name().length();
        if (differenceBetweenName == 0) {
            return name.compareTo(p.name());//В данном случае мы не возвращаем явным образом никакое число, а полагаемся на встроенный механизм сравнения, который есть у класса String.
        } else return name.length() - p.name().length();
    }
}

class PersonComparator implements Comparator<Person> {

    @Override
    public int compare(Person o1, Person o2) {
        if (o1.name().length() > o2.name().length()) return -1;
        else if (o1.name().length() < o2.name().length()) return 1;
        else {
            return o1.name().compareTo(o2.name());
        }
    }
}

class PersonNameComparator implements Comparator<Person> {

    @Override
    public int compare(Person o1, Person o2) {
        if (!Objects.equals(o1.name(), o2.name())) return o1.name().compareTo(o2.name());
        else return 0;
    }
}

class PersonAgeComparator implements Comparator<Person> {

    @Override
    public int compare(Person o1, Person o2) {
        return Integer.compare(o1.age(), o2.age());
    }
}