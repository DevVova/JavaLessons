package metanit.oop;

/**
 * Объекты классов, как и данные примитивных типов, могут передаваться в методы. Однако
 * в данном случае есть одна особенность - при передаче объектов в качестве значения
 * передается копия ссылки на область в памяти, где расположен этот объект.
 */
public class L29_Objects_As_Method_Parameters {
    public static void main(String[] args) {
        Example e = new Example();
        e.infoPrice();
        exchangePrice(22, e);
        e.infoPrice();
        exchangePrice2(33, e);
        e.infoPrice();
    }

    //В этом примере мы изменяем значение поля объекта, который методом будет принят.
    static void exchangePrice(int priceNew, Example ex) {
        ex.price = priceNew;
        System.out.printf("New price is %d.\n", ex.price);
    }

    //А здесь мы не изменяем принятый объект, а создаём новый и у него меняем значение поля. Вот чем java отличается от kotlin, в java можно принятый параметр изменять, а в kotlin нет.
    static void exchangePrice2(int priceNew2, Example ex) {
        ex = new Example();
        ex.price = priceNew2;
        System.out.printf("New price is %d.\n", ex.price);
    }
}

class Example {
    int price = 9;

    void infoPrice() {
        System.out.printf("Price equals %d.\n", price);
    }
}