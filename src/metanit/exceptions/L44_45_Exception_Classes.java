package metanit.exceptions;

/**
 * Базовым классом для всех исключений является класс Throwable. От него уже наследуются
 * два класса: Error и Exception.
 * Класс Error описывает внутренние ошибки в исполняющей среде Java. Программист имеет очень
 * ограниченные возможности для обработки подобных ошибок.
 * Собственно исключения наследуются от класса Exception. Среди этих исключений следует
 * выделить класс RuntimeException. RuntimeException является базовым классом для так
 * называемой группы непроверяемых исключений (unchecked exceptions) - компилятор не
 * проверяет факт обработки таких исключений и их можно не указывать вместе с оператором
 * throws в объявлении метода. Такие исключения являются следствием ошибок разработчика,
 * например, неверное преобразование типов или выход за пределы массива.
 * Все остальные классы, образованные от класса Exception, называются проверяемыми исключениями
 * (checked exceptions).
 * Некоторые из классов проверяемых исключений:
 * CloneNotSupportedException: класс, для объекта которого вызывается клонирование, не реализует
 * интерфейс Cloneable
 * InterruptedException: поток прерван другим потоком
 * ClassNotFoundException: невозможно найти класс
 * Подобные исключения обрабатываются с помощью конструкции try..catch. Либо можно передать
 * обработку методу, который будет вызывать данный метод, указав исключения после оператора throws.
 * <p>
 * Ключевые слова для работы с исключениями
 * try — используется для того, чтобы поместить код, который может вызвать исключение
 * catch — блок для обработки исключения
 * finally — блок, который выполняется независимо от того, возникло исключение или нет. Обычно
 * используется для освобождения ресурсов
 * throw — используется для явного выброса исключения
 * throws — указывает, что метод может выбросить исключение, и его следует обработать в вызывающем коде.
 */
public class L44_45_Exception_Classes {
    public static void main(String[] args) {
        try {
            int a = 3 / 0;
            System.out.println(a);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        System.out.println();

        Trader vova = new Trader(46);
        Trader gena = vova.clone();
        gena.info();
        gena.setAge(0);
        gena.info();
    }
}

class Trader implements Cloneable {
    private int age;

    public Trader(int age) {
        this.age = validAge(age);
    }

    public void setAge(int age) {
        this.age = validAge(age);
    }

    //Ниже пример проверяемого исключения, которое должно быть обработано с помощью try... catch.
    @Override
    public Trader clone() {
        try {
            Trader clone = (Trader) super.clone();
            return clone;
        } catch (CloneNotSupportedException e) {
            throw new AssertionError();
        } finally {
            System.out.println("Клонирование завершено.");
        }
    }

    public int validAge(int ageIn) {
        int result = 1;
        try {
            if (ageIn == 0 || ageIn < 0 || ageIn > 140) throw new MyException("Неверно указан возраст.");
            result = ageIn;
        } catch (MyException myException) {
            System.out.println(myException.getMessage());
        }
        return result;
    }

    public void info() {
        System.out.printf("He's %d years old.\n", age);
    }
}

//Пример создания своего класса исключений.
class MyException extends Exception {
    public MyException(String message) {
        super(message);
    }
}
class NotValidAge extends Exception {
    private final int age;
    public NotValidAge(String mes, int ageInput) {
        super(mes);
        age = ageInput;
    }

    public int getAge() {
        return age;
    }
}