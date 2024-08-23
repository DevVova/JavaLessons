package metanit.practice;

import java.util.ArrayList;

public class Collections {
    public static void main(String[] args) {
        People9[] person = new People9[3];
        person[0] = new People9(12, "Ted");
        person[1] = new People9(14, "Sam");
        person[2] = new People9(11, "Coin");
        for (People9 names : person) {
            System.out.printf("%s  ", names.getName());
        }
        System.out.println("\n");

        ArrayList<People9> people = new ArrayList<>();
        people.add(new People9(21, "Rob"));
        people.add(new People9(31, "Larry"));
        people.add(person[1]);
        for (People9 man : people) {
            System.out.printf("%s   ", man.getName());
        }
        System.out.println("\n");

        people.add(2, new People9(44, "Aks"));
        for (People9 men : people) {
            System.out.printf("%s ", men.getName());
        }
        System.out.println("\n");

        people.set(2, new People9(33, "Kolya"));
        for (People9 men : people) {
            System.out.printf("%s ", men.getName());
        }
        System.out.println("\n");

        People9 someHuman = new People9(44, "Aks");
        if (people.contains(someHuman)) System.out.println("yes");
        else System.out.println("no");
    }
}

class People9 {
    private final int age;
    private final String name;

    public People9(int age, String name) {
        this.age = age;
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public String getName() {
        return name;
    }
}