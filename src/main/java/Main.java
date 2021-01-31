import Day3Exercises.*;

public class Main {

    public static void main(String[] args) {

        // Day2 Exercises;
        doDay2Exercises();

        // Day3 Exercises;
        doDay3Exercises();
    }

    public static void doDay2Exercises() {

        System.out.println("__________Day2 Exercises__________");
        Day2Exercises.Ex1.doEx1();
        Day2Exercises.Ex2.doEx2();
        Day2Exercises.Ex3.doEx3();
        Day2Exercises.Ex4.doEx4();
        Day2Exercises.Ex5.doEx5();
        System.out.println();
    }

    public static void doDay3Exercises() {

        System.out.println("__________Day3 Exercises__________");

        Orange orangeTree = new Orange(10, 5, 50);
        System.out.println(orangeTree.toString() + "\n");

        Pinidae cedarTree = new Cedar(200);
        System.out.println(cedarTree.toString());
        System.out.println("Number of species:  " + cedarTree.getNumberOfSpecies());
        System.out.println("Growth Environment: " + cedarTree.getGrowthEnvironment() + "\n");

        Plant rose = new Rose("red", "Louis Philippe Rose" ,10);
        System.out.println(rose.toString());
    }
}
