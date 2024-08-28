package metanit.collections;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * Основные характеристики HashMap:
 * Основа работы: HashMap хранит данные в виде пар "ключ-значение". Для хранения этих пар
 * используется хеширование, что позволяет обеспечивать эффективное время доступа, вставки
 * и удаления элементов — в среднем время доступа составляет O(1).
 * <p>
 * Ключи и значения: Ключи в HashMap должны быть уникальными. Если вы добавляете новый элемент
 * с ключом, который уже существует, значение по этому ключу перезаписывается. Значения могут
 * быть любыми, включая null, однако ключи тоже могут быть null, но только один раз (то есть,
 * только один null-ключ разрешен).
 * <p>
 * Неупорядоченность: HashMap не гарантирует какого-либо порядка элементов. Пары "ключ-значение"
 * могут храниться в произвольном порядке.
 * <p>
 * Потокобезопасность: HashMap не является потокобезопасным. Если требуется использовать отображение
 * в многопоточной среде, нужно синхронизировать доступ к нему вручную либо использовать ConcurrentHashMap.
 * <p>
 * Основные методы HashMap:
 * put(K key, V value): добавляет пару "ключ-значение" в отображение
 * get(Object key): возвращает значение, соответствующее заданному ключу, или null, если ключ отсутствует
 * remove(Object key): удаляет пару, связанную с заданным ключом
 * containsKey(Object key): проверяет, содержится ли указанный ключ в отображении
 * containsValue(Object value): проверяет, содержится ли указанное значение в отображении
 * size(): возвращает количество элементов
 * keySet(): возвращает множество ключей
 * values(): возвращает коллекцию всех значений
 * entrySet(): возвращает набор всех пар "ключ-значение".
 */
public class L53_Map_HashMap {
    public static void main(String[] args) {
        Map<Integer, String> myMap = new HashMap<>();
        myMap.put(1, "Sell");
        myMap.put(2, "Buy");
        System.out.println(myMap.get(2));

        Map<Integer, String> map = new HashMap<>();
        map.put(1, "SellLimit");
        map.putAll(myMap);
        System.out.println(map.get(1));// В данном случае ключ 1 уже существует в map со значением "SellLimit", но при вызове putAll(myMap) значение для ключа 1 перезаписывается на "Sell".

        //Проверим, содержится ли указанный ключ в отображении.
        System.out.println(map.containsKey(3));

        //Проверим, содержится ли указанное значение в отображении.
        System.out.println(map.containsValue("Buy"));

        //Узнаем размер отображения.
        System.out.println(map.size());

        //Узнаем коллекцию всех значений у отображения.
        Collection<String> value = map.values();
        for (String i : value) {
            System.out.print(i + " ");
        }
        System.out.println();

        //Узнаем набор всех ключей у отображения.
        Set<Integer> keys = map.keySet();
        for (int i : keys) {
            System.out.print(i + " ");
        }
        System.out.println();

        //Заменим элемент.
        map.replace(1, "Sell", "SellLimit");
        map.put(23, "Sell");
        Collection<String> allValues = map.values();
        for (String i : allValues) {
            System.out.print(i + "   ");
        }
        System.out.println();

        //Удалим элемент по ключу 2.
        map.remove(2);
        allValues = map.values();
        for (String i : allValues) {
            System.out.print(i + "   ");
        }
        System.out.println();

        //Ещё один способ перебора элементов отображения.
        for (Map.Entry<Integer, String> item : map.entrySet()) {
            System.out.print(item.getKey() + " " + item.getValue() + "     ");
        }
        System.out.println();
    }
}
