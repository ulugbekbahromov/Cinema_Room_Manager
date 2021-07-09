import java.util.Scanner;

class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int height1 = scanner.nextInt();
        int height2 = scanner.nextInt();
        int height3 = scanner.nextInt();

        boolean isAscending = height1 <= height2 && height2 <= height3;
        boolean isDescending = height1 >= height2 && height2 >= height3;

        System.out.println(isAscending || isDescending);
    }
}