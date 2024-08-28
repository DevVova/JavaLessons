package metanit.practice;

import java.util.*;

public class MyComparator {
    public static void main(String[] args) {
        Comparator<MyPerson> mpComp = new MyPersonComparator();
        NavigableSet<MyPerson> myPersons = new TreeSet<>(mpComp);
        myPersons.addAll(Arrays.asList(new MyPerson(21, "Kolya"), new MyPerson(13, "Gena")));

        List<MyPerson> myPersonList = new ArrayList<>(myPersons);
        int i = myPersons.size() - 1;
        while (i >= 0) {
            System.out.print(myPersonList.get(i).name() + " ");
            i--;
        }
        System.out.println();
    }
}

//Допустим у нас есть класс не реализующий интерфейс Comparable или реализующий не так как нам хотелось бы.
record MyPerson(int age, String name) {}

class MyPersonComparator implements Comparator<MyPerson> {
    @Override
    public int compare(MyPerson p1, MyPerson p2) {
        return p1.name().compareTo(p2.name());
    }
}