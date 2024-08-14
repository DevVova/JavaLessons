package metanit.oop;

/**
 * Кроме обычных классов в Java есть абстрактные классы. Абстрактный класс похож на
 * обычный класс. В абстрактном классе также можно определить поля и методы, но в то же
 * время нельзя создать объект или экземпляр абстрактного класса. Абстрактные классы
 * призваны предоставлять базовый функционал для классов-наследников. А производные классы
 * уже реализуют этот функционал.
 */
public class L32_Abstract_Classes {
    public static void main(String[] ar) {
        Cat murzik = new Cat(4);
        murzik.voice();
    }
}

abstract class Animal {
    int age;

    public Animal(int age) {
        this.age = age;
    }

    abstract void voice();
}

class Cat extends Animal{

    public Cat(int ageCat) {
        super(ageCat);
    }

    @Override//Эту аннотацию можно не писать, но я думаю лучше писать, потому что так визуально всё понятно более.
    void voice() {
        System.out.println("Mau.");
    }
}