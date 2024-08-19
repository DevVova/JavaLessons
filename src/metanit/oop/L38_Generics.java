package metanit.oop;

/**
 * Обобщения или generics (обобщенные типы и методы) позволяют нам уйти от жесткого определения используемых типов.
 */
public class L38_Generics {
    public static void main(String[] args) {
        Account<Integer> vova = new Account<>("Vova", 2345);
        System.out.println(vova.hashCode());
        Account<String> gena = new Account<>("Gena", "3457");
        System.out.println(gena);//Здесь можно опускать gena.toString и писать так.

        Accountable<Integer> myAccount = new Account2(34);
        int id = myAccount.getId();
        System.out.println(id);

        Accountable<Integer> yourAccount = new Account3<>(3444);
        System.out.println(yourAccount.getId());

        Account4 a = new Account4(22220);
        System.out.println(a.out(yourAccount));
        a.printType(myAccount);

        Integer[] arr1 = new Integer[] {23, 34, 3};
        M m = new M();
        m.printArray(arr1);

        Next<Integer, String> next = new Next<>(2311, "343434345", m);
        next.printName();
        next.setName("Next name");
        next.printName();
    }
}

class Account<T> {
    private T id;
    private String nameClient;

    Account(String name, T id) {
        nameClient = name;
        this.id = id;
    }
}

//Ниже пример использования обобщённого интерфейса.
interface Accountable<T> {
    T getId();
}

class Account2 implements Accountable<Integer> {
    private int id;

    public Account2(int id) {
        this.id = id;
    }

    @Override
    public Integer getId() {
        return id;
    }
}

//Пример ниже не привязывает использования Accountable только определённого типа.
class Account3<T> implements Accountable<T> {
    private T id;

    public Account3(T id) {
        this.id = id;
    }

    @Override
    public T getId() {
        return id;
    }
}

class Account4 {
    private int id;

    Account4(int id) {
       this.id = id;
    }

    //Ниже пример метода обобщённого.
    public <T> void printType(T input) {
        System.out.printf("Тип соответствует %s.\n", input.getClass());
    }

    public <P> int out(P num) {
        return num.hashCode();
    }
}

class M {
    public <T> void printArray(T[] args) {
        for (T a : args) {
            System.out.printf("%s ", a);
        }
        System.out.println();
    }
}

//Пример использования нескольких обобщений.
class Next<T, S> {
    private T id;
    private S num;
    private String name;

    //Ниже пример использования обобщённого конструктора.
    <K>Next(T id, S num, K name) {
        this.id = id;
        this.num = num;
        this.name = name.toString();
    }

    public <F> void setName(F name) {
        this.name = name.toString();
    }

    public void printName() {
        System.out.println(name);
    }
}