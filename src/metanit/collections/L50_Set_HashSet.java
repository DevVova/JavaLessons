package metanit.collections;

import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;

/**
 * Интерфейс Set расширяет интерфейс Collection и представляет набор уникальных элементов.
 * Set не добавляет новых методов, только вносит изменения в унаследованные. В частности,
 * метод add() добавляет элемент в коллекцию и возвращает true, если в коллекции еще нет такого элемента.
 * <p>
 * Основные характеристики HashSet:
 * Уникальность элементов: Каждый элемент в HashSet уникален.
 * Нет гарантии порядка: HashSet не поддерживает порядок элементов, т.е. порядок их вставки и вывода может отличаться.
 * Быстродействие: Благодаря использованию хэш-таблиц операции вставки, удаления и поиска элементов происходят
 * за среднее время O(1).
 * Null элементы: HashSet допускает один элемент со значением null.
 */
public class L50_Set_HashSet {
    public static void main(String[] args) {
        HashSet<Integer> setNum = new HashSet<>(Arrays.asList(23, 23, 3, 55));//23 добавиться 1 раз, так как в коллекции все элементы уникальны.

        //HashSet не поддерживает порядок элементов, поэтому, чтобы пройтись по всем элементам коллекции, нужно использовать итератор.
        Iterator<Integer> iterator = setNum.iterator();
        while (iterator.hasNext()) {
            System.out.print(iterator.next() + " ");
        }
        System.out.println();

        //Преобразование множества в массив.
        Object[] arr = setNum.toArray();
        for (Object i : arr) {
            System.out.print(i + " ");
        }
        System.out.println();
        //или
        forEachMy(Arrays.stream(arr).toList());

        //Добавляет элемент в множество, если его ещё нет.
        setNum.add(55);

        //Добавляет все элементы указанной коллекции.
        setNum.addAll(Arrays.asList(2, 33, 11));

        //Проверяет, содержится ли указанный элемент в множестве.
        System.out.println(setNum.contains(17));

        //Проверяет, пустое ли множество.
        System.out.println(setNum.isEmpty());

        //Удаляет указанный элемент из множества, если он присутствует.
        setNum.remove(18);

        for (int i : setNum) {
            System.out.print(i + " ");
        }
        System.out.println();

        //Удаляет все элементы множества, которые присутствуют в указанной коллекции.
        setNum.removeAll(Arrays.asList(55, 2));
        forEachMy(setNum);
        System.out.println();

        //Оставляет в множестве только те элементы, которые присутствуют в указанной коллекции.
        setNum.retainAll(Arrays.asList(3, 33));
        forEachMy(setNum);

        //Проверит и если множество не пустое, то удалит все его элементы.
        if (!setNum.isEmpty()) {
            setNum.clear();
            forEachMy(setNum);
        }
        System.out.println(setNum.isEmpty());
    }
    //Ниже записал метод прохода по коллекции.
    public static <E> void forEachMy(Collection <? extends E> col) {
        for (E element : col) {
            System.out.print(element + " ");
        }
        System.out.println();
    }
}