public class Main {
    public static void main(String[] args) {
        System.out.println("Hello Vova! Остальные нахер!");
        Trader vova = new Trader("Vova", 46);
        vova.info();
    }
}

class Man {
    int age;

    public void info() {
        System.out.println("He is " + age + " years old.");
    }
}

class Trader extends Man {
    String name;
    public Trader(String nameIn, int ageIn) {
        name = nameIn;
        this.age = ageIn;
    }

    @Override
    public void info() {
        System.out.println("He is " + name + ".");
        super.info();
    }
}