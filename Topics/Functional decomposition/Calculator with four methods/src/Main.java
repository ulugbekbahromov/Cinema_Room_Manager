class SimpleCalculator {

    public static void subtractTwoNumbers(long a, long b) {
        System.out.println(Math.subtractExact(a, b));
    }

    public static void sumTwoNumbers(long a, long b) {
        System.out.println(Math.addExact(a, b));
    }

    public static void divideTwoNumbers(long a, long b) {
        if (b == 0) {
            System.out.println("Division by 0!");
        } else {
            System.out.println(Math.floorDiv(a, b));
        }
    }

    public static void multiplyTwoNumbers(long a, long b) {
        System.out.println(Math.multiplyExact(a, b));
    }
}