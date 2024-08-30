package metanit.practice;

public class ExceptionsClass {
    public static void main(String[] args) {
        ManMy vova = new ManMy("Vova", -8);
        System.out.println(vova.age);

        try{
            vova.getAge();//Этот метод теперь может быть вызван только после обработки исключения.
        } catch (Exception exception) {
            System.out.println(exception.getMessage());
        }
    }
}

class MyException extends Exception{
    public MyException(String message) {
        super(message);
    }
}

class ManMy {
    int age;
    String name;

    public ManMy(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public int getAge() throws MyException {
        if (age == 0 || age > 140 || age < 0) throw new MyException("Не корректный возраст");
        return age;
    }
}