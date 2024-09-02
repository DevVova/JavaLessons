package metanit.io;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * При завершении работы с потоком его надо закрыть с помощью метода close(), который определен в интерфейсе Closeable.
 * Этот интерфейс уже реализуется в классах InputStream и OutputStream, а через них и во всех классах потоков.
 * При закрытии потока освобождаются все выделенные для него ресурсы, например, файл. В случае, если поток окажется не
 * закрыт, может происходить утечка памяти.
 */
public class L58_Closeable {
    public static void main(String[] arr) {
        //Для начала пример с простым блоком try.
        FileInputStream fis5 = null;
        try {
            fis5 = new FileInputStream("textFile.txt");

            int i = -1;
            while ((i = fis5.read()) != -1) {
                System.out.print((char) i);
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        } finally {
            try {
                if (fis5 != null) {
                    fis5.close();
                }
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
        }

        //А теперь пример в котором не нужно использовать метод close() для объектов, используя конструкцию try with resources.
        StringBuilder sb = new StringBuilder();
        try (FileInputStream fis6 = new FileInputStream("newTextFile.txt")) {
            int i;
            while ((i = fis6.read()) != -1) {
                sb.append((char) i);
            }
            System.out.println("\n" + sb);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

        //А теперь совсем заморочимся и используем в try with resources несколько параметров. Мы считаем из одного файла текст и добавим в конец текста другого файла.
        sb = new StringBuilder();
        try (FileInputStream fis11 = new FileInputStream("textFile.txt");
             FileOutputStream fos11 = new FileOutputStream("newTextFile.txt", true)) {
            int i;
            while ((i = fis11.read()) != -1) {
                sb.append((char) i);
            }
            String newText = "\nNew text\n" + sb;
            byte[] arr11 = newText.getBytes();
            fos11.write(arr11, 0, arr11.length);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
