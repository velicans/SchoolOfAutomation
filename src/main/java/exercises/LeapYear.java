package exercises;

public class LeapYear {

    /**
     * This method prints the next x leap years
     *
     * @param startingYear  of the calculation
     * @param noOfLeapYears number of leap years to be calculated
     */
    public static void printNextLeapYears(int startingYear, int noOfLeapYears) {
        int count = 0;
        while (count < noOfLeapYears) {
            startingYear++;
            if ((startingYear % 4 == 0 && (startingYear % 100 != 0)) || (startingYear % 400 == 0)) {
                count++;
                System.out.print(startingYear + " ");
            }

        }
    }

}

