package metanit.collections;

import java.util.*;

/**
 * Интерфейс SortedSet предназначен для создания коллекций, который хранят элементы
 * в отсортированном виде (сортировка по возрастанию).
 * <p>
 * Интерфейс NavigableSet расширяет интерфейс SortedSet и позволяет извлекать элементы
 * на основании их значений.
 * <p>
 * Обобщенный класс TreeSet<E> представляет структуру данных в виде дерева, в котором
 * все объекты хранятся в отсортированном виде по возрастанию. TreeSet является
 * наследником класса AbstractSet и реализует интерфейс NavigableSet, а следовательно,
 * и интерфейс SortedSet.
 */
public class L51_SortedSet_NavigableSet_TreeSet {
    public static void main(String[] args) {
        SortedSet<Integer> sortedSet = new TreeSet<>(Arrays.asList(18, 45, 2, 12, 7));
        runToCollection(sortedSet);
        NavigableSet<Integer> navigableSet = new TreeSet<>(Arrays.asList(5, 33, 22, 0, 8, 99));
        runToCollection(navigableSet);

        //first(): Возвращает первый (наименьший) элемент множества.
        System.out.println(sortedSet.first());

        //last(): Возвращает последний (наибольший) элемент множества.
        System.out.println(navigableSet.last());

        //Добавить элемент.
        sortedSet.add(20);

        //subSet(E fromElement, E toElement): Возвращает подмножество от fromElement (включительно) до toElement (исключительно).
        SortedSet<Integer> subSet = sortedSet.subSet(5, 20);//NavigableSet нельзя.
        runToCollection(subSet);

        //headSet(E toElement): Возвращает множество всех элементов, меньших чем toElement.
        SortedSet<Integer> headSet = sortedSet.headSet(25);
        runToCollection(headSet);

        //tailSet(E fromElement): Возвращает множество всех элементов, больших или равных fromElement.
        SortedSet<Integer> tailSet = sortedSet.tailSet(20);
        runToCollection(tailSet);

        /*
        Метод comparator() полезен для проверки того, как именно элементы сортируются в множестве.
        Он позволяет узнать, используется ли естественный порядок или пользовательский компаратор для сортировки элементов.
         */
        //Если вы хотите использовать специальный порядок сортировки, вы можете передать компаратор при создании TreeSet.
        SortedSet<Integer> newSortedSet = new TreeSet<>(Comparator.reverseOrder());
        newSortedSet.addAll(Arrays.asList(4, 66, 2, 23));
        System.out.println("Comparator: " + newSortedSet.comparator());// Выведет объект компаратора, используемого для сортировки.
        runToCollection(newSortedSet);
        runToCollection(navigableSet.reversed());//Выведет в порядке наоборот.

        /*
         * Основные особенности NavigableSet:
         * Двусторонняя навигация: Вы можете перемещаться как вверх, так и вниз по множеству, получая ближайшие элементы.
         * Подмножества с гибкими границами: Можно получать подмножества с чётко указанными границами, которые
         * могут включать или исключать граничные элементы.
         * Реверсирование: Есть возможность получения обратного порядка элементов.
         */
        //lower(E e)
        //Возвращает наибольший элемент множества, который меньше указанного элемента, или null, если такого элемента нет.
        runToCollection(navigableSet);
        System.out.println(navigableSet.lower(24));

        //floor(E e)
        //Возвращает наибольший элемент множества, который меньше или равен указанному элементу, или null, если такого элемента нет.
        System.out.println(navigableSet.floor(33));

        //ceiling(E e)
        //Возвращает наименьший элемент множества, который больше или равен указанному элементу, или null, если такого элемента нет.
        System.out.println(navigableSet.ceiling(18));

        //higher(E e)
        //Возвращает наименьший элемент множества, который больше указанного элемента, или null, если такого элемента нет.
        System.out.println(navigableSet.higher(7));

        //pollFirst()
        //Удаляет и возвращает первый (наименьший) элемент множества, или null, если множество пусто.
        System.out.println(navigableSet.pollFirst());
        runToCollection(navigableSet);

        //pollLast()
        //Удаляет и возвращает последний (наибольший) элемент множества, или null, если множество пусто.
        System.out.println(navigableSet.pollLast());
        runToCollection(navigableSet);

        //descendingSet()
        //Возвращает множество с элементами в обратном порядке.
        NavigableSet<Integer> descendingSet = navigableSet.descendingSet();
        runToCollection(descendingSet);

        //subSet(E fromElement, boolean fromInclusive, E toElement, boolean toInclusive)
        //Возвращает подмножество в диапазоне от fromElement до toElement, где можно указать, включать ли граничные элементы.
        NavigableSet<Integer> nSet = navigableSet.subSet(6, true, 25, true);//descendingSet нельзя иначе будет исключение, так как множество в убывающем порядке.
        runToCollection(nSet);

        runToCollection(navigableSet.tailSet(9));//Выведет все элементы больше 9, включая 9 если есть.
    }
    public static <E> void runToCollection(Collection<? extends E> col) {
        for (E element : col) {
            System.out.print(element + " ");
        }
        System.out.println();
    }
}