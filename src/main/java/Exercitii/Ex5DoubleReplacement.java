package Exercitii;

//  5. Write a method that iterates through an array or list of numbers and replaces the
//  current number with it’s double.

import java.util.ArrayList;

public class Ex5DoubleReplacement {

    public void ReplaceNumberWithDouble(int numberOfElements) {
        ArrayList<Integer> myList = new ArrayList<Integer>();

        // Generate a list of number from 1 to numberOfElements
        for (int i = 1; i <= numberOfElements; i++) {
            myList.add(i);
        }
        System.out.println("Array before replacement: " + myList);

        for (int i = 0; i < myList.size(); i++) {
            myList.set(i, myList.get(i) + myList.get(i));
        }

        System.out.println("Array after replacement: " + myList);
    }
}
