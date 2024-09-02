package metanit.practice;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileInputOutputStream {
    public static void main(String[] args) {
        //Вот для начала пример того как на рабочем столе создать текстовый файл и в него записать текст, это пример с простым try.
        FileOutputStream fos = null;
        String text = "All are stupid.";
        try {
            fos = new FileOutputStream("C:\\Users\\zabot\\OneDrive\\Рабочий стол\\MyNotes.txt");
            byte[] arr = text.getBytes();
            fos.write(arr, 0, arr.length);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        } finally {
            try {
                if (fos != null) {
                    fos.close();
                }
            } catch (IOException ee) {
                System.out.println(ee.getMessage());
            }
        }
        //А теперь пример с try with resources. Также мы не полностью переписываем файл, а дописываем добавляя true - new FileOutputStream("C:\\Users\\zabot\\OneDrive\\Рабочий стол\\MyNotes.txt", true)
        text = "\nI'm not stupid.\nThey are stupid.";//Используем для новой строки управляющую последовательность \n.
        try (FileOutputStream fos2 = new FileOutputStream("C:\\Users\\zabot\\OneDrive\\Рабочий стол\\MyNotes.txt", true)) {
            byte[] arr = text.getBytes();
            fos2.write(arr, 0, arr.length);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

        //Теперь начнём считывать текст из файла, а также записывать в новую строковую переменную.
        StringBuilder sb = new StringBuilder();
        try (FileInputStream fis = new FileInputStream("C:\\Users\\zabot\\OneDrive\\Рабочий стол\\MyNotes.txt")) {
            int i;
            while ((i = fis.read()) != -1) {
                System.out.print((char)i);
                sb.append((char)i);
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        System.out.println("\n");
        System.out.println(sb);
    }
}
