package metanit.basics;

/**
 * Главное отличие рекурсивных функций от обычных методов состоит в том, что
 * рекурсивная функция может вызывать саму себя.
 */
public class L23_Recursion {
    public static void main(String[] args) {
        System.out.println(factorialLoop(3));
        System.out.println(factorialRecursion(5));
        System.out.println(numberOfFibonacci(7));
    }
    //Ниже сначала идёт метод для нахождения факториала с использованием цикла, а после уже с использованием рекурсии.
    static int factorialLoop(int x) {
        int res = 1;
        for (int i = 2; i <= x; i++) {
            res *= i;
        }
        return res;
    }
    static int factorialRecursion(int x) {
        //Вначале идёт базовая форма.
        if (x == 1) return 1;
        return x * factorialRecursion(x - 1);
    }

    //Ну а это метод для нахождения числа Фибоначчи.
    static int numberOfFibonacci(int n) {
        if (n == 0) return 0;
        if (n == 1) return 1;
        return numberOfFibonacci(n - 1) + numberOfFibonacci(n - 2);
    }
}
