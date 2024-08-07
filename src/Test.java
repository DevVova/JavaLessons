public class Test {
    public static void main(String[] args) {
        int a = 8;
        int b = 4;
        b = ++a;
        b += 35;
        int c = a % b;
        c = b--;
        System.out.printf("c = %d, b =%d\n", c, b);
        boolean bb = c < b;
        System.out.println(bb);
        if ((a == b) || (c == b)) System.out.println("Equals all.");
        else System.out.println("Всё разное!!!");
        System.out.printf("a do == %d\t", a);
        a *= 34;
        System.out.printf("a posle == %d\n", a);
        int n = 3;
        byte n1 = -6;
        short n2 = 34;
        n = n1 + n2;
        System.out.println(n);
        char ch = 'l';
        n += (ch + 120);
        System.out.println(n);
        n1 = (byte)n;
        System.out.println(n1);

        boolean val = true;
        boolean[] arr = new boolean[8];
        int it = 0;
        do {
            it++;
            if (it == 4) continue;
            arr[it] = val;
            val = !val;
            System.out.printf("Элемент %d равен %b \t", it, arr[it]);
            if (it == 6) break;
        } while (it < 7);
    }
}