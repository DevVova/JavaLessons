package metanit.basics;

/**
 * Массив представляет набор однотипных значений. Объявление массива похоже на объявление
 * обычной переменной, которая хранит одиночное значение.
 * Все элементы массива имеют значение по умолчанию. Для числовых типов (в том числе для типа char)
 * это число 0, для типа boolean это значение false, а для остальных объектов это значение null.
 */
public class L18_Arrays {
    public static void main(String[] args) {
        int k = 9;
        double[] arr = new double[k];
        System.out.printf("Второй элемент массива равен %.1f\n", arr[1]);
        arr[1] = 23.3;
        System.out.printf("Второй элемент массива равен %.1f\n", arr[1]);
        int i = 0;
        double num = 1.1;
        do {
            arr[i] = num;
            System.out.printf("%.1f  \t", arr[i]);
            i++;
            num += 0.4;
        } while (i < k);
        System.out.println();

        int[] num2 = new int[]{23, 2, 11, 4};
        for (int ii = 0; ii < num2.length; ii++) {
            if (num2[ii] == 2) {
                System.out.print("Число равное 2    ");
                continue;
            }
            System.out.printf("%d \t", num2[ii]);
        }
        System.out.println();

        //Двухмерный массив.
        int[][] arr2 = new int[2][3];//Здесь мы создали двухмерный массив, в котором 2 строки и 3 столбца.
        int[][] arr3 = {{1, 2, 3}, {4, 5, 6}};//Можно вот так создать.
        int[][] arr4 = new int[2][3];//Здесь мы создали трёхмерный массив.
        //Ниже пример перебора многомерного массива.
        for (int j = 0; j < arr3.length; j++) {
            for (int jj = 0; jj < arr3[j].length; jj++) {
                System.out.printf("%d  \t", arr3[j][jj]);
            }
            System.out.println();
        }

        //Зубчатый массив.
        int[][] arr5 = new int[3][];
        arr5[0] = new int[2];//В первой строке будет 2 столбца.
        arr5[1] = new int[1];//Во второй строке будет 1 столбец.
        arr5[2] = new int[5];//В третьей строке будет 5 столбцов.
        int v = 7;
        for (int f = 0; f < arr5.length; f++) {
            for (int ff = 0; ff < arr5[f].length; ff++) {
                v *= 4;
                arr5[f][ff] = v;
                System.out.printf("%d \t", arr5[f][ff]);
            }
            System.out.println();
        }

        //forEach.
        /*
        Специальная версия цикла for предназначена для перебора элементов в наборах
        элементов, например, в массивах и коллекциях. Она аналогична действию цикла
        foreach, который имеется в других языках программирования.
        */
        for (double z : arr) {
            System.out.printf("%f \t", z);//Но простое for гибче. Поэтому эту хрень можно особо и не использовать.
        }
    }
}