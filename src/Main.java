import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Let's get started!");

        System.out.print("Input your name: ");
        Scanner in = new Scanner(System.in);
        String name = in.nextLine();
        System.out.printf("Your name is %s\n", name);
    }
}