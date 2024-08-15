package metanit.oop;

/**
 * Механизм наследования очень удобен, но он имеет свои ограничения. В частности мы можем
 * наследовать только от одного класса, в отличии, например, от языка С++, где имеется множественное наследование.
 * <p>
 * В языке Java подобную проблему частично позволяют решить интерфейсы. Интерфейсы
 * определяют некоторый функционал, не имеющий конкретной реализации, который затем
 * реализуют классы, применяющие эти интерфейсы. И один класс может применить множество интерфейсов.
 * <p>
 * Чтобы определить интерфейс, используется ключевое слово interface.
 * <p>
 * В общем, при выборе названия для интерфейса важно учитывать его предназначение и концепцию,
 * чтобы имя было интуитивно понятным и точно отражало суть интерфейса. Если интерфейс описывает
 * поведение — лучше использовать причастие. Если он описывает некую сущность или роль — лучше выбрать существительное.
 */
public class L34_Interfaces {
    public static void main(String[] args) {
        Book book = new Book();
        book.sell();
        book.printDefault();

        //Так как и Book и Journal реализуют один интерфейс, то можно у переменной типа интерфейса менять присваиваемые объекты, классы которых также используют этот объект.
        //Здесь будет доступен только метод print().
        Printable book2 = new Book();
        book2.print();
        ((Book)book2).sell();//Если мы захотим вызвать метод из класса Book, то нужно явное приведение типов.

        book2 = new Journal();
        book2.print();
        book2.printDefault();

        Printable.printStatic();

        BookPrintable book3 = new Book2();
        book3.booksPrint();

        Printer.Printable2 book5 = new Book3();
        book5.pr();


        printIn(book2);
    }

    //И также, как и в случае с классами, интерфейсы могут использоваться в качестве типа параметров метода или в качестве возвращаемого типа.
    static void printIn(Printable p) {
        p.printDefault();
        p.print();
    }
}

interface Printable {
    int PRICEP = 3000;//Хотя такие константы также не имеют модификаторов, но по умолчанию они имеют модификатор доступа public static final.

    void print();

    //Ниже метод по умолчанию, который можно не реализовывать в классе использующем этот интерфейс.
    default void printDefault() {
        System.out.println("Print default.");
        printPrivate();
    }

    //Ниже пример статического метода, который должен быть реализован.
    static void printStatic() {
        System.out.println("Статический метод интерфейса.");
    }

    //Интерфейсы могут содержать приватные методы.
    private void printPrivate() {
        System.out.println("Приватный метод.");
    }
}

interface Sellable {
    int P = 9;//Можно писать поля, но только инициализированные. Они будут константы и их значение в дальнейшем изменить нельзя.

    void sell();
}

class Book implements Printable, Sellable {

    @Override
    public void print() {
        System.out.println("The book print." + PRICEP);
    }

    @Override
    public void sell() {
        System.out.println("The book sell. Price = " + P + ". Minimum price is ");
    }
}

class Journal implements Printable{

    @Override
    public void print() {
        System.out.println("The journal print.");
    }

    //Можно переопределять методы по умолчанию.
    @Override
    public void printDefault() {
        System.out.print("Метод по умолчанию переопределён.\n");
    }
}

//Ниже пример наследования интерфейсом интерфейса.
interface BookPrintable extends Printable {
    void booksPrint();
}

class Book2 implements BookPrintable {
    @Override
    public void booksPrint() {
        System.out.println("Book print!!!");
    }

    @Override
    public void print() {
        System.out.println("Print!!!");
    }
}

//Ниже пример класса с вложенным интерфейсом.
class Printer {
    interface Printable2 {
        void pr();
    }
}

class Book3 implements Printer.Printable2 {

    @Override
    public void pr() {
        System.out.println("Nested interface.");
    }
}