import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * School for automation 2020 homework 1
 * @author Ratiu Alexandru
 */
public class Main {

    public static void main(String[] args) {

        List<Integer> listTest = new ArrayList<>();

        for (int i = 1; i <= 15; i++) {
            System.out.print(checkDivision(i)+" ");
            listTest.add(i);
        }
        System.out.println();

        System.out.println("Sum with for : "+sumFor(listTest)+", sum with foreach : "+sumForEach(listTest)+", sum with while : "+sumWhile(listTest)+".");


        findLeapYears();


        List<String> testList = new ArrayList<>();
        testList.add("Test");
        testList.add("TBD");

        System.out.println(toLower(testList));

        System.out.println(listTest.toString());
        listTest=doubleNumber(listTest);
        System.out.println(listTest.toString());

        System.out.println();
    }

    /**
     * Checks if a number is divided by 3, 5, both or none
     * @param number int to be checked
     * @return 3M if divisible by 3, 5M if divisible by 5, 3M5M if both or the number if neither
     */
    public static String checkDivision(int number) {
        String solution = "";

        if (number % 3 == 0) solution = solution + "3M";
        if (number % 5 == 0) solution = solution + "5M";

        if ("".equals(solution)) solution = String.valueOf(number);

        return solution;
    }

    /**
     * Calculates the sum of the numbers in a list using 'for'
     * @param list List<Integer>
     * @return int sum of the elements
     */
    public static int sumFor(List<Integer> list) {
        int sum = 0;
        for (int i = 0; i < list.size(); i++) {
            sum = sum + list.get(i);
        }

        return sum;
    }

    /**
     * Calculates the sum of the numbers in a list using 'foreach'
     * @param list List<Integer>
     * @return int sum of the elements
     */
    public static int sumForEach(List<Integer> list){
        int sum=0;
        for (int number:
             list) {
            sum=sum+number;
        }

        return sum;
    }

    /**
     * Calculates the sum of the numbers in a list using 'while'
     * @param list List<Integer>
     * @return int sum of the elements
     */
    public static int sumWhile(List<Integer> list){
        int sum=0;
        Iterator<Integer> iterator = list.iterator();

        while(iterator.hasNext()){
            sum=sum+iterator.next();
        }

        return sum;
    }

    /**
     * Finds and prints the first 20 leap years
     */
    public static void findLeapYears(){
        int counter=0;
        int year=2021;
        List<Integer> leapYears = new ArrayList<>();

        while (counter<20){
            if (year%400==0) {
                leapYears.add(year);
                counter++;
            }
            if (year%4==0 && year %100!=0) {
                leapYears.add(year);
                counter++;
            }

            year++;
        }

        System.out.println("Leap years are : "+leapYears.toString());
    }

    /**
     * Makes all the elements of a String list lowercase
     * @param list List<String>
     * @return List<String>, all elements lowercase
     */
    public static List<String> toLower(List<String> list){
        List<String> lowered = new ArrayList<>();
        for (String s:
             list) {
            lowered.add(s.toLowerCase());
        }

        return lowered;
    }

    /**
     * Doubles the elements of a List <Integer>
     * @param list List<Integer>
     * @return List<Integer> with all original elements doubled
     */
    public static List<Integer> doubleNumber(List<Integer> list){
        List<Integer> doubledList = new ArrayList<>();
        for (Integer n:
             list) {
            doubledList.add(n*2);
        }

        return doubledList;
    }



}