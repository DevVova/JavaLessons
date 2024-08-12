package metanit.oop;

/**
 * Любую программу на Java можно представить как набор взаимодействующих между собой объектов.
 *<p>
 * Шаблоном или описанием объекта является класс, а объект представляет экземпляр этого класса.
 * Любой объект может обладать двумя основными характеристиками: состояние - некоторые данные,
 * которые хранит объект, и поведение - действия, которые может совершать объект.
 * Для хранения состояния объекта в классе применяются поля или переменные класса. Для определения
 * поведения объекта в классе применяются методы.
 * <p>
 * Кроме обычных методов классы могут определять специальные методы, которые называются конструкторами.
 * Конструкторы вызываются при создании нового объекта данного класса. Конструкторы выполняют
 * инициализацию объекта.
 * <p>
 * Кроме конструктора начальную инициализацию объекта вполне можно было проводить с помощью
 * инициализатора объекта. Инициализатор выполняется до любого конструктора. То есть в
 * инициализатор мы можем поместить код, общий для всех конструкторов.
 * <p>
 * Ключевое слово this представляет ссылку на текущий экземпляр класса. Через это ключевое слово мы
 * можем обращаться к переменным, методам объекта, а также вызывать его конструкторы.
 */
public class L25_Classes {
    public static void main(String[] args) {
        Human vova = new Human();
        vova.age = 46;
        vova.info();

        Human gena = new Human(33, "Gena");
        gena.age = 32;
        gena.info();

        Human misha = new Human(48);
        misha.name = "Misha";
        misha.info();
    }
}

//Ниже определён класс. Его нужно писать без модификатора public. Так как такой класс в файле должен быть один и название файла должно с ним совпадать.
class Human {
    int age;
    String name;

    //Ниже идёт блок инициализатора.
    {
        age = 10;
        name = "Vova";
    }

    //Ниже идут конструкторы.
    Human(){}
    Human(int age) {
        this(age, "Human");//Здесь мы используем по факту конструктор, который ниже.
    }
    Human(int age, String name) {
        this.age = age;//Здесь мы обращаемся к полю класса и меняем его значение на указанный в конструкторе аргумент.
        this.name = name;

        this.info();//При вызове этого конструктора сработает метод.
    }

    void info() {
        System.out.printf("He is %s. He's %d years old.\n", name, age);
    }
}