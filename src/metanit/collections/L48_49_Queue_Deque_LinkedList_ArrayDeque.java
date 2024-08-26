package metanit.collections;

import java.util.*;

/**
 * Queue (Очередь):
 * Принцип: Queue следует принципу FIFO (First In, First Out), что означает, что первый элемент, добавленный
 * в очередь, будет первым извлечённым.
 * Операции:
 * add(e) или offer(e): Добавляет элемент в конец очереди
 * remove() или poll(): Извлекает и удаляет первый элемент из очереди
 * peek(): Возвращает первый элемент без его удаления.
 * Пример реализации: LinkedList, PriorityQueue.
 * <p>
 * Deque (Двухсторонняя очередь):
 * Принцип: Deque означает Double Ended Queue, то есть двухсторонняя очередь, которая позволяет добавлять и удалять элементы с обеих сторон (и с начала, и с конца).
 * Операции:
 * Добавление: addFirst(e) (в начало), addLast(e) (в конец).
 * Удаление: removeFirst() (из начала), removeLast() (из конца).
 * Просмотр: peekFirst() (первый элемент), peekLast() (последний элемент).
 * Пример реализации: ArrayDeque, LinkedList.
 */
public class L48_49_Queue_Deque_LinkedList_ArrayDeque {
    public static void main(String[] args) {
        //Queue.
        ArrayList<Integer> numbers2 = new ArrayList<>(Arrays.asList(23, 12, 99));//Вот так можно сразу несколько элементов добавить в список.
        System.out.println(numbers2.getLast());
        Queue<Integer> numQueue = new LinkedList<>(numbers2);
        System.out.println(numQueue.size());//Было 3.
        System.out.println(numQueue.poll());//Извлёк первый элемент из очереди и удалил.
        System.out.println(numQueue.size());//А теперь уже 2.
        System.out.println(numQueue.peek());//Возвращает первый элемент без его удаления.
        numQueue.addAll(Arrays.asList(11, 9, 4));//Вот так можно ещё сразу несколько элементов добавлять в список.
        System.out.println(numQueue.size());//А теперь уже 5.
        Queue<String> names = new PriorityQueue<>(Arrays.asList("Sam", "Ted"));
        System.out.println(names.element());
        System.out.println(names.element());//Это как и peek(), только генерирует исключение если очередь пуста.

        //Deque.
        /*
        Класс ArrayDeque<E>. Этот класс представляют обобщенную двунаправленную очередь,
        наследуя функционал от класса AbstractCollection и применяя интерфейс Deque.
         */
        Deque<Integer> numDeque = new ArrayDeque<>(Arrays.asList(34, 2, 2));
        System.out.println(numDeque.peekFirst());//Возвращает первый элемент без его удаления. Этого нет у интерфейса Queue.
        numDeque.addFirst(19);//Добавили в начало списка элемент.
        /*
        Обобщенный класс LinkedList<E> представляет структуру данных в виде связанного списка.
        Он наследуется от класса AbstractSequentialList и реализует интерфейсы List, Deque и Queue.
        То есть он соединяет функциональность работы со списком и функциональность очереди.
         */
        Deque<String> namesDeque = new LinkedList<>(Arrays.asList("Helen", "Em", "Ted"));
        System.out.println(namesDeque.size());
        System.out.println(namesDeque.pollLast());
        System.out.println(namesDeque.size());
        for (String s : namesDeque) {
            System.out.print(s + " ");
        }
        System.out.println();
        namesDeque.addAll(new ArrayDeque<>(Arrays.asList("Pol", "Coin", "Vova")));//В LinkedList вложил ArrayDeque.
        System.out.println(namesDeque.size());

        //Ниже пример где мы извлекаем последний элемент списка в цикле, пока последний элемент ещё есть.
        while (namesDeque.peekLast() != null) {
            System.out.print(namesDeque.pollLast() + " ");
        }
        System.out.println();

        System.out.println(namesDeque.size());
        namesDeque.addAll(names);
        namesDeque.offer("Vova");
        //Ниже пример прохода по очереди используя итератор и ещё необходимо преобразование .stream().toList().
        ListIterator<String> iterator = namesDeque.stream().toList().listIterator();
        while (iterator.hasNext()) {
            System.out.print(iterator.next() + " ");
        }
        System.out.println();
    }
}