import Day3Exercises.*;

public class Main {

    public static void main(String[] args) {

        // Day2 Exercises;
        doDay2Exercises();

        // Day3 Exercises;
        doDay3Exercises();
    }

    /**
     * 1. Given n, a natural number, implement a method that for each number from 1 to n will return:
     * • 3M if the number is divided by 3
     * • 5M if the number is divided by 5
     * • the number if the number is not divided by 3 or by 5
     * • 3M5M if the number is divide with both 3 and 5
     * 2. Write three functions that compute the sum of the numbers in a list: using a for-loop, a for-each-loop and a
     * while-loop
     * 3. Write a method that prints the next 20 leap years.
     * 4. Write a method that iterates through a list of Strings and makes them lowercase
     * 5. Write a method that iterates through an array or list of numbers and replaces the current number with it’s
     * double.
     */
    public static void doDay2Exercises() {

        System.out.println("__________Day2 Exercises__________");
        Day2Exercises.Ex1.doEx1();
        Day2Exercises.Ex2.doEx2();
        Day2Exercises.Ex3.doEx3();
        Day2Exercises.Ex4.doEx4();
        Day2Exercises.Ex5.doEx5();
        System.out.println();
    }

    /**
     * 1. Write the following classes:
     * a) A Plant abstract class with the field: oxygenProduction (mandatory for an object)
     * b) A Fructiferous interface with the field: color and a method getTimeToHarvest
     * c) An Orange class that extends Plant and Fructiferous with the fields: age, height
     * d) A Pinidae class that extends Plant with a public field numberOfSpecies equal to 50, with the method
     * getGrowthEnvironment that returns mountain
     * e) A Cedar class that extends Pinidae with an overridden field numberOfSpecies equal to 10 and a method
     * getGrowthEnvironment that return mountain and Mediterranean
     * f) An Eatable interface that will be extended by both Orange and Cedar class with a method isEatable
     * g) Create an object: An orange tree, aged 10, of height 5, that is eatable, the time to harvest is August and an
     * oxygen production of 50
     * h) Create an object: A Cedar tree having a reference type of Pinidae, with an oxygen production of 200, not
     * eatable. Print the field number of species and the result of the getGrowthEnvironment method.
     * i) Implement a way to create a Rose object
     */
    public static void doDay3Exercises() {

        System.out.println("__________Day3 Exercises__________");

        Orange orangeTree = new Orange(10, 5, 50);
        System.out.println(orangeTree.toString() + "\n");

        Pinidae cedarTree = new Cedar(200);
        System.out.println(cedarTree.toString());
        System.out.println("Number of species:  " + cedarTree.getNumberOfSpecies());
        System.out.println("Growth Environment: " + cedarTree.getGrowthEnvironment() + "\n");

        Plant rose = new Rose("red", "Louis Philippe Rose", 10);
        System.out.println(rose.toString());
    }
}
