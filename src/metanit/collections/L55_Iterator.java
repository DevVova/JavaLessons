package metanit.collections;

import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.ListIterator;

/**
 * Одним из ключевых методов интерфейса Collection является метод Iterator<E> iterator().
 * Он возвращает итератор - то есть объект, реализующий интерфейс Iterator.
 * <p>
 * Реализация интерфейса предполагает, что с помощью вызова метода next() можно получить
 * следующий элемент. С помощью метода hasNext() можно узнать, есть ли следующий элемент,
 * и не достигнут ли конец коллекции. И если элементы еще имеются, то hasNext() вернет
 * значение true. Метод hasNext() следует вызывать перед методом next(), так как при
 * достижении конца коллекции метод next() выбрасывает исключение NoSuchElementException.
 * И метод remove() удаляет текущий элемент, который был получен последним вызовом next().
 * </p>
 * Интерфейс Iterator предоставляет ограниченный функционал. Гораздо больший набор методов
 * предоставляет другой итератор - интерфейс ListIterator. Данный итератор используется классами,
 * реализующими интерфейс List, то есть классами LinkedList, ArrayList и др.
 */
public class L55_Iterator {
    public static void main(String[] args) {
        LinkedList<Integer> numbersInt = new LinkedList<>(Arrays.asList(2, 88, 9, 49, 33));
        Iterator<Integer> iterator = numbersInt.iterator();

        while (iterator.hasNext()) {
            System.out.print(iterator.next() + " ");
        }
        System.out.println();
        System.out.println(numbersInt);

        //А вот к примеру если я захочу узнать если в таком списке элемент со значением 49, и если есть, то вывести его индекс.
        int index = numbersInt.indexOf(49);
        System.out.println(index);//Если бы вывело -1, значит такого элемента с этим значением нет.


        //Ниже пример как удалять определённый элемент со значением.
        //Сначала нужно создать новый итератор, потому что предыдущий свою задачу выполнил и он уже в конце списка.
        iterator = numbersInt.iterator();

        while (iterator.hasNext()) {
            int n = iterator.next();
            if (n == 9) iterator.remove();
        }

        //Снова нужно создать новый итератор, потому что предыдущий свою задачу выполнил и он уже в конце списка.
        iterator = numbersInt.iterator();
        while (iterator.hasNext()) {
            System.out.print(iterator.next() + " ");
        }
        System.out.println();


        //Пример с ListIterator.
        ListIterator<Integer> listIterator = numbersInt.listIterator();
        while (listIterator.hasNext()) {
            if (listIterator.next() == 88) listIterator.set(99);//Поменяли значение элемента.
        }
        listIterator = numbersInt.listIterator();
        while (listIterator.hasNext()) {
            System.out.print(listIterator.next() + " ");
            //int nextIndex(): возвращает индекс следующего элемента. Если такого нет, то возвращается размер списка
            System.out.print(" - " + listIterator.nextIndex() + "  ;");
            //void add(E obj): вставляет объект obj перед элементом, который должен быть возвращен следующим вызовом next().
            listIterator.add(77);
        }
        System.out.println();
        //А теперь пройдёмся по элементам в обратном порядке.
        while (listIterator.hasPrevious()) {
            System.out.print(listIterator.previous() + "  ");// И не надо снова пересоздавать listIterator.
            //int nextIndex(): возвращает индекс следующего элемента. Если такого нет, то возвращается размер списка
            System.out.print(listIterator.nextIndex() + "  ;");
        }
        System.out.println();
    }
}