package Exercitii;

//  3. Write a method that prints the next 20 leap years.

public class Ex3LeapYear {

    public void getLeapYears(int startYear) {
        System.out.println("The next 20 leap years from the given year " + startYear + " are: ");
        int count = 0;
        while (count != 20) {
            startYear = startYear + 1;
            if ((startYear % 400 == 0) || (startYear % 4 == 0 && startYear % 100 != 0)) {
                System.out.println(startYear);
                count++;
            }
        }
    }
}
