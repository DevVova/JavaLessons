package metanit.oop;

/**
 * Записи (record) в Java — это новый тип данных, представленный в Java 14 и окончательно
 * добавленный в Java 16. Записи предоставляют удобный способ создания неизменяемых
 * данных-объектов, которые автоматически реализуют некоторые методы и упрощают создание таких объектов.
 * Поля записей являются неизменяемыми (final), что означает, что их значения можно установить только
 * один раз — в конструкторе. После этого они не могут быть изменены.
 * Как переопределять канонический конструктор я не стал. Там нужно знать как работать с исключениями. Да и
 * вообще нужно этого избегать, как я считаю.
 */
public class L42_Records {
    public static void main(String[] args) {
        NewHome mHome = new NewHome(290);
        System.out.println(mHome.price());
        System.out.println(mHome);

        NewHome yHome = new NewHome(-89);
        System.out.println(yHome.price());

        Cat2 cat2 = new Cat2("K");
        Cat2.age = 23;
        System.out.printf("Возраста кота %d.\n", Cat2.age);
        System.out.println(cat2.name());

        NewPerson newPerson = new NewPerson(22, "Tom");
        System.out.println(newPerson.age());
    }
}

record NewPerson(int age, String name) {}

//Для записей можно имплементировать интерфейсы.
record NewHome(int price) implements Sellable2 {
    public int price() {
        if (this.price < 0 || this.price == 0) return 1;
        else return this.price;
    }

    //Можно добавлять методы.
    public void info() {
        System.out.printf("Дом стоит %d.\n", price);
    }

    @Override
    public void sell() {
        System.out.println("Home is sellable.");
    }
}

interface Sellable2 {
    void sell();
}

/*
Мы не можем наследовать запись record от других классов. Также нельзя наследовать классы
от records. Однако классы record могут реализовать интерфейсы. Кроме того, классы record
не могут быть абстрактными.
В record нельзя явным образом определять нестатические поля и инициализаторы. Но можно
определять статические переменные и инициализаторы, также как статические и нестатические методы:
 */
record Cat2(String name) {
    static int age;
    static {
        age = 9;
        System.out.println("age is initialize.");
    }
}