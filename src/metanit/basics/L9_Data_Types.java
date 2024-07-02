package metanit.basics;

/**
 * Каждая переменная и константа представляет определенный тип и данный тип строго определен.
 * Тип данных определяет диапазон значений, которые может хранить переменная или константа.
 */
public class L9_Data_Types {
    public static void main(String[] args) {
        //Целые числа.
        byte a = 32;//Хранит целое число от -128 до 127 и занимает 1 байт.
        short b = -23;//Хранит целое число от -32768 до 32767 и занимает 2 байта.
        int c = 57575;//Хранит целое число от -2147483648 до 2147483647 и занимает 4 байта.
        long d = 999999999999999L;//Хранит целое число от –9 223 372 036 854 775 808 до 9 223 372 036 854 775 807 и занимает 8 байт.
        System.out.printf("byte = %d, short = %d, int = %d, long = %d\n", a, b, c, d);

        //Все целочисленные значения по умолчанию расцениваются как значения типа int.
        long e = 393939;//Здесь мы можем опустить L в конце, так как число укладывается в int. Если не укладывается, то в конце пишем L.

        //Ниже примеры присвоения значений целочисленным переменным в других системах счисления.
        int aa = 0b101;//В двоичной системе счисления.
        int aaa = 017;//В восьмеричной системе счисления.
        int aaaa = 0x2A33;//В шестнадцатеричной системе счисления.

        int a5 = 234_456;//Пример разделения разрядов знаком нижнего подчёркивания.
        System.out.printf("Long e = %d, aa = %d, aaa = %d, aaaa = %d, a5 = %d\n", e, aa, aaa, aaaa, a5);

        //Числа с плавающей точкой.
        float f = 23.4f;//Так как этот литерал автоматически рассматривается как double, то, чтобы указать, что он float добавляют f в конце.
        double ff = 78.0;//А здесь ничего не надо добавлять.

        //Логические значения.
        boolean bb = false;

        //Символьные и строковые значения.
        char ch = 'k';//Присваиваем один символ в одинарных кавычках.
        char ch1 = 3455;//Просто используем число в диапазоне от 0 до 65535.
        char ch2 = '\uA023';//Способ с использованием шестнадцатеричной системы счисления. Добавляем впереди обратный слэш и "u".
        System.out.printf("f = %f, ff = %.2f, bb = %b, ch = %c, ch1 = %c, ch2 = %c\n", f, ff, bb, ch, ch1, ch2);

        /*
         * Кроме собственно символов, которые представляют буквы, цифры, знаки препинания, прочие символы,
         * есть специальные наборы символов, которые называют управляющими последовательностями. Например,
         * самая популярная последовательность - "\n". Она выполняет перенос на следующую строку.
         */

        /*
        Вот несколько примеров управляющих последовательностей в Java:
        \n представляет символ новой строки.
        \t представляет символ табуляции.
        \" представляет символ двойной кавычки.
        \\ представляет символ обратной косой черты.
         */

        //Ниже примеры.
        String name = "Cat\tfrom \"Europa\"\nBora\\Hora";
        System.out.println(name);

        //А вот пример написания многострочного текста.
        String text = """
                Мой дядя
                Самых честных
                Правил
                """;
        System.out.println(text);
    }
}