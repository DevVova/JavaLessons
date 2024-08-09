import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
        next();
    }
    static void next() {
        Scanner in = new Scanner(System.in);
        System.out.print("Введите число от 1 до 100: \n");
        int n;
        try {
            n = in.nextInt();
            if (n >= 1 && n <= 100) {
                System.out.printf("Вы ввели число %d.\n", n);
                System.out.println("Программа успешно завершила свою работу.");
            }

            if (n < 1 || n > 100) {
                throw new Exception("Вы вышли из диапазона. Введите правильное число в диапазоне от 1 до 100");
            }
        }
        catch(Exception ex) {
            System.out.println(ex.getMessage());
            next();
        }
        in.close();
    }
}