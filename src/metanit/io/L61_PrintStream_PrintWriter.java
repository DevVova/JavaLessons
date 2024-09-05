package metanit.io;

import java.io.*;
import java.util.Arrays;

/**
 * Класс PrintStream - это именно тот класс, который используется для вывода на консоль.
 * Когда мы выводим на консоль некоторую информацию с помощью вызова System.out.println(),
 * то тем самым мы задействуем PrintStream, так как переменная out в классе System как раз
 * и представляет объект класса PrintStream, а метод println() - это метод класса PrintStream.
 * Но PrintStream полезен не только для вывода на консоль. Мы можем использовать
 * данный класс для записи информации в поток вывода.
 * <p>
 * Основное различие между PrintStream и PrintWriter заключается в том, как они работают с
 * символами и байтами, а также в их поведении при работе с ошибками.
 * Поток вывода:
 * PrintStream работает с байтовыми потоками (OutputStream).
 * PrintWriter работает с символьными потоками (Writer).
 * Автоматическое управление ошибками:
 * PrintStream подавляет все ошибки ввода-вывода, и для проверки на ошибки нужно явно вызывать метод checkError().
 * PrintWriter аналогично подавляет ошибки, но в основном используется для работы с символами, как и другие классы
 * в пакете java.io.Writer.
 * Работа с кодировками:
 * PrintStream не поддерживает работу с различными кодировками при использовании конструктора на базе OutputStream.
 * PrintWriter может работать с различными кодировками, если его конструктор принимает экземпляр OutputStreamWriter
 * или если используется соответствующий конструктор.
 * </p>
 */
public class L61_PrintStream_PrintWriter {
    public static void main(String[] args) {
        String myText = "Good job! Let's run every day.";
        try (FileOutputStream fos8 = new FileOutputStream("textFile.txt", true);
             PrintStream printStream = new PrintStream(fos8)) {
            printStream.println(myText);
            printStream.printf("This is %s \n", myText);
            printStream.write(myText.getBytes(), 0, myText.getBytes().length);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

        try (ByteArrayOutputStream bb = new ByteArrayOutputStream();
             PrintWriter printWriter = new PrintWriter(bb);
             PrintWriter pw = new PrintWriter(System.out);
             FileOutputStream fos9 = new FileOutputStream("newTextFile.txt");
             PrintWriter pw2 = new PrintWriter(fos9)) {
            printWriter.write(myText);
            pw.println(myText);
            pw2.write(myText);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}