package metanit.io;

import java.io.*;
import java.util.ArrayList;

/**
 * Сериализация представляет процесс записи состояния объекта в поток, соответственно процесс извлечения
 * или восстановления состояния объекта из потока называется десериализацией. Сериализация очень удобна,
 * когда идет работа со сложными объектами.
 * Сразу надо сказать, что сериализовать можно только те объекты, которые реализуют интерфейс Serializable.
 * Этот интерфейс не определяет никаких методов, просто он служит указателем системе, что объект, реализующий
 * его, может быть сериализован.
 */
public class L65_ObjectOutputStream_ObjectInputStream {
    public static void main(String[] args) {
        String file = "objectData.dat";
        //Сначала запишем данные об объекте.
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file))) {
            Human9 sam = new Human9(27, "Sam");
            oos.writeObject(sam);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        //А затем получим данные об объекте.
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file))) {
            Human9 human = (Human9) ois.readObject();
            System.out.printf("He is %s. He's %d years old.\n\n", human.name, human.age);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        //Ну и наконец поработаем со списком людей.
        ArrayList<Human9> people9 = new ArrayList<>();
        people9.add(new Human9(29, "Kolya"));
        people9.add(new Human9(22, "Vasya"));
        try (ObjectOutputStream oos2 = new ObjectOutputStream(new FileOutputStream(file))) {
            oos2.writeObject(people9);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        // десериализация в новый список.
        ArrayList<Human9> newPeople = new ArrayList<>();
        try (ObjectInputStream ois2 = new ObjectInputStream(new FileInputStream(file))) {
            newPeople = (ArrayList<Human9>) ois2.readObject();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        for (Human9 h : newPeople) {
            /*
            Поля, помеченные как transient, не сериализуются, то есть их значения не сохраняются
            при сериализации объекта. Когда объект десериализуется, для таких полей присваиваются
            их значения по умолчанию, и для типа boolean это значение равно false.
             */
            System.out.printf("He's %s. He's %d years old. He is married %b.\n", h.name, h.age, h.married);
        }
    }
}

//Чтобы можно было работать с объектом, ему нужно имплементировать Serializable.
class Human9 implements Serializable {
    int age;
    String name;
    transient boolean married = true;//Чтобы поле было исключено из сериализации. После десериализации будет false.

    Human9(int age, String name) {
        this.age = age;
        this.name = name;
    }

    void info() {
        System.out.printf("His name is %s. He's %d years old.", name, age);
    }
}