package metanit.basics;

/**
 * Некоторые виды преобразований выполняются неявно, автоматически.
 * Автоматически без каких-либо проблем производятся расширяющие
 * преобразования (widening) - они расширяют представление объекта в памяти.
 * Расширяющие автоматические преобразования представлены следующими цепочками:
 * byte -> short -> int -> long
 * int -> double
 * short -> float -> double
 * char -> int
 * Некоторые преобразования могут производиться автоматически между типами данных
 * одинаковой разрядности или даже от типа данных с большей разрядностью к типам
 * с меньшей разрядностью. Это следующие цепочки преобразований: int -> float,
 * long -> float и long -> double. Они производятся без ошибок, но при
 * преобразовании мы можем столкнуться с потерей информации.
 * Нередки ситуации, когда приходится применять различные операции, например, сложение и произведение, над значениями разных типов. Здесь также действуют некоторые правила:
 * - если один из операндов операции относится к типу double, то и второй операнд преобразуется к типу double
 * - если предыдущее условие не соблюдено, а один из операндов операции относится к типу float, то и второй операнд преобразуется к типу float
 * - если предыдущие условия не соблюдены, один из операндов операции относится к типу long, то и второй операнд преобразуется к типу long
 * - иначе все операнды операции преобразуются к типу int
 */
public class L15_Transformations_Of_Basic_Data_Types {
    public static void main(String[] args) {
        int a = 45;
        short b = -478;
        byte c = -1;
        a = c;//Это пример неявного преобразования, так можно, так как диапазон byte входит в диапазон int.
        System.out.println(a);
        c = (byte) a;//Это пример явного преобразования.
        System.out.println(c);
        c = (byte) b;//А вот здесь будет потеряна точность, а если быть более точным то усечение значения.
        System.out.println(c);
        double d = 23.3;
        c = (byte) d;//А здесь будет усечение дробной части.
        System.out.println(c);

        //Преобразования при операциях
        int aa = 5;
        float bb = 3.2f;
        double dd = aa + bb;//Здесь операнд aa преобразуется в float и сама сумма неявно преобразуется в double.
        System.out.println(dd);

        byte f = 7;
        short ff = 3;
        byte cc = (byte) (f + ff);//Две переменных типа byte и short (не double, float или long), поэтому при сложении они преобразуются к типу int, и их сумма f+ff представляет значение типа int. Поэтому если затем мы присваиваем эту сумму переменной типа byte, то нам опять надо сделать преобразование типов к byte.
        System.out.println(cc);

        int k = 'l' + 34;//Здесь операнд char преобразуется в int.
        System.out.println(k);

        //Вывод: нужно стараться при работе с данными и переменными следить чтобы они были одного типа по возможности.
    }
}
