package metanit.basics;

/**
 * С помощью параметров мы можем передать в методы различные данные, которые будут использоваться для вычислений.
 * А при вызове этого метода в программе нам необходимо передать на место параметров значения, которые
 * соответствуют типу параметра. Значения, которые передаются на место параметров, еще называются аргументами.
 * Значения передаются параметрам по позиции, то есть первый аргумент первому параметру, второй
 * аргумент - второму параметру и так далее.
 * Методы могут возвращать некоторое значение. Для этого применяется оператор return.
 * При этом возвращаемое значение всегда должно иметь тот же тип, что значится в определении функции.
 */
public class L20_21_Method_Parameters_And_Return {
    public static void main(String[] args) {
        info(24, "Vova");
        info(18, "Sam");
        int res = sum(29, 12, 22, 1);
        System.out.println(res);
        res = multiply(44, 1, 22, 34);
        System.out.println(res);
        infoAge(11);
        infoHour(25);
        infoHour(8);
    }

    static String info(int age, String name) {
        return System.out.printf("He is %s. He's %d years old.\n", name, age).toString();
    }

    //Параметры переменной длины.
    //Метод может принимать параметры переменной длины одного типа.
    static int sum(int... a) {
        int s = 0;
        for (int i = 0; i < a.length; i++) {
            s += a[i];
        }
        return s;
    }

    //Ниже пример другого for.
    /*
    Троеточие перед названием параметра int ...a указывает на то, что он будет необязательным
    и будет представлять массив. Мы можем передать в метод sum одно число, несколько чисел,
    а можем вообще не передавать никаких параметров.
    */
    static int multiply(int... a) {
        int m = 1;
        for (int i : a) {
            m *= i;
        }
        return m;
    }

    //Ниже пример когда метод содержит несколько возвращаемых значений и выбирается одно из них в зависимости от условия.
    static String infoAge(int age) {
        if (age > 0 && age < 130) return System.out.printf("He's %d years old.\n", age).toString();
        else return System.out.printf("%d is a don't real age.\n", age).toString();
    }

    //Ниже пример выхода из метода, который ничего не возвращает.
    static void infoHour(int hour) {
        if (hour < 0 || hour > 24) {
            System.out.println("Are you crazy?");
            return;
        }
        System.out.printf("Now %d hour.", hour);
    }
}
