package metanit.basics;

public class L14_Assignment_Operations {
    public static void main(String[] args) {
        int a = 63;
        int b = 4;
        b += a;
        System.out.printf("a = %d, b = %d\n", a, b);
        a -= b;
        System.out.printf("a = %d, b = %d\n", a, b);
        b /= a;
        System.out.printf("a = %d, b = %d\n", a, b);
        a %= b;
        System.out.printf("a = %d, b = %d\n", a, b);
        b *= a;
        System.out.printf("a = %d, b = %d\n", a, b);
    }
}
