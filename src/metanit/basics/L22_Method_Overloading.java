package metanit.basics;

/**
 * В программе мы можем использовать методы с одним и тем же именем, но с разными
 * типами и/или количеством параметров. Такой механизм называется перегрузкой
 * методов (method overloading).
 */
public class L22_Method_Overloading {
    public static void main(String[] args) {
        System.out.println(add(2.3, 5));
        System.out.println(add(5, 3, 2));
        System.out.println(add2(2.1, 3.4));
        System.out.println(add(2, 1));
        System.out.println(add(2.4, 4.4));
    }
    //Ниже все примеры перегруженного метода add.
    static int add(int a, int b) {
        return a + b;
    }
    static int add(double a, double b) {
        return (int)(a + b);
    }
    static double add(double a, int b) {
        return a + b;
    }
    static int add(int a, int b, int c) {
        return a + b + c;
    }
    //Пример метода который не является перегрузкой(различные только возвращаемые значения) и поэтому я ему дал другое название.
    static double add2(double a, double b) {
        return a + b;
    }
}
