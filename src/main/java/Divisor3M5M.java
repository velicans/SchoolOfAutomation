import java.util.InputMismatchException;
import java.util.Scanner;

public class Divisor3M5M {

    /**
     * This method iterates through the natural numbers from 1 to n and
     * prints whether they are multiple of 3 or 5 or both.
     */

    public static void isDivisibleBy3M5M() {

        Scanner sc = new Scanner(System.in);
        System.out.println("Please enter a number:");
        try {
            int n = sc.nextInt();

            for (int i = 1; i <= n; i++) {
                if (i % 3 == 0 && i % 5 == 0) {
                    System.out.println(i + " 3M & 5M");
                } else if (i % 3 == 0) {
                    System.out.println(i + " 3M");
                } else if (i % 5 == 0) {
                    System.out.println(i + " 5M");
                } else
                    System.out.println(i);
            }
        } catch (InputMismatchException e) {
            System.out.println("Please enter a natural number");
            e.printStackTrace();
        }
    }
}
