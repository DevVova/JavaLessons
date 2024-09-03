package metanit.io;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * Для работы с массивами байтов - их чтения и записи используются классы ByteArrayInputStream и ByteArrayOutputStream.
 * Класс ByteArrayInputStream представляет входной поток, использующий в качестве источника данных массив байтов.
 * Класс ByteArrayOutputStream представляет поток вывода, использующий массив байтов в качестве места вывода.
 */
public class L59_ByteArrayInputStream_ByteArrayOutputStream {
    public static void main(String[] args) {
        //Для закрытия объектов этих классов потоков, не требуется вызывать метод close(), а для работы с ByteArrayInputStream не нужен вообще блок try...catch.
        String text2 = "Fuck!";//На русском не работает.
        byte[] arr2 = text2.getBytes();
        ByteArrayInputStream bais = new ByteArrayInputStream(arr2);
        int i;
        while ((i = bais.read()) != -1) {
            System.out.print((char) i);
        }
        System.out.println();

        //Ниже запишем вначале данные в объект ByteArrayOutputStream, а затем из него в объект FileOutputStream.
        text2 = "Fuck they!";
        arr2 = text2.getBytes();
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        try {
            baos.write(arr2);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        try (FileOutputStream fos2 = new FileOutputStream("newTextFile.txt")) {
            baos.writeTo(fos2);
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }

        //Также можем превратить массив байт в строку.
        System.out.println(baos);
        //А можем вывести посимвольно.
        byte[] newArr = baos.toByteArray();
        for (byte c : newArr) {
            System.out.print((char) c);
        }
        System.out.println();
    }
}
