package metanit.io;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class L63_FileWriter_FileReader {
    public static void main(String[] args) {
        String thisText = "Text for FileWriter and FileReader.";
        //Класс FileWriter является производным от класса Writer. Он используется для записи текстовых файлов.
        try (FileWriter fw = new FileWriter("textFile.txt")) {
            fw.write(thisText);
            fw.append("\t");
            fw.append('E');
            fw.append('N');
            fw.append('D');
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

        //Класс FileReader наследуется от абстрактного класса Reader и предоставляет функциональность для чтения текстовых файлов.
        try (FileReader fr = new FileReader("textFile.txt")) {
            int i;
            while ((i = fr.read()) != -1) {
                System.out.print((char) i);
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        System.out.println();
    }
}
