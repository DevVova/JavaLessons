package metanit.basics;


/**
 * <p>
 *     Операция - это определённое действие над операндами. Есть унарные операции (выполняются над одним операндом),
 * бинарные - над двумя операндами, а также тернарные - выполняются над тремя операндами. Операндом является
 * переменная или значение (например, число), участвующее в операции.
 * </p>
 * <p>
 *     Арифметические операции - это операции над числами.
 * </p>
 */
public class L11_Arithmetic_Operations {
    public static void main(String[] args) {
        int a = 97;
        short b = 23;
        int c = a + b;//Можно складывать разные типы, так как short включается в int.
        System.out.println(c);
        c = a - b;
        System.out.println(c);
        c = a * b;
        System.out.println(c);
        c = a / b;//Результатом будет целое число.
        System.out.println(c);
        float cc = a / 2.3f;//Одно из чисел должно быть десятичным и с f на конце.
        System.out.println(cc);
        c = a % b;
        System.out.println(c);//Здесь результатом будет остаток от деления.
        System.out.println();

        //++ (префиксный инкремент)
        a = 3;
        int d = ++a;
        System.out.println(a);
        System.out.println(d);
        System.out.println();

        //++ (постфиксный инкремент)
        a = 3;
        d = a++;
        System.out.println(a);
        System.out.println(d);
        System.out.println();

        //-- (префиксный декремент)
        a = 3;
        d = --a;
        System.out.println(a);
        System.out.println(d);
        System.out.println();

        //-- (постфиксный декремент)
        a = 3;
        d = a--;
        System.out.println(a);
        System.out.println(d);
        System.out.println();

        //Приоритет операций я рассматривать не буду, так как считаю целесообразным использовать скобки.
        //Также следует быть внимательным при работе с числами, когда требуется большая точность, то лучше использовать специальные классы.
        //К примеру для работы с десятичными числами лучше использовать BigDecimal.
    }
}
