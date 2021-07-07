import java.lang.reflect.Array;
import java.util.*;

public class Main {

    // write a method here
    public static int[] getFirstAndLast(int[] array) {

        int firstElem = (int) Array.get(array, 0);
        int lastElem = (int) Array.get(array, array.length - 1);

        return new int[]{firstElem, lastElem};
    }


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] array = Arrays.stream(scanner.nextLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        int[] result = getFirstAndLast(array);
        Arrays.stream(result).forEach(e -> System.out.print(e + " "));
    }
}