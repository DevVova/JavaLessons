package metanit.collections;

import java.util.*;

/**
 * TreeMap — это класс в Java, который реализует интерфейс NavigableMap и расширяет AbstractMap.
 * Основное отличие TreeMap от других классов, реализующих интерфейс Map, заключается в том,
 * что TreeMap поддерживает порядок сортировки ключей. Ключи в TreeMap автоматически сортируются
 * в соответствии с их естественным порядком (например, по возрастанию для чисел и лексикографически
 * для строк) или с порядком, указанным в компараторе при создании объекта TreeMap.
 * <p>
 * Основные характеристики TreeMap:
 * Сортировка ключей: Все ключи хранятся в отсортированном порядке.
 * Время доступа: Операции вставки, удаления и поиска выполняются за O(log n) времени.
 * Не допускает null ключей: Если попытаться вставить null ключ, будет выброшено NullPointerException.
 */
public class L54_SortedMap_NavigableMap_TreeMap {
    public static void main(String[] args) {
        SortedMap<Integer, String> sortedMap = new TreeMap<>();
        NavigableMap<Integer, String> navigableMap = new TreeMap<>();
        sortedMap.put(34, "my");
        sortedMap.put(21, "his");
        //Получим значение первого наименьшего ключа.
        System.out.println(sortedMap.firstKey());

        //Печатаем содержимое.
        System.out.println("Содержимое TreeMap: " + sortedMap);

        //Получим значение по ключу. Если такого ключа нет, то null.
        System.out.println(sortedMap.get(21));

        sortedMap.put(17, "no");
        //Выполним перебор всех элементов.
        for (Map.Entry<Integer, String> item : sortedMap.entrySet()) {
            System.out.printf("Key: %d. Value: %s.     ", item.getKey(), item.getValue());
        }
        System.out.println();

        //Получим весь набор ключей.
        //С помощью while и преобразованием набора ключей в массив.
        int mapSize = sortedMap.size();
        int i = 0;
        Set<Integer> keys = sortedMap.keySet();
        Integer[] arr = keys.toArray(new Integer[0]);
        while (i < mapSize) {
            System.out.print(arr[i] + " ");
            i++;
        }
        System.out.println();
        //С помощью цикла for.
        for (int ii : keys) {
            System.out.print(ii + "  ");
        }
        System.out.println();
        //С использованием итератора.
        Iterator<Integer> iterator = keys.iterator();
        while (iterator.hasNext()) {
            System.out.print(iterator.next() + "   ");
        }
        System.out.println();

        //Получим всю коллекцию значений.
        Collection<String> valueAll = sortedMap.values();
        for (String a : valueAll) {
            System.out.print(a + " ");
        }
        System.out.println();
        Iterator<String> iter = valueAll.iterator();
        while (iter.hasNext()) {
            System.out.print(iter.next() + "  ");
        }
        System.out.println();

        //Получим элемент с наименьшим ключом k, который больше или равен ключу key (k >=key). Если такого ключа нет, то возвращается null.
        navigableMap.putAll(sortedMap);
        Map.Entry<Integer, String> entry = navigableMap.ceilingEntry(18);
        System.out.println(entry);
        System.out.println(entry.getKey());//Получим ключ этого элемента.

        //floorEntry(K key): возвращает элемент с наибольшим ключом k, который меньше или равен ключу key (k <=key). Если такого ключа нет, то возвращается null.
        entry = navigableMap.floorEntry(36);
        System.out.println(entry + "  " + entry.getValue());

        //higherEntry(K key): возвращает элемент с наименьшим ключом k, который больше ключа key (k >key). Если такого ключа нет, то возвращается null.
        entry = navigableMap.higherEntry(11);
        System.out.println(entry);

        //lowerEntry(K key): возвращает элемент с наибольшим ключом k, который меньше ключа key (k <key). Если такого ключа нет, то возвращается null.
        entry = navigableMap.lowerEntry(77);
        System.out.println(entry);

        //firstEntry(): возвращает первый элемент отображения
        Map.Entry<Integer, String> en = navigableMap.firstEntry();
        System.out.println(en);

        //lastEntry(): возвращает последний элемент отображения
        System.out.println(navigableMap.lastEntry());

        //pollFirstEntry(): возвращает и одновременно удаляет первый элемент из отображения
        System.out.println(navigableMap);
        System.out.println(navigableMap.pollFirstEntry());
        System.out.println(navigableMap);

        //pollLastEntry(): возвращает и одновременно удаляет последний элемент из отображения
        System.out.println(navigableMap);
        System.out.println(navigableMap.pollLastEntry());
        System.out.println(navigableMap);

        //NavigableSet<K> descendingKeySet(): возвращает объект NavigableSet, который содержит все ключи отображения в обратном порядке
        navigableMap.putAll(sortedMap);
        navigableMap.put(3, "cat");
        navigableMap.put(45, "milk");
        NavigableSet<Integer> allKeys = navigableMap.navigableKeySet();
        System.out.println(allKeys);
        //Ниже набор перевёл в массив и вывел третий элемент.
        Integer[] allKeysArr = allKeys.toArray(new Integer[0]);
        System.out.println(allKeysArr[2]);

        //NavigableMap<K, V> descendingMap(): возвращает отображение NavigableMap, которое содержит все элементы в обратном порядке
        for (NavigableMap.Entry<Integer, String> itemTo : navigableMap.descendingMap().entrySet()) {
            System.out.print("Key: " + itemTo.getKey() + ", " + "Value: " + itemTo.getValue() + "      ");
        }
        System.out.println();

        /*
        NavigableMap<K, V> headMap(K upperBound, boolean incl): возвращает отображение NavigableMap,
        которое содержит все элементы оригинального NavigableMap вплоть от элемента с ключом upperBound.
        Параметр incl при значении true указывает, что элемент с ключом upperBound также включается в выходной набор.
         */
        NavigableMap<Integer, String> anyMap = navigableMap.headMap(33, true);//Нужно писать true иначе будет ошибка на этапе компиляции.
        System.out.println(anyMap.keySet());

        /*
        NavigableMap<K, V> subMap(K lowerBound, boolean lowIncl, K upperBound, boolean highIncl):
        возвращает отображение NavigableMap, которое содержит все элементы оригинального NavigableMap
        от элемента с ключом lowerBound до элемента с ключом upperBound. Параметры lowIncl и highIncl
        при значении true включают в выходной набор элементы с ключами lowerBound и upperBound соответственно.
         */
        for (Map.Entry<Integer, String> item : navigableMap.subMap(6, true, 34, false).entrySet()) {
            System.out.printf("Key: %d Value: %s     ", item.getKey(), item.getValue());
        }
        System.out.println();

        /*
        NavigableMap<K, V> tailMap(K lowerBound, boolean incl): возвращает отображение NavigableMap,
        которое содержит все элементы оригинального NavigableMap, начиная с элемента с ключом
        lowerBound. Параметр incl при значении true указывает, что элемент с ключом lowerBound
        также включается в выходной набор.
         */
        System.out.println(navigableMap.tailMap(22, true));
        //Ниже преобразовал набор ключей в массив и вывел второй элемент.
        System.out.println(navigableMap.tailMap(22, true).keySet().toArray(new Integer[0])[1]);

        //Map.Entry<K, V> lastEntry(): возвращает последний элемент отображения
        System.out.println(navigableMap.lastEntry().getValue());

        //Ну и на последок создам объект с помощью Comparator.
        Comparator<Integer> compNew = new ComparatorNew();
        TreeMap<Integer, String> treeMap2 = new TreeMap<>(compNew);
        treeMap2.putAll(navigableMap);
        for (int a : treeMap2.keySet()) {
            System.out.print(a + " ");
        }
        System.out.println();
        System.out.println(treeMap2);
    }
}

//Ниже класс реализующий сортировку, где числа будут в порядке убывания.
class ComparatorNew implements Comparator<Integer> {
    @Override
    public int compare(Integer num1, Integer num2) {
        if (num1 > num2) return -1;
        else if (num1.equals(num2)) return 0;
        else return 1;
    }
}