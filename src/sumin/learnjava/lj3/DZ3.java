package sumin.learnjava.lj3;

import java.util.Scanner;

public class DZ3 {
    public static void main(String[] args) {
        System.out.print("Введите количество секунд: ");
        Scanner in = new Scanner(System.in);
        int times = in.nextInt();
        int days = times / (24 * 3600);
        int hours = times % (24 * 3600) / 3600;
        int minutes = (times % (24 * 3600)) % 3600 / 60;
        int seconds = times - days * 24 * 3600 - hours * 3600 - minutes * 60;
        System.out.printf("%d секунд это: \n", times);
        System.out.println(days + " дней,");
        System.out.println(hours + " часов");
        System.out.println(minutes + " минут");
        System.out.println("и " + seconds + " секунд.");
    }
}
