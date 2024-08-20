package metanit.oop;

/**
 * Когда мы указываем универсальный параметр у обобщений, то по умолчанию он может представлять
 * любой тип. Однако иногда необходимо, чтобы параметр соответствовал только некоторому
 * ограниченному набору типов. В этом случае применяются ограничения, которые позволяют
 * указать базовый класс, которому должен соответствовать параметр.
 * <p>
 * Для установки ограничения после универсального параметра ставится слово extends,
 * после которого указывается базовый класс ограничения.
 */
public class L39_Generic_limitations {
    public static void main(String[] args) {
        Driver<Integer> vova = new Driver<Integer>(767,"Vova.");
        Driver<Integer> den = new Driver<Integer>(887,"Den.");
        Driver<String> gena = new Driver<String>("22", "Gena");
        BusDrivers<Driver<Integer>> colum = new BusDrivers<>(vova, den);//В данном случае здесь в качестве обобщённого типа выступает ограничение.
        BusDrivers<Driver<String>> colum2 = new BusDrivers<>(gena, gena);
        colum.info();
        colum2.info();
        System.out.println(vova.getId());

        TestDriver<Drivable<Integer>> col = new TestDriver<>(den, vova);
        col.info();

        TestDriver<Driver<String>> col1 = new TestDriver<>(gena, gena);
        col1.info();
    }
}

interface Drivable<T> {
    T getId();
    void drive();
}

class Driver<T> implements Drivable<T>{
    private final T id;
    private String name;

    public <K>Driver(T id, K name) {
        this.id = id;
        this.name = name.toString();
    }


    @Override
    public T getId() {
        return id;
    }

    @Override
    public void drive() {
        System.out.println("Driver drive.");
    }
}

class BusDrivers<T extends Driver<?>> {
    private final T driver1;
    private final T driver2;

    public BusDrivers(T driver1, T driver2) {
        this.driver1 = driver1;
        this.driver2 = driver2;
    }

    public void info() {
        System.out.println("Driver1 - " + driver1.getId() + ".");
        driver1.drive();
        System.out.println("Driver2 - " + driver2.getId() + ".");
        driver1.drive();
    }
}

class TestDriver<T extends Drivable<?>> {
    private final T driver1;
    private final T driver2;

    public TestDriver(T driver1, T driver2) {
        this.driver1 = driver1;
        this.driver2 = driver2;
    }

    public void info() {
        System.out.println("Driver1 - " + driver1.getId() + ".");
        driver1.drive();
        System.out.println("Driver2 - " + driver2.getId() + ".");
        driver1.drive();
    }
}