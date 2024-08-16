package metanit.oop;

/**
 * Кроме отдельных примитивных типов данных и классов в Java есть такой тип как enum
 * или перечисление. Перечисления представляют набор логически связанных констант.
 * Объявление перечисления происходит с помощью оператора enum, после которого идет
 * название перечисления. Затем идет список элементов перечисления через запятую.
 */
public class L36_Enum {
    public static void main(String[] args) {
        Order myOrder = Order.BUYLIMIT;
        System.out.println(myOrder);

        MarketOrder mOrder = new MarketOrder(23, Order.SELL);
        System.out.println(mOrder.getOrderType());

        //Ниже мы создали массив из ордеров.
        Order[] ord = Order.values();//метод возвращает массив из элементов перечисления.
        System.out.println(ord[2]);
        //А так мы можем распечатать все элементы перечисления.
        for (Order o : ord) {
            System.out.print(o + "  ");
        }
        System.out.println();
        //Для получения порядкового номера элемента перечисления используют метод ordinal().
        System.out.println(Order.SELL.ordinal());

        Color myColor = Color.BLUE;
        System.out.println(myColor.getColor());
        myColor = Color.RED;
        myColor.info();
        myColor = Color.GREEN;
        myColor.info();
        myColor = Color.RED;
        myColor.colorRus = "не красный, а светло зелёный";
        myColor.info();
    }
}

enum Order {
    BUY,
    SELL,
    BUYLIMIT,
    SELLLIMIT
}

//У перечислений можно создавать поля, методы, в том числе методы самих элементов перечисления. Также использовать конструкторы.
enum Color {
    RED("красный"){
        @Override
        void info() {
            System.out.printf("Этот цвет %s.\n", colorRus);
        }
    },
    GREEN("зелёный"){
        @Override
        void info() {
            System.out.println("Этот цвет зелёный.");
        }
    },
    BLUE("синий"){
        @Override
        void info() {
            System.out.println("Этот цвет синий.");
        }
    };
    String colorRus;
    Color(String color) {
        colorRus = color;
    }
    public String getColor() {
        return "Its color is " + colorRus + ".";
    }
    abstract void info();
}

class MarketOrder {
    private Order order;
    private int lot;

    public MarketOrder(int lot, Order orderType) {
        this.lot = lot;
        order = orderType;
    }

    public String getOrderType() {
        switch(order) {
            case BUY -> {
                return "This order type is buy.";
            }
            case BUYLIMIT -> {
                return "This order type is buy limit.";
            }
            case SELL -> {
                return "This order type is sell.";
            }
            case SELLLIMIT -> {
                return "This order type is sell limit.";
            }
            default -> {
                return "Undefined";
            }
        }
    }
}