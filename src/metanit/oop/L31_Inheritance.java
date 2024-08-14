package metanit.oop;

/**
 * С помощью наследования можно расширить функционал уже имеющихся классов за счет
 * добавления нового функционала или изменения старого.
 */
public class L31_Inheritance {
    public static void main(String[] args) {
        Person vova = new Person("Vova");
        vova.setName("Vladimir");
        vova.info();
        System.out.println(vova.getName());

        Employee tom = new Employee("Tom", "IBM");
        System.out.println(tom.getName());
        tom.hello();
        tom.work();
        tom.info();

        Human22 sam = new Human22();
        sam.hello();

        //Динамическая диспетчеризация методов.
        //Здесь хоть мы создаём переменную типа Person, но она ссылается на объект Employee. Поэтому мы сможем вызывать методы класса Employee.
        //Это также называется dynamic method lookup или динамический поиск метода или динамическая диспетчеризация методов.
        Person gena = new Employee("Gena", "Sony");
        gena.info();
    }
}

class Person {
    private String name;

    public Person(String nameInput) {
        name = nameInput;
    }

    public void setName(String nameIn) {
        name = nameIn;
    }

    public String getName() {
        return name;
    }

    protected void info() {
        System.out.printf("He is %s.\n", name);
    }

    //Ниже пример метода который нельзя переиспользовать в классах наследниках.
    public final void hello() {
        System.out.println("Hello!");
    }
}

class Employee extends Person {
    String company;
    public Employee (String nameEmp, String companyEmp) {
        super(nameEmp);
        this.company = companyEmp;
    }

    public void work() {
        System.out.printf("%s works in %s.\n", getName(), company);
    }

    //Ниже пример переопределения метода и добавления новой функциональности к имеющейся.
    @Override
    protected void info() {
        super.info();
        System.out.println("He works in " + company + ".");
    }
}

//Ниже класс который нельзя наследовать.
final class Human22 {
    int age = 75;

    public void hello() {
        System.out.println("Hello human is !" + age);
    }
}