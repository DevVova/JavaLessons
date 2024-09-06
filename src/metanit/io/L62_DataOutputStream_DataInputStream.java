package metanit.io;

import java.io.*;

/**
 * Классы DataOutputStream и DataInputStream позволяют записывать и считывать данные примитивных типов.
 */
public class L62_DataOutputStream_DataInputStream {
    public static void main(String[] args) {
        Humanoid sam = new Humanoid(56, "Sam", true);
        //Запишем в поток данные примитивных типов.
        try (DataOutputStream dos2 = new DataOutputStream(new FileOutputStream("data.bin"))) {
            dos2.writeInt(sam.age());
            dos2.writeUTF(sam.name());
            dos2.writeBoolean(sam.married());
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

        //Считаем из потока данные примитивных типов.
        try (DataInputStream dis2 = new DataInputStream(new FileInputStream("data.bin"))) {
            int age = dis2.readInt();
            String name = dis2.readUTF();
            boolean married = dis2.readBoolean();
            System.out.printf("His name is %s. He's %d years old. His married is %b.\n", name, age, married);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}

record Humanoid(int age, String name, boolean married) {
}