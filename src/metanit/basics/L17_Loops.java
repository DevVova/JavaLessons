package metanit.basics;

/**
 * Еще одним видом управляющих конструкций являются циклы. Циклы позволяют в зависимости
 * от определенных условий выполнять определенное действие множество раз.
 */
public class L17_Loops {
    public static void main(String[] args) {

        //Цикл for.
        for (int i = 0, y = 5; i < y; i++) {//Здесь определены сразу несколько переменных.
            System.out.println(i);
        }

        //Цикл while.
        int i = 8;
        while (i > 3) {
            --i;
            System.out.printf("%d\t", i);
        }
        System.out.println();

        //Цикл do while. Здесь сначала выполняется действие, а потом проверяется условие. Действие гарантированно произойдёт хотя бы один раз.
        i = 8;
        do {
            System.out.printf("%d\t", i);
            i--;
        }
        while (i > 3);
        System.out.println();

        //Операторы continue и break.
        //Оператор break позволяет выйти из цикла в любой его момент, даже если цикл не закончил свою работу.
        i = 9;
        while (i > 0) {
            if (i == 4) break;
            System.out.printf("%d\t", i);
            i--;
        }
        System.out.println();
        //Оператор continue осуществляет переход на другую итерацию цикла.
        i = 9;
        while (i > 0) {
            if (i == 4) {
                i--;
                continue;
            }
            System.out.printf("%d\t", i);
            i--;
        }
    }
}