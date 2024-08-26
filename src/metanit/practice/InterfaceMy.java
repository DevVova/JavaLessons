package metanit.practice;

/**
 * Я в этом примере изучал как можно создавать объект типа интерфейса без использования класса, а
 * точнее его конструктора.
 */
public class InterfaceMy {
    public static void main(String[] args) {
        My myInterface = new My() {
            @Override
            public void print() {
                System.out.println("Hello!");
            }
        };
        myInterface.print();
    }
}

interface My {
    void print();
}