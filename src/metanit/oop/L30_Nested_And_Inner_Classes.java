package metanit.oop;

/**
 * Внутренний класс является нестатическим, и у него есть неявная ссылка на объект
 * внешнего класса, внутри которого он объявлен. Это означает, что он может обращаться
 * к нестатическим членам внешнего класса напрямую.
 * Чтобы создать экземпляр внутреннего класса, нужно сначала создать экземпляр внешнего класса.
 * <p>
 * Вложенный класс объявляется как static, и он не имеет неявной ссылки на объект
 * внешнего класса. Он может напрямую обращаться только к статическим членам внешнего класса.
 * Экземпляр вложенного класса можно создать без создания экземпляра внешнего класса.
 */
public class L30_Nested_And_Inner_Classes {
    public static void main(String[] args) {
        //Создание объекта внутреннего класса.
        Outer o = new Outer();//Сначала создаём объект внешнего класса.
        Outer.Inner i = o.new Inner();//Затем уже только создаём объект внутреннего класса.
        i.infoInner();

        //Создание объекта вложенного класса.
        Outer.Nested n = new Outer.Nested();
        n.infoNested();

        Outer o1 = new Outer();
        Outer.Inner i1 = o1.new Inner();
        o1.num = 55;
        Outer.num2 = 44;
        i1.infoInner();
        n.infoNested();
    }
}

class Outer {
    int num = 9;
    static int num2 = 10;

    void infoNum() {
        System.out.printf("Number = %d.\n", num);//Метод имеет доступ и к статическому полю и к нестатическому.
    }

    static void infoNum2() {
        System.out.printf("Number = %d.\n", num2);//Метод имеет доступ только к статическому полю.
    }

    static class Nested {
        void infoNested() {
            System.out.printf("Number = %d. Nested class.\n", num2);//Метод имеет доступ только к статическому полю.
        }
    }

    class Inner {
        void infoInner() {
            System.out.printf("Number = %d. Inner class\n", num);//Метод имеет доступ и к статическому полю и к нестатическому.
        }
    }
}