package metanit.io;

import java.io.*;

public class L60_BufferedInputStream_BufferedOutputStream {
    public static void main(String[] args) {
        String lastText = "I'm Vova.";
        try (BufferedInputStream bis = new BufferedInputStream(new ByteArrayInputStream(lastText.getBytes()))) {
            int i;
            while ((i = bis.read()) != -1) {
                System.out.print((char) i);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        System.out.println();
        //Но можно и из файла получить текст.
        try (BufferedInputStream bis = new BufferedInputStream(new FileInputStream("textFile.txt"))) {
            int i;
            while ((i = bis.read()) != -1) {
                System.out.print((char) i);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        //BufferedOutputStream.
        byte[] bArr = lastText.getBytes();
        try (FileOutputStream out = new FileOutputStream("newTextFile.txt");
             BufferedOutputStream bos = new BufferedOutputStream(out)) {
            bos.write(bArr, 0, bArr.length);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
