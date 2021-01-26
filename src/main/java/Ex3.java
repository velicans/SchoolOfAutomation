import java.util.ArrayList;

public class Ex3 {
// 3. Write a method that prints the next 20 leap years.

    public static void main(String[] args) {
        System.out.println(nextLeapYears(2021));
        System.out.println(nextLeapYears(2056));
    }

    public static ArrayList<Integer> nextLeapYears(int year) {
        int count = 0;
        ArrayList<Integer> listLeapYears = new ArrayList<Integer>();
        year++;
        while (count < 20) {
            if((year % 400 == 0) || ((year % 4 == 0) && (year % 100 != 0))) {
                listLeapYears.add(year);
                count++;
                year += 4;
            } else {
                year++;
            }

        }
        return listLeapYears;
    }
}
