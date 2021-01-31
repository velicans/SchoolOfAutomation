package Day2Exercises;

import java.util.Calendar;

public class Ex3 {

    /**
     * 3. Write a method that prints the next 20 leap years.
     */
    public static void doEx3() {

        int myYear = Calendar.getInstance().get(Calendar.YEAR);

        System.out.print("The next 20 leap years: ");
        next20LeapYears(myYear);
        System.out.println();
    }


    /**
     * Print the next 20 leap years
     *
     * @param year the initial year
     */
    private static void next20LeapYears(int year) {

        int count = 0;

        while (count != 20) {

            if (year % 4 == 0 && (year % 100 != 0 || year % 400 == 0)) {
                System.out.print(year + " ");
                count++;
                year += 4;
            } else
                year++;
        }
        System.out.println();
    }
}
