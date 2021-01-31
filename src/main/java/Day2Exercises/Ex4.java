package Day2Exercises;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Ex4 {
    /**
     * 4. Write a method that iterates through a list of Strings and makes them lowercase
     */
    public static void doEx4() {

        List<String> listOfStrings = Arrays.asList("School", "OF", "AutoMATION", "ENDaVA");

        System.out.println("Initial: " + listOfStrings);
        listOfStrings = lowercaseStrings(listOfStrings);
        System.out.println("Final:   " + listOfStrings);
        System.out.println();

    }


    /**
     * @param listOfStrings a list of Strings
     * @return the initial list with all the Strings lowercase
     */
    private static List<String> lowercaseStrings(List<String> listOfStrings) {

        return listOfStrings.stream().map(String::toLowerCase).collect(Collectors.toList());
    }
}
