import java.util.Arrays;
import java.util.List;

public class Ex2 {

    /**
     * 2. Write three functions that compute the sum of the
     * numbers in a list: using a for-loop, a for-each-loop
     * and a while-loop
     */
    public static void doEx2() {

        List<Integer> listOfNumbers = Arrays.asList(1, 2, 5, 4, 8, 2, 3);

        System.out.println("Sum with for-loop: " + sumWithFor(listOfNumbers));
        System.out.println("Sum with for-each-loop: " + sumWithForEach(listOfNumbers));
        System.out.println("Sum with while-loop: " + sumWithWhile(listOfNumbers));
        System.out.println();
    }


    /**
     * @param listOfNumbers a list of numbers
     * @return the sum of numbers using a for loop
     */
    private static int sumWithFor(List<Integer> listOfNumbers) {

        int i;
        int sum = 0;

        for (i = 0; i < listOfNumbers.size(); i++) {
            sum += listOfNumbers.get(i);
        }
        return sum;
    }


    /**
     * @param listOfNumbers a list of numbers
     * @return the sum of numbers using a for-each-loop
     */
    private static int sumWithForEach(List<Integer> listOfNumbers) {

        int sum = 0;

        for (int nr : listOfNumbers) {
            sum += nr;
        }
        return sum;
    }


    /**
     * @param listOfNumbers a list of numbers
     * @return the sum of numbers using a while loop
     */
    private static int sumWithWhile(List<Integer> listOfNumbers) {

        int i = listOfNumbers.size() - 1;
        int sum = 0;

        while (i >= 0) {
            sum += listOfNumbers.get(i);
            i--;
        }
        return sum;
    }
}
