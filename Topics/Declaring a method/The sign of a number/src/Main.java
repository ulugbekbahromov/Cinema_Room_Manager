import java.util.Scanner;

public class Main {

    public static int sign(int number) {

        int signNumber = 0;
        if (number > 0) {
            signNumber = 1;
        } else if (number < 0) {
            signNumber = -1;
        }

        return signNumber;
    }

    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        final int n = scanner.nextInt();
        System.out.println(sign(n));
    }
}