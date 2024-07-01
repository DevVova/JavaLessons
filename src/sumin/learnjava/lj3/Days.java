package sumin.learnjava.lj3;

public class Days {
    public static void main(String[] args) {
        int days = 5000;
        int years = days / 365;
        int months = (days % 365) / 31;
        int leftDays = (days % 365) % 31;
        System.out.printf("Years - %d, months - %d and %d days.\n", years, months, leftDays);
    }
}
