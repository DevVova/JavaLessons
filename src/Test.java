import java.util.Locale;
import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
        System.out.print("Введите десятичное число с точкой в качестве разделителя дробной части: ");
        Scanner in = new Scanner(System.in);
        in.useLocale(Locale.US);
        float a = in.nextFloat();
        System.out.printf("Вы ввели %.1f.\n", a);
        in.close();
    }
}