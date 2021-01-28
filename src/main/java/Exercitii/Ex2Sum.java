package Exercitii;

//2. Write three functions that compute the sum of the numbers in a list:
// using a for-loop, a for-each-loop and a while-loop

import java.util.ArrayList;

public class Ex2Sum {
    public void ForLoopSum(int numberOfElements) {
        ArrayList<Integer> myList = new ArrayList<Integer>();

        // Generate a list of number from 1 to numberOfElements
        for (int i = 1; i <= numberOfElements; i++) {
            myList.add(i);
        }

        int sum = 0;
        // Sum the elements into the sum variable using a for loop
        for (int i = 0; i < myList.size(); i++) {
            sum += myList.get(i);
        }

        System.out.println("The sum of the array using a for loop is: " + sum);
    }

    public void ForEachSum(int numberOfElements) {
        ArrayList<Integer> myList = new ArrayList<Integer>();
        // Generate a list of number from 1 to numberOfElements
        for (int i = 1; i <= numberOfElements; i++) {
            myList.add(i);
        }

        int sum = 0;
        for (int number : myList) {
            sum += number;
        }

        System.out.println("The sum of the array using a for each loop is: " + sum);
    }

    public void WhileLoopSum(int numberOfElements) {
        ArrayList<Integer> myList = new ArrayList<Integer>();
        // Generate a list of number from 1 to numberOfElements
        for (int i = 1; i <= numberOfElements; i++) {
            myList.add(i);
        }

        int sum = 0;
        int i = 0;
        while (i != myList.size()) {
            sum += myList.get(i);
            i++;
        }
        System.out.println("The sum of the array using a while loop is: " + sum);
    }
}
