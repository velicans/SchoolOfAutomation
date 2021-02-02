package oop.plants;

public class PlantApp {

    public static void main(String[] args) {
        Orange orange = new Orange(50, 10, 5.00);
        System.out.println(orange);

        Pinidae cedarTree = new Cedar(200);
        System.out.println(cedarTree);
        System.out.println("Cedar Number of Species: " + cedarTree.getNumberOfSpecies());
        System.out.println("Cedar Growth Environment: " + cedarTree.getGrowthEnvironment());

        Rose pinkRose = new Rose(100, 15);
        System.out.println(pinkRose);

    }

}
