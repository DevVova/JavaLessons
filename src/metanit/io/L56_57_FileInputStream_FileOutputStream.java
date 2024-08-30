package metanit.io;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * Поток (stream) в программировании — это абстракция для последовательной передачи данных.
 * Потоки позволяют работать с различными источниками данных, такими как файлы, сеть или даже
 * память, не заботясь о деталях низкоуровневого ввода/вывода. В контексте Java потоки обычно
 * используются для чтения или записи данных.
 * <p>
 * Объект, из которого можно считать данные, называется потоком ввода, а объект, в который
 * можно записывать данные, — потоком вывода.
 * <p>
 * Потоки ввода (Input Stream): Потоки ввода предназначены для чтения данных из источников (например,
 * файлов, сетевых соединений и т.д.). Они реализуют абстракцию последовательного получения данных.
 * <p>
 * Примеры классов потоков ввода:
 * </p>
 * InputStream (для чтения байтов)
 * FileInputStream (для чтения байтов из файлов)
 * BufferedInputStream (буферизованный поток для более эффективного чтения)
 * Reader (для чтения символов)
 * BufferedReader (буферизованный поток для чтения текста)
 * Потоки вывода (Output Stream): Потоки вывода позволяют записывать данные в различные места
 * назначения (например, файлы или сетевые соединения).
 * <p>
 * Примеры классов потоков вывода:
 * <p>
 * OutputStream (для записи байтов)
 * FileOutputStream (для записи байтов в файлы)
 * BufferedOutputStream (буферизованный поток для более эффективной записи)
 * Writer (для записи символов)
 * BufferedWriter (буферизованный поток для записи текста)
 * <p>
 * В основе всех классов, управляющих потоками байтов, находятся два абстрактных класса: InputStream
 * (представляющий потоки ввода) и OutputStream (представляющий потоки вывода).
 * <p>
 * Но поскольку работать с байтами не очень удобно, то для работы с потоками символов были добавлены
 * абстрактные классы Reader (для чтения потоков символов) и Writer (для записи потоков символов).
 */
public class L56_57_FileInputStream_FileOutputStream {
    public static void main(String[] args) {
        String text = "Good job! Wow!!!";
        /*
        Класс FileOutputStream предназначен для записи байтов в файл. Он является производным
        от класса OutputStream, поэтому наследует всю его функциональность.
        */
        //Ниже не try обычный, а try-with-resources.
        /*
        try-with-resources: В случае с try-with-resources внутри скобок ты создаёшь ресурс,
        такой как поток ввода/вывода, который автоматически закрывается, когда выполнение блока
        try завершено. Это не аргументы, а ресурсы, которые поддерживают интерфейс AutoCloseable
        (например, файловые потоки, сетевые соединения, базы данных и т.д.).
        Ресурсами в try-with-resources могут быть только объекты, реализующие интерфейс
        AutoCloseable или его более старую версию Closeable.
        Когда выполнение блока try заканчивается, вызовется метод close() для каждого ресурса, находящегося в скобках.
         */
        try (FileOutputStream fos = new FileOutputStream("textFile.txt")) {
            byte[] buffer = text.getBytes();//Переводим текст в байты.
            fos.write(buffer, 0, buffer.length);//записывает в выходной поток некоторое число байтов, равное length, из массива buffer, начиная со смещения offset, то есть с элемента buffer[offset].
            System.out.println("Файл записан.");
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

        /*
        Для считывания данных из файла предназначен класс FileInputStream, который является
        наследником класса InputStream и поэтому реализует все его методы.
         */
        try (FileInputStream fis = new FileInputStream("textFile.txt")) {
            int i;//Не обязательно писать i = 0, так как неинициализированный int равен 0.
            while ((i = fis.read()) != -1) {//Когда в потоке больше нет данных для чтения, метод fis.read() возвращает число -1.
                System.out.print((char) i);
            }
            System.out.println();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

//++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
        try (FileInputStream fis = new FileInputStream("textFile.txt");
        FileOutputStream fos = new FileOutputStream("newTextFile.txt")) {
            byte[] bufferNew = new byte[3];//данные из файла читаются порциями по 3 байта за один вызов метода read()
            int countNew;
            while ((countNew = fis.read(bufferNew)) != -1) {
                fos.write(bufferNew, 0, countNew);
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}