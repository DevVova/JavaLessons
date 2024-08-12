package metanit.oop;

public class ImportPackages {
    int number;
    public ImportPackages(int num) {
        number = num;
    }
    public void printInfo() {
        System.out.printf("The number equals %d.\n", number);
    }
    protected void printNumber() {
        System.out.println(number);
    }
}
