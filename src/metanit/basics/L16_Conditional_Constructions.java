package metanit.basics;


import java.util.Scanner;

/**
 * Одним из фундаментальных элементов многих языков программирования являются условные конструкции.
 * Данные конструкции позволяют направить работу программы по одному из путей в зависимости от
 * определенных условий.
 * В языке Java используются следующие условные конструкции: if..else и switch..case
 */
public class L16_Conditional_Constructions {
    public static void main(String[] args) {
        //Условная конструкция if ... else
        System.out.print("Input number: ");
        Scanner in = new Scanner(System.in);
        int num = in.nextInt();
        int num2 = 11;
        byte num3 = 77;
        if (num == num2 || num == num3) System.out.println("Всё равно.");
        else if (num > num2) System.out.println("num > num2");
        else {
            System.out.println("Не то  и не другое");
        }

        //Условная конструкция switch ... case до java 17. Эта конструкция не поддерживает boolean.
        switch (num) {
            case 1:
                System.out.println("num = 1");
                break;
            //Ниже пример обработки сразу нескольких кейсов.
            case 10:
            case 11:
            case 9:
                num++;
                System.out.printf("num было равно 11, а стало %d\n", num);
                break;
            default://Этот блок не обязателен.
                System.out.println("Don't now.");
                break;
        }

        //Условная конструкция switch ... case c java 17. Эта конструкция не поддерживает boolean.
        switch (num) {
            case 12 -> System.out.println("num = 12");
            case 2 -> System.out.println("num = 2");
            default -> System.out.println("num = more");
        }
        in.close();

        //Тернарная операция.

        /*
        Тернарная операция имеет следующий синтаксис:
        [первый операнд - условие] ? [второй операнд] : [третий операнд].
        Таким образом, в этой операции участвуют сразу три операнда.
        В зависимости от условия тернарная операция возвращает второй или
        третий операнд: если условие равно true, то возвращается второй
        операнд; если условие равно false, то третий.
        */
        int nn = num >= num2 ? 0 : num;
        System.out.println(nn);
    }
}
