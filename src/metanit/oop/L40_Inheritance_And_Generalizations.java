package metanit.oop;

/**
 * Обобщенные классы могут участвовать в иерархии наследования: могут наследоваться от других,
 * либо выполнять роль базовых классов.
 */
public class L40_Inheritance_And_Generalizations {
    public static void main(String[] args) {
        Tuna<String, String> f = new Tuna<>("30000", "My");
        f.setPrice("20000");
        System.out.println(f.getPrice());

        Tuna<Integer, Integer> ff = new Tuna<>(34, 333333);
        System.out.println(ff.getPrice());
        ff.info();

        Marlin m = new Marlin(343432, "mio");
        m.info();

        NewMarlin<Integer> nm = new NewMarlin<>(2, "m", 4);
        nm.info();

        //Ниже пример преобразования обобщённых типов.
        Fish<String> fishMy = new Fish<>("1010");
        fishMy.setPrice("009");
        fishMy = (Fish<String>) f;
        System.out.println(fishMy.getPrice());
    }
}

class Fish<T> {
    private T price;

    public Fish(T price) {
        this.price = price;
    }

    public void setPrice(T price) {
        this.price = price;
    }

    public T getPrice() {
        return price;
    }
}

class Tuna<T, S> extends Fish<T> {
    S name;

    public Tuna(T pr, S name) {
        super(pr);
        this.name = name;
    }

    public void info() {
        System.out.printf("Its name is %s.\n", name);
    }
}

//Класс может наследоваться и сам быть необобщённым.
class Marlin extends Tuna<Integer, String> {
    public Marlin(Integer price, String name) {
        super(price, name);
    }
}

//А это пример наследования от необобщённого класса обобщённого.
class NewMarlin<T> extends Marlin {
    T newPrice;
    public NewMarlin(Integer p, String n, T newP) {
        super(p, n);
        newPrice = newP;
    }
}