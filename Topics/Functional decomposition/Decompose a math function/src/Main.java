import java.util.Scanner;

class MultipleFunction {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double x = scanner.nextDouble();
        System.out.println(f(x));
    }

    public static double f(double x) {

        if (x <= 0) {
            return f1(x);
        } else if (x >= 1) {
            return f3(x);
        } else {
            return f2(x);
        }
    }

    public static double squareIt(double x) {
        return x * x;
    }

    public static double f1(double x) {
        return squareIt(x) + 1;
    }

    public static double f2(double x) {
        return 1 / squareIt(x);
    }

    public static double f3(double x) {
        return squareIt(x) - 1;
    }
}