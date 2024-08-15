package metanit.oop;

public class L33_UpCasting_And_DownCasting {
    public static void main(String[] args) {
        //UpCasting.
        /*
        Используя upcasting мы инкапсулируем детали подклассов, то есть можем обращаться только к полям и методам суперкласса.
        Также хоть мы и используем доступ к одному и тому же методу, но реализация (как в примере ниже) у него будет разной,
        это использование так называемого полиморфизма.
        Хоть переменные и одного типа(класса), но это ссылки на объекты разных классов.
        Такое преобразование осуществляется автоматически.
         */

        Figure f = new Cube(23, 1000);//Это так называемое восходящее преобразование (от подкласса внизу к суперклассу вверху иерархии) или upcasting.
        System.out.println(f.calculateSquare());//В этом случае не будет у объекта доступа к методу info.

        Figure f1 = new Circle(22);
        System.out.println(f1.calculateSquare());

        //Ниже создали переменную которая имеет один тип, что и присваиваемые ей значения, но по факту она меняет свои ссылки на разные объекты.
        Figure f2 = f1;
        System.out.println(f2.calculateSquare());
        f2 = f;
        System.out.println(f2.calculateSquare());

        //*********************************************************************
        //DownCasting. Лучше не использовать вообще.
        Figure d = new Cube(17, 700);
        Cube d1 = (Cube) d;//А вот если было бы Figure d = new Figure(17); , то при вызове метода снизу у нас была бы ошибка. Потому что ссылались бы в итоге на Figure.
        System.out.println(d1.calculateSquare());

        Object d2 = new Cube(11, 300);//Все объекты произошли от класса Object.
        System.out.println(((Cube)d2).calculateSquare());//Можно и так писать.

        //Instanceof - это оператор, который позволяет проверить является ли ссылка ссылкой на определённый объект.
        //Это необходимо если мы в программе не можем сразу этого определить.
        Figure dd = new Figure(33);
        if (dd instanceof Cube) {
            Cube dd1 = (Cube) dd;
            System.out.println(dd1.calculateSquare());
        } else System.out.println("Conversion is invalid");
        //Ниже современный более короткий вариант начиная с java 16.
        if (dd instanceof Cube dd2) {
            System.out.println(dd2.calculateSquare());
        } else System.out.println("Conversion is invalid. New version java 16.");
    }
}

class Figure {
    int size;

    public Figure(int size) {
        this.size = size;
    }

    public int calculateSquare() {
        System.out.println("Figure class.");
        return size * size;
    }
}

class Cube extends Figure {
    int price;

    public Cube(int size, int price) {
        super(size);
        this.price = price;
    }

    public void info() {
        System.out.println("This is a cube.");
    }

    @Override
    public int calculateSquare() {
        int result = size * size;
        System.out.printf("The cube square equals %d.\n", result);
        return result;
    }
}

class Circle extends Figure {
    int radius;
    final double PI = 3.14;

    Circle(int size) {
        super(size);
        radius = size;
    }

    @Override
    public int calculateSquare() {
        int result = (int)(PI * (double)((size / 2) * (size / 2)));
        System.out.printf("The circle square equals %d.\n", result);
        return result;
    }
}