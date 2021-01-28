import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {

        doEx1();
        doEx2();
        doEx3();
        doEx4();
        doEx5();
    }

    public static void doEx1() {

        int i;
        int n = 17;

        ArrayList<Pair> listOfPairs;
        listOfPairs = checkDiv3or5(n);

        for (i = 0; i < n; i++) {
            System.out.println(listOfPairs.get(i).getMyNumber() + " - " +
                    listOfPairs.get(i).getMyValue());

        }
        System.out.println();
    }

    public static void doEx2() {

        List<Integer> listOfNumbers = Arrays.asList(1,2,5,4,8,2,3);

        System.out.println("Sum with for-loop: " + sumWithFor(listOfNumbers));
        System.out.println("Sum with for-each-loop: " + sumWithForEach(listOfNumbers));
        System.out.println("Sum with while-loop: " + sumWithWhile(listOfNumbers));
        System.out.println();
    }

    public  static void doEx3() {

        int myYear = 2021;

        System.out.print("The next 20 leap years: ");
        next20LeapYears(myYear);
        System.out.println();
    }

    public static void doEx4() {

        List<String> listOfStrings = Arrays.asList("School", "OF", "AutoMATION", "ENDaVA");

        System.out.println("Initial: " + listOfStrings);
        listOfStrings = lowercaseStrings(listOfStrings);
        System.out.println("Final:   " + listOfStrings);
        System.out.println();

    }

    public static void doEx5() {

        int i;
        double[] myNumbers = new double[]{2, 4, 1, 8, 6, 3.3, 0.7, -5.6};

        System.out.print("Initial: ");
        for (i = 0; i < myNumbers.length; i++)
            System.out.print(myNumbers[i] + "   ");
        System.out.println();
        myNumbers = doubleValues(myNumbers);
        System.out.print("Final:   ");
        for (i = 0; i < myNumbers.length; i++)
            System.out.print(myNumbers[i] + "   ");
        System.out.println();
    }

    /*
     * Input: n, a natural number;
     * The method will return for each number from 1 to n:
     *      3M if the number is divided by 3
     *      5M if the number is divided by 5
     *      the number if the number is not divided by 3 or by 5
     *      3M5M if the number is divide with both 3 and 5
     */
    private static ArrayList<Pair> checkDiv3or5(int n) {

        int i;
        ArrayList<Pair> listOfPairs = new ArrayList<>(n);

        for (i = 1; i <= n; i++) {

            if (i % 3 == 0) {

                if (i % 5 == 0) {
                    listOfPairs.add(new Pair(i, "3M5M"));
                } else {
                    listOfPairs.add(new Pair(i, "3M"));
                }
            } else if (i % 5 == 0) {
                listOfPairs.add(new Pair(i, "5M"));
            } else {
                listOfPairs.add(new Pair(i, String.valueOf(i)));
            }
        }
        return listOfPairs;
    }

    /*
     * Input: List of numbers
     * Sum of numbers using a for loop
     */
    private static int sumWithFor(List<Integer> listOfNumbers) {

        int i;
        int sum = 0;

        for (i = 0; i < listOfNumbers.size(); i++) {
            sum += listOfNumbers.get(i);
        }
        return sum;
    }

    /*
     * Input: List of numbers
     * Sum of numbers using a for-each-loop
     */
    private static int sumWithForEach(List<Integer> listOfNumbers) {

        int sum = 0;

        for (int nr : listOfNumbers) {
            sum += nr;
        }
        return sum;
    }

    /*
     * Input: List of numbers
     * Sum of numbers using a while loop
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

    /*
     * Input: year
     * Show the next 20 leap years
     */
    private static void next20LeapYears(int year) {

        int count = 0;

        while (count != 20) {

            if (year % 4 == 0 && (year % 100 != 0 || year % 400 == 0)) {
                System.out.print(year + " ");
                count++;
                year +=4;
            } else
                year++;
        }
        System.out.println();
    }

    /*
     * Input: List of Strings
     * Make the Strings lowercase
     */
    private static List<String> lowercaseStrings(List<String> listOfStrings) {

        return listOfStrings.stream().map(String::toLowerCase)
                                    .collect(Collectors.toList());

    }

    /*
     * Input: Array or list of numbers;
     * Replaces the current number with it’s double.
     */
    private static double[] doubleValues(double[] myNumbers) {

        return Arrays.stream(myNumbers).map(x -> x * 2)
                    .toArray();
    }
}