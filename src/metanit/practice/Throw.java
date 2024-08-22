package metanit.practice;

public class Throw {
    public static void main(String[] args) {
        try {
            int result = divide(23, 0);
            System.out.println(result);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        try {
            int k = 3 / 0;
        } catch (Exception e) {
            e.getStackTrace();
        }
    }

    public static int divide(int a, int b) throws Exception {
        if (b == 0) throw new Exception("На ноль делить нельзя!");
        return a / b;
    }
}