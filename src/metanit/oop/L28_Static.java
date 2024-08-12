package metanit.oop;
import static metanit.oop.StaticClass.println;

/**
 * При создании объектов класса для каждого объекта создается своя копия нестатических
 * обычных полей. А статические поля являются общими для всего класса. Поэтому они могут
 * использоваться без создания объектов класса.
 */
public class L28_Static {
    public static void main(String[] args) {
        Class2 cl2 = new Class2();
        cl2.infoCount();
        Class2.count = 9;
        cl2.infoCount();
        System.out.println(Class2.CON);
        Class2.infoCountStat();
    }
}

class Class2 {
    static int count = 1;
    static final int CON = 66;//Статическая константа.
    static int value;

    /*
    Статические инициализаторы предназначены для инициализации статических переменных,
    либо для выполнения таких действий, которые выполняются при создании самого первого объекта.
     */
    static {
        value = 456;
        System.out.printf("Инициализирована переменная значением %d.\n", value);
    }

    void infoCount() {
        println(Integer.toString(count));
    }

    //Ниже определение статического метода, он может использовать только статические поля и константы, ну и методы.
    static void infoCountStat() {
        System.out.printf("Статическое поле count = %d.\n", count);
    }
}