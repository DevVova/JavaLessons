package basics;

public class L7_VariablesAndConstants {
    public static void main(String[] args) {
        int a;//Объявление переменной.
        a = 34;//Присвоение переменной значения.
        int b = 99;//Объявление переменной и её инициализация.
        System.out.println("Два числа " + a + " и " + b);
        int c,d;//Объявление сразу двух переменных.
        c = 6; d =0;
        System.out.println(c + d);
        int e = 8, f = 88;//А можно и так сразу инициализируя два числа.
        System.out.println(e + f);
        a = 121;//Значение переменных можно менять.
        System.out.println(a);

        var ee = 9;//Var ставится вместо типа данных, который выводится из значения, но при этом нужно сразу инициализировать.
        System.out.println(ee);

        final float PI = 3.14f;//Так объявляются константы, значение которых никогда больше не изменяется.
        System.out.println(a * PI);
    }
}
