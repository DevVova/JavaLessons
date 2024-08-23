package metanit.collections;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.ListIterator;

/**
 * Для создания простых списков применяется интерфейс List, который расширяет
 * функциональность интерфейса Collection. Некоторые наиболее часто используемые методы интерфейса List:
 * <p>
 * void add(int index, E obj): добавляет в список по индексу index объект obj
 * <p>
 * boolean addAll(int index, Collection<? extends E> col): добавляет в список
 * по индексу index все элементы коллекции col. Если в результате добавления список
 * был изменен, то возвращается true, иначе возвращается false
 * <p>
 * E get(int index): возвращает объект из списка по индексу index
 * <p>
 * int indexOf(Object obj): возвращает индекс первого вхождения объекта obj
 * в список. Если объект не найден, то возвращается -1
 * <p>
 * int lastIndexOf(Object obj): возвращает индекс последнего вхождения объекта
 * obj в список. Если объект не найден, то возвращается -1
 * <p>
 * ListIterator<E> listIterator (): возвращает объект ListIterator для обхода элементов списка
 * <p>
 * static <E> List<E> of(элементы): создает из набора элементов объект List
 * <p>
 * E remove(int index): удаляет объект из списка по индексу index, возвращая при этом удаленный объект
 * <p>
 * E set(int index, E obj): присваивает значение объекта obj элементу, который находится по индексу index
 * <p>
 * void sort(Comparator<? super E> comp): сортирует список с помощью компаратора comp
 * <p>
 * List<E> subList(int start, int end): получает набор элементов, которые находятся в списке
 * между индексами start и end
 * <p>
 * По умолчанию в Java есть встроенная реализация этого интерфейса - класс ArrayList. Класс
 * ArrayList представляет обобщенную коллекцию, которая наследует свою функциональность
 * от класса AbstractList и применяет интерфейс List. Проще говоря, ArrayList представляет
 * простой список, аналогичный массиву, за тем исключением, что количество элементов в нем не фиксировано.
 */
public class L46_47_ArrayList {
    public static void main(String[] args) {
        //Создаём пустой список.
        ArrayList<String> car = new ArrayList<>();

        //ArrayList (int capacity): создает список, который имеет начальную емкость capacity.
        ArrayList<Integer> num = new ArrayList<>(4);
        for (int i = 0; i < 4; i++) {
            num.add(i + 1);
        }
        System.out.println(num.get(3));//Если бы мы не добавили в список элементы в цикле, то при обращении к элементу с индексом 3 была бы ошибка.

        ArrayList<Integer> allNum = new ArrayList<>(num);//Создали новый список и в него поместили другой список.
        allNum.add(23);//Добавили новый элемент в список.
        allNum.add(1, 9);//Добавили ещё один элемент и указали что он должен быть вторым в списке.
        allNum.addFirst(8);//Добавили ещё один элемент и указали что он должен быть первым в списке.
        boolean addOrNot = allNum.addAll(num);//Снова добавили целую коллекцию(список).
        System.out.println(addOrNot);
        allNum.addLast(45);//Добавили в конец ещё один элемент.
        System.out.println(allNum.size());//Узнаём размер списка.
        allNum.set(10, 0);//Изменили значение предпоследнего элемента списка(всего элементов 12).
        for (Integer i : allNum) {
            System.out.printf("%d  ", i);
        }
        System.out.println("\n");
        System.out.println(allNum.get(4));//Получаем объект из списка по индексу 4.
        System.out.println();

        //Далее допустим на нужно установить являются ли объекты элементами списка, если да то вернётся значение индекса, если нет то -1.
        int indexNum17 = allNum.indexOf(17);
        System.out.println(indexNum17);
        int indexNum23 = allNum.indexOf(23);
        System.out.println(indexNum23);
        int indexNum3 = allNum.indexOf(3);//Хоть чисел 3 две штуки, но обнаружилось только первое, а для другого нужно ниже.
        System.out.println(indexNum3);
        int indexNum3Last = allNum.lastIndexOf(3);
        System.out.println(indexNum3Last);//Возвращает индекс последнего вхождения объекта.

        //Как проходить по списку туда и обратно.
        ListIterator<Integer> iterator = allNum.listIterator();
        //Проход вперёд.
        System.out.print("Идём вперёд по списку чисел: ");
        while(iterator.hasNext()) {
            System.out.printf("%d ", iterator.next());
        }
        System.out.println();
        System.out.println(allNum.get(3));
        //Проход назад.
        System.out.print("Идём назад по списку чисел: ");
        while(iterator.hasPrevious()) {
            System.out.printf("%d ", iterator.previous());
        }
        System.out.println();
        System.out.println(allNum.get(3));
        allNum.remove(4);//Удаление объекта с индексом 4.
        for (Integer i : allNum) {
            System.out.printf("%d  ", i);
        }
        System.out.println("\n");

        //Сортировка элементов списка.
        //Сортировка по возрастанию значений чисел списка.
        allNum.sort(Comparator.naturalOrder());
        for (Integer i : allNum) {
            System.out.printf("%d  ", i);
        }
        System.out.println("\n");
        //Сортировка по убыванию значений чисел списка.
        allNum.sort(Comparator.reverseOrder());
        for (Integer i : allNum) {
            System.out.printf("%d  ", i);
        }
        System.out.println("\n");

        //Создание из набора элементов неизменяемого списка.
        List<Integer> numConst = List.of(2, 55, 6);
        for (Integer i : numConst) {
            System.out.printf("%d ", i);
        }
        System.out.println();

        //Метод List<E> subList(int start, int end) возвращает представление части исходного списка между индексами start (включительно) и end (исключительно).
        List<Integer> sublist = allNum.subList(4, 9);
        System.out.println("Подсписок: " + sublist);
    }
}
