package metanit.oop;

/**
 * Хотя мы можем создать обычный класс, который не является наследником, но фактически
 * все классы наследуются от класса Object. Все остальные классы, даже те, которые
 * мы добавляем в свой проект, являются неявно производными от класса Object. Поэтому
 * все типы и классы могут реализовать те методы, которые определены в классе Object.
 * Рассмотрим эти методы, которые кстати можно спокойно переопределять.
 */
public class L37_Object {
    public static void main(String[] st) {
        Notebook myBook = new Notebook("MyBook");
        String t = myBook.toString();//Этот метод возвращает строковое представление объекта, он переопределён.
        System.out.print(t + ".\n");
        int h = myBook.hashCode();//Метод hashCode позволяет задать некоторое числовое значение, которое будет соответствовать данному объекту или его хэш-код. По данному числу, например, можно сравнивать объекты.
        System.out.printf("Хэш код равен %d.\n", h);
        Notebook yourBook = new Notebook("Your Book");
        int h2 = yourBook.hashCode();//идентификационный хеш использует целочисленное представление адреса памяти.
        System.out.println(h == h2);
        System.out.printf("Хэш код равен %d.\n", h2);
        Notebook myBook2 = new Notebook("MyBook");
        System.out.println(myBook2.hashCode() == myBook.hashCode());
        System.out.printf("Хэш код равен %d.\n", myBook2.hashCode());
        System.out.println(myBook2.equals(myBook));//Метод equals сравнивает два объекта на равенство.
        System.out.print(myBook2.getClass());//Метод позволяет получить тип объекта.
        System.out.println();
        System.out.println(myBook2 instanceof Notebook);//Так можно узнать является ли объект объектом определённого класса.
    }
}

final class Notebook {
    static int price;
    private String name;

    public Notebook(String name) {
        this.name = name;
    }

    public void setName(String newName) {
        name = newName;
    }

    //Ниже переопределённый метод toString().
    @Override
    public String toString() {
        return "Notebook    " + name;
    }

    static int getPrice() {
        return price;
    }
}