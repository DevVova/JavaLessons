package metanit.exceptions;

/**
 * Оператор throws используется в объявлении метода, в котором не происходит обработка исключения.
 * Но сама обработка исключения тогда происходит при вызове метода.
 */
public class L43_Throws {
    public static void main(String[] args) {
        Operation operation = new Operation(234, 0);

        //Ниже идёт обработка возможного исключения от метода divide().
        try {
            int res = operation.divide();
            System.out.println(res);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        //Ниже идёт вызов метода, который сам обрабатывает исключения.
        System.out.print(divide2(12, 4) + "\n");
        System.out.println(divide2(2, 0));
    }

    public static int divide2(int a, int b) {
        int result;
        try {
            if (b == 0) throw new Exception("Вы делите на ноль, но так нельзя!");
            result = a / b;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            result = 0;
        }
        return result;
    }
}

//Ниже пример метода который сам не обрабатывает исключения.
record Operation(int a, int b) {
    public int divide() throws Exception{
        if (b == 0) throw new Exception("Не надо делить на ноль.");
        return a / b;
    }
}