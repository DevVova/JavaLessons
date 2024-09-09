package metanit.io;

import java.io.*;

public class L64_BufferedReader_BufferedWriter {
    public static void main(String[] args) {
        String newText = """
                Мой дядя
                самых честных
                правил
                когда не в шутку 
                занемог""";
        //Класс BufferedWriter записывает текст в поток, предварительно буферизируя записываемые символы,
        //тем самым снижая количество обращений к физическому носителю для записи данных.
        try (BufferedWriter bw = new BufferedWriter(new FileWriter("textFile.txt"))) {
            bw.write(newText);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

        //Класс BufferedReader считывает текст из символьного потока ввода, буферизируя прочитанные символы.
        //Использование буфера призвано увеличить производительность чтения данных из потока.
        //Ниже пример считывания текста построчно.
        try (BufferedReader br = new BufferedReader(new FileReader("textFile.txt"))) {
            String s;
            while ((s = br.readLine()) != null) {
                System.out.println(s);
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

        //А теперь сочетание записи текста введённого в консоли в файл. Только здесь придётся реально писать "ESC", а не просто нажать на клавишу.
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new FileWriter("newTextFile.txt"))) {
            System.out.print("Введите текст, а для выхода из программы затем нажмите Esc: ");
            String textInput;
            while (true) {
                textInput = reader.readLine();
                if (textInput.equals("ESC")) break;
                writer.write(textInput);
                writer.write(System.lineSeparator());
                writer.flush();
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}