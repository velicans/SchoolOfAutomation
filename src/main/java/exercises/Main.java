package exercises;

import java.util.List;

public class Main {

    public static void main(String[] args) {
        System.out.println("Division by 3 or 5");
        Divisor3M5M.isDivisibleBy3M5M();
        System.out.println("_________________________");

        System.out.println("Sum of numbers - 3 ways");
        List<Integer> numbersList = List.of(1, 3, 4, 7, 9);
        System.out.println(SumNumbers.sumWithFor(numbersList));
        System.out.println(SumNumbers.sumWithEnhancedFor(numbersList));
        System.out.println(SumNumbers.sumWithWhile(numbersList));
        System.out.println("_________________________");

        System.out.println("Leap Years");
        LeapYear.printNextLeapYears(2020, 20);
        System.out.println("\n_________________________");

        System.out.println("Lower Case Strings");
        System.out.println(LowerCaseStrings.makeStringsLowerCase(List.of("lAPte", "UNT", "CARNE", "pAIne")));
        System.out.println("_________________________");

        System.out.println("Double of Numbers");
        System.out.println(DoubleOfNumbers.makeDoubleNumberList(List.of(1, 2, 3, 5, 15)));
        System.out.println("_________________________");

        System.out.println("String Anagrams");
        System.out.println(StringAnagram.isAnagram("taciturni", "tractiuni"));
    }
}