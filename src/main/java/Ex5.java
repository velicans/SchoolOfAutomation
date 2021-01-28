import java.util.Arrays;

public class Ex5 {

    /**
     * 5. Write a method that iterates through an array or list of numbers and replaces the current number with
     * it’s double.
     */
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


    /**
     * @param myNumbers an array of numbers;
     * @return the initial array with the values doubled
     */
    private static double[] doubleValues(double[] myNumbers) {

        return Arrays.stream(myNumbers).map(x -> x * 2).toArray();
    }
}
