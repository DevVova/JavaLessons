package metanit.basics;

/**
 * <p>
 *     В завершении рассмотрим операции присваивания, которые в основном представляют комбинацию простого
 * присваивания с другими операциями. Я здесь рассматриваю только те комбинации, которые намериваюсь
 * использовать. Их больше, но я остальные не рассматриваю.
 * </p>
 */
public class L14_Assignment_Operations {
    public static void main(String[] args) {
        int a = 63;
        int b = 4;
        b += a;
        System.out.printf("a = %d, b = %d\n", a, b);
        a -= b;
        System.out.printf("a = %d, b = %d\n", a, b);
        b /= a;
        System.out.printf("a = %d, b = %d\n", a, b);
        a %= b;
        System.out.printf("a = %d, b = %d\n", a, b);
        b *= a;
        System.out.printf("a = %d, b = %d\n", a, b);
    }
}
