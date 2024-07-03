package metanit.basics;


/**
 * <p>
 *     Условные выражения - это языковая конструкция, содержащая либо операторы сравнения, либо операторы
 * логические, объединяющие несколько операций сравнения.
 * </p>
 */
public class L13_Conditional_Expressions {
    public static void main(String[] args) {
        //Операции сравнения
        int a = 2;
        int b = 8;
        boolean c = a > b;
        System.out.println(c);
        c = a < b;
        System.out.println(c);
        c = a == b;
        System.out.println(c);
        c = a != b;
        System.out.println(c);
        c = a >= b;
        System.out.println(c);
        c = a <= b;
        System.out.println(c);
        System.out.println();

        //Логические операции
        c = (a < b) && ((a != b) || (a >= b));//Без комментариев, я буду стараться использовать только их, остальные нахуй не нужны.
        System.out.println(c);
    }
}
