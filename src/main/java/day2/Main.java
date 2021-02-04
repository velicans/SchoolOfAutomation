package day2;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        System.out.println("Exercise 1: ");
        ex1();
        System.out.println("Exercise 2: ");
        ex2();
        System.out.println("Exercise 3: ");
        ex3();
        System.out.println("Exercise 4: ");
        ex4();
        System.out.println("Exercise 5: ");
        ex5();
    }


    public static void ex1() {

//  1. Given n, a natural number, implement a method that for each number from 1 to n will return:
//	• 3M if the number is divided by 3
//	• 5M if the number is divided by 5
//	• the number if the number is not divided by 3 or by 5
//	• 3M5M if the number is divide with both 3 and 5

        Scanner sc = new Scanner(System.in);
        System.out.println("n: ");
        int n = sc.nextInt();
        System.out.println("n= " + n);
        System.out.println(checkForDividedNumbers(n));
    }

    public static ArrayList<Object> checkForDividedNumbers(int n) {
        ArrayList<Object> listOfNumbers = new ArrayList<Object>();
        for (int i = 1; i <= n; i++) {
            if ((i % 3 == 0) && (i % 5 == 0)) {
                listOfNumbers.add("3M5M");
            } else if (i % 3 == 0) {
                listOfNumbers.add("3M");
            } else if (i % 5 == 0) {
                listOfNumbers.add("5M");
            } else {
                listOfNumbers.add(i);
            }
        }
        return listOfNumbers;
    }

    public static void ex2() {
// 2. Write three functions that compute the sum of the numbers in a list: using a for-loop,
// a for-each-loop and a while-loop

        ArrayList<Integer> list = new ArrayList<Integer>();
        list.add(5);
        list.add(7);
        list.add(20);

        System.out.println("Sum using for loop: " + sumUsingForLoop(list));
        System.out.println("Sum using foreach loop: " + sumUsingForeachLoop(list));
        System.out.println("Sum using while loop: " + sumUsingWhileLoop(list));
    }

    public static int sumUsingForLoop(ArrayList<Integer> list) {
        int sum = 0;
        for (int i = 0; i < list.size(); i++) {
            sum += list.get(i);
        }
        return sum;
    }

    public static int sumUsingForeachLoop(ArrayList<Integer> list) {
        int sum = 0;
        for (int item : list) {
            sum += item;
        }
        return sum;
    }

    public static int sumUsingWhileLoop(ArrayList<Integer> list) {
        int sum = 0;
        int count = 0;
        while (list.size() > count) {
            sum += list.get(count);
            count++;
        }
        return sum;
    }

    public static void ex3() {
//  3. Write a method that prints the next 20 leap years.

        System.out.println(nextLeapYears(2021));
        System.out.println(nextLeapYears(2056));
    }

    public static ArrayList<Integer> nextLeapYears(int year) {
        int count = 0;
        ArrayList<Integer> listLeapYears = new ArrayList<Integer>();
        year++;
        while (count < 20) {
            if ((year % 400 == 0) || ((year % 4 == 0) && (year % 100 != 0))) {
                listLeapYears.add(year);
                count++;
                year += 4;
            } else {
                year++;
            }
        }
        return listLeapYears;
    }

    public static void ex4() {
// 4. Write a method that iterates through a list of Strings and makes them lowercase

        ArrayList<String> list = new ArrayList<String>();
        list.add("ciocolata");
        list.add("NUTELLA");
        list.add("finetTi");

        System.out.println("List before lowercase: \n" + list);
        lowercaseList(list);
        System.out.println("List after lowercase: \n" + list);

    }

    public static ArrayList<String> lowercaseList(ArrayList<String> list) {
        for (int i = 0; i < list.size(); i++) {
            list.set(i, list.get(i).toLowerCase());
        }
        return list;
    }

    public static void ex5() {
// 5. Write a method that iterates through an array or list of numbers and replaces the current number
// with it’s double.

        ArrayList<Integer> list = new ArrayList<Integer>();
        list.add(5);
        list.add(7);
        list.add(20);

        System.out.println("List before update: \n" + list);
        doubleList(list);
        System.out.println("List after update: \n" + list);

    }

    public static ArrayList<Integer> doubleList(ArrayList<Integer> list) {
        for (int i = 0; i < list.size(); i++) {
            list.set(i, list.get(i) * 2);
        }
        return list;
    }
}